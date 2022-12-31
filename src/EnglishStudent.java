public class EnglishStudent extends Student {
    private int termPaper;
    private int midTerm;
    private int finalExamGrade;
    private double finalAverage;

    final private int termPaperPer = 30;
    final private int midTremPer = 30;
    final private int finalPer = 40;

    public EnglishStudent(String fName, String lName, String[] data) {
        super(fName, lName, Subjects.valueOf(data[0]));
        this.termPaper = Integer.parseInt(data[1]);
        this.midTerm = Integer.parseInt(data[2]);
        this.finalExamGrade = Integer.parseInt(data[3]);

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
        return (this.termPaper*this.termPaperPer + midTerm*midTremPer + finalExamGrade*finalPer)/100.0;
    }

}
