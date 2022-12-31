public class ScienceStudent extends Student {
    private int attendance;
    private int project;
    private int midTerm;
    private int finalExamGrade;
    private double finalAverage;

    final private int attPer = 10;
    final private int projPer = 30;
    final private int midPer = 30;
    final private int finPer = 30;

    public ScienceStudent(String fName, String lName, String[] data) {
        super(fName, lName, Subjects.valueOf(data[0]));
        this.attendance = Integer.parseInt(data[1]);
        this.project = Integer.parseInt(data[2]);
        this.midTerm = Integer.parseInt(data[3]);
        this.finalExamGrade = Integer.parseInt(data[4]);

        this.finalAverage = this.calculateFinalAverage();
    }

    public int getFinalExamGrade() {
        return finalExamGrade;
    }
    
    public double getFinalAverage() {
        return finalAverage;
    }

    public String getLetterGrade() {
        return super.getLetterGrade();
    }
    
    private double calculateFinalAverage() {
        return (attendance*attPer + project*projPer + midTerm*midPer + finalExamGrade*finPer)/100.0;
    }
}
