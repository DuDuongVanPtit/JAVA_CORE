package Day3.model;

import java.util.Scanner;

public class Lecturer {
    private String lectureId;
    private String name;
    private String address;
    private String phoneNumber;
    private String qualification;
    private int taughtClasses = 0;
    private int[] amountPerSubject;
    private int[] subjectId;
    private int taughtHours = 0;

    public Lecturer(int lectureId, String name, String address, String phoneNumber, String qualification) {
        String a = "" + lectureId;
        while(a.length() < 3){
            a = "0" + a;
        }
        this.lectureId = a;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.qualification = qualification;
        this.amountPerSubject = new int[10000];
        this.subjectId = new int[10000];
    }

    public int getSubjectId(int index) {
        return subjectId[index];
    }

    public void setSubjectId(int taughtClasses, int subjectId) {
        this.subjectId[taughtClasses] = subjectId;
    }

    public int getAmountPerSubject(int index) {
        return amountPerSubject[index];
    }

    public void setAmountPerSubject(int index, int amount) {
        this.amountPerSubject[index] = amount;
    }

    public int getTaughtHours() {
        return taughtHours;
    }

    public void setTaughtHours(int taughtHours) {
        this.taughtHours = taughtHours;
    }

    public int getTaughtClasses() {
        return taughtClasses;
    }

    public void setTaughtClasses(int taughtClasses) {
        this.taughtClasses = taughtClasses;
    }

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public static Lecturer inputLecturer(int lecturerId, Scanner scanner){
        System.out.println("Input 4 line to add a new lecturer");
        System.out.print("Lecturer name: ");
        String a = scanner.nextLine();
        System.out.print("Lecturer address: ");
        String b = scanner.nextLine();
        System.out.print("Lecturer phone number: ");
        String c = scanner.nextLine();
        System.out.print("Lecturer qualification: ");
        String d = null;
        while(true){
            System.out.print("Degree:\n");
            System.out.println("\t1: GS-TS\n\t2: PGS-TS\n\t3: GV\n\t4: TS");
            int type = scanner.nextInt();
            switch (type){
                case 1:
                    d = "GS-TS";
                    break;
                case 2:
                    d = "PGS-TS";
                    break;
                case 3:
                    d = "GV";
                    break;
                case 4:
                    d = "TS";
            }
            if(type == 1 || type == 2 || type == 3 || type == 4){
                break;
            }
            else System.out.println("please chose the correct degree number!");
        }
        Lecturer lecturer = new Lecturer(lecturerId, a, b, c, d);
        scanner.nextLine();
        return lecturer;
    }

    @Override
    public String toString() {
        return
                "lectureId: " + lectureId +
                " name: " + name +
                " address: " + address +
                " phoneNumber: " + phoneNumber +
                " qualification: " + qualification;
    }
}
