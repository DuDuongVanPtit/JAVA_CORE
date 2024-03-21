package Day3.model;

import java.util.Scanner;

public class Subject {
    private static final double TUITION_FEE_PER_HOUR = 100.0;
    private String subjectId;
    private String subjectName;
    private int totalHours;
    private int theoryHours;
    private double feePerHour;

    public Subject(int subjectId, String subjectName, int totalHours, int theoryHours) {
        String a = "" + subjectId;
        while(a.length() < 3){
            a = "0" + a;
        }
        this.subjectId = a;
        this.subjectName = subjectName;
        this.totalHours = totalHours;
        this.theoryHours = theoryHours;
        this.feePerHour = ((((totalHours - theoryHours) * 0.7) + theoryHours) / totalHours) * TUITION_FEE_PER_HOUR;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public int getTheoryHours() {
        return theoryHours;
    }

    public void setTheoryHours(int theoryHours) {
        this.theoryHours = theoryHours;
    }

    public double getFeePerHour() {
        return feePerHour;
    }

    public void setFeePerHour() {
        this.feePerHour = feePerHour;
    }
    public static Subject inputSubject(int sbjId, Scanner scanner){
        System.out.println("input 3 line to add a new lecturer");
        System.out.print("Subject name: ");
        String a = scanner.nextLine();
        System.out.print("Subject total hours: ");
        int b = scanner.nextInt();
        System.out.print("Subject theory hours: ");
        int c = scanner.nextInt();
        scanner.nextLine();
        Subject subject = new Subject(sbjId, a, b, c);
        return subject;
    }

    @Override
    public String toString() {
        return
                "subjectId: " + subjectId + " subjectName: " + subjectName + " totalHours: " + totalHours + " theoryHours: " + theoryHours + " feePerHour: " + feePerHour;
    }
}
