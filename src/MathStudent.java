public class MathStudent extends Student {
    private int quiz1;
    private int quiz2;
    private int quiz3;
    private int quiz4;
    private int quiz5;
    private int test1;
    private int test2;
    private int finalExamGrade;
    private double finalAverage;

    final private int quizPer = 15;
    final private int test1Per = 30;
    final private int test2Per = 20;
    final private int finalPer = 35;

    public MathStudent(String fName, String lName, String[] data) {
        super(fName, lName, Subjects.valueOf(data[0]));
        this.quiz1 = Integer.parseInt(data[1]);
        this.quiz2 = Integer.parseInt(data[2]);
        this.quiz3 = Integer.parseInt(data[3]);
        this.quiz4 = Integer.parseInt(data[4]);
        this.quiz5 = Integer.parseInt(data[5]);
        this.test1 = Integer.parseInt(data[6]);
        this.test2 = Integer.parseInt(data[7]);
        this.finalExamGrade = Integer.parseInt(data[8]);

        this.finalAverage = calculateFinalAverage();
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

    public double calculateFinalAverage() {
        int quizTotal = (quiz1 + quiz2 + quiz3 + quiz4 + quiz5)/5;
        return (quizTotal*quizPer + test1*test1Per + test2*test2Per + finalExamGrade*finalPer)/100.0;
    }
}
