package pairmatching.domain;

public class StudentPair {
    public String studentA;
    public String studentB;
    public String studentC;

    public StudentPair(String studentA, String studentB) {
        this.studentA = studentA;
        this.studentB = studentB;
    }

    public StudentPair(String studentA, String studentB, String studentC){
        this.studentA = studentA;
        this.studentB = studentB;
        this.studentC = studentC;
    }
}
