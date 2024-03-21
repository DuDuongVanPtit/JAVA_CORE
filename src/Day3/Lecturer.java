package Day3;

import java.util.Scanner;

public class Lecturer {
    private String lectureId, name, address, phoneNumber, qualification;

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
        System.out.println("input 4 line to add a new lecturer");
        System.out.print("Lecturer name: ");
        String a = scanner.nextLine();
        System.out.print("Lecturer address: ");
        String b = scanner.nextLine();
        System.out.print("Lecturer phone number: ");
        String c = scanner.nextLine();
        System.out.print("Lecturer qualification: ");
        String d = scanner.nextLine();
        Lecturer lecturer = new Lecturer(lecturerId, a, b, c, d);
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
