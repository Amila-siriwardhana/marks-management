public class Student {
    private String firstName;
    private String lastName;
    private Subjects subject;
    
    public Student(String firstName, String lastName, Subjects subject) {
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.subject = subject;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Subjects getSubject() {
        return subject;
    }

    public int getFinalExamGrade() {
        return 0;
    }

    public double getFinalAverage() {
        return 0;
    }

    public String getLetterGrade() {
        double avg = this.getFinalAverage();
        String grade = "";
        if (avg >= 90 && avg < 100) {
            grade = "A";
        } else if (avg >= 80 && avg < 90) {
            grade = "B";
        } else if (avg >= 70 && avg < 80) {
            grade = "C";
        } else if (avg >= 60 && avg < 70) {
            grade = "D";
        } else if (avg >= 50 && avg < 60) {
            grade = "E";
        } else if (avg >= 40 && avg < 50) {
            grade = "F";
        } else if (avg >= 30 && avg < 40) {
            grade = "G";
        }  else if (avg >= 20 && avg < 30) {
            grade = "I";
        } else if (avg >= 10 && avg < 20) {
            grade = "J";
        } else if (avg >= 0 && avg < 10) {
            grade = "K";
        }
        return grade;
    }

}
