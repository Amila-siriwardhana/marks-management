import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App {

	public static void main(String[] args) throws Exception {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter file path for student data txt file: ");
		String filePath = inputScanner.nextLine();
		inputScanner.close();

		readAndStoreFileData(filePath);
	}


	private static void readAndStoreFileData(String filePath) {
		Data fileData = Data.getInstance();

		try {
			File file = new File(filePath);
			Scanner reader = new Scanner(file);
			fileData.setFilepath(filePath);

			int count = 0;
			if (reader.hasNextLine()) {
				count = Integer.parseInt(reader.nextLine());
				fileData.setCount(count);
			}
			Student[] students = new Student[count];

			for (int i = 0; reader.hasNextLine(); i++) {
				String[] name = reader.nextLine().trim().split(",");
				String[] data = reader.nextLine().trim().split(" ");

				switch (Subjects.valueOf(data[0])) {
					case English:
						students[i] = new EnglishStudent(name[1], name[0], data);
						break;
					case Science:
						students[i] = new ScienceStudent(name[1], name[0], data);
						break;
					case Math:
						students[i] = new MathStudent(name[1], name[0], data);
						break;
					default:
						break;
				}
			}
			fileData.setData(students);
			reader.close();

			if (students != null) {
				generateSummaryReport();
			}
		} catch (FileNotFoundException e) {
			printError(e);
		}
	}

	

	private static void generateSummaryReport() {
		Student[] studentData = Data.getInstance().getData();
		Map<String, Integer> gradeCount = new TreeMap<>();

		String outEng = "";
		String outSci = "";
		String outMat = "";
		for (int j = 0; j < studentData.length; j++) {
			Student student = studentData[j];
			gradeCount.compute(student.getLetterGrade(), (k, v) -> (v == null) ? 1 : v + 1);

			Subjects sub = student.getSubject();
			String studentDataString = String.format(" %-51s| %-20d| %-17.2f| %-10s\n", student.getFullName(), student.getFinalExamGrade(), student.getFinalAverage(), student.getLetterGrade());
			switch (sub) {
				case English:
					outEng += studentDataString;
					break;
				case Science:
					outSci += studentDataString;
					break;
				case Math:
					outMat += studentDataString;
				default:
					break;
			}
		}

		String seperator = "";
		for (int i = 0; i <= 100; i++) {
			seperator += "-";
		}
		String outHeader = String.format("%s\n %-51s| %-20s| %-17s| %-10s\n%s\n", seperator, "Student Name", "Final Exam Grade", "Final Average", "Grade", seperator);
		String dataSummaryString = "-- Student Marks Summary Report --\n\n"
				+ "Total no. of students - " + Data.getInstance().getCount()
				+ "\n\nEnglish - \n" + outHeader + outEng + seperator
				+ "\n\n\nScience - \n" + outHeader + outSci + seperator 
				+ "\n\n\nMath - \n" + outHeader + outMat + seperator;

		String gradeSummaryString = "\n\nGrade Summary for all students - \n";
		for (Map.Entry<String, Integer> g : gradeCount.entrySet()) {
			gradeSummaryString += String.format("%s - %d\n", g.getKey(), g.getValue());
		}

		writeToFile(dataSummaryString + gradeSummaryString);
	}	


	private static void writeToFile(String dataString) {
		try {
			File outFile = new File(Data.getInstance().getFilepath().replace(".txt", "-summaryReport.txt"));
			if (outFile.createNewFile()) {
				System.out.println("New file created: " + outFile.getName());
			} else {
				System.out.println("Output file " + outFile.getName() + " already exists. Overwriting data");
			}

			try {
				FileWriter myWriter = new FileWriter(outFile.getAbsoluteFile());
				myWriter.write(dataString);
				myWriter.close();
				System.out.println("Successfully wrote data to the file.");
			} catch (IOException e) {
				printError(e);
			}
		} catch (IOException e) {
			printError(e);
		}
	}


	private static void printError(Exception e) {
		System.out.println("An error occurred !!");
		System.out.println(e.getMessage());
	}
}
