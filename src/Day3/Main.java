package Day3;

import Day3.model.Lecturer;
import Day3.model.Subject;
import Day3.service.TeachingManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input the number of lecturer: ");
        int n = sc.nextInt();
        sc.nextLine();
        Lecturer[] lecturers = new Lecturer[n];
        for(int i = 0; i < n; i++){
            lecturers[i] = Lecturer.inputLecturer(i + 1, sc);
        }
        System.out.println("--------------------------");
        System.out.print("input the number of subject: ");
        int m = sc.nextInt();
        sc.nextLine();
        Subject[] subjects = new Subject[m];
        for(int i = 0; i < m; i++){
            subjects[i] = Subject.inputSubject(i + 1, sc);
        }
        System.out.println("--------------------------");
        System.out.println("lecturer list:");
        for(Lecturer l : lecturers){
            System.out.println(l);
        }
        System.out.println("--------------------------");
        System.out.println("subject list:");
        for(Subject s : subjects){
            System.out.println(s);
        }
        System.out.println("--------------------------");
        TeachingManagement teachingManagement = new TeachingManagement(lecturers, subjects);
        teachingManagement.lecturerManagement();
        for(Lecturer lecturer : lecturers){
            teachingManagement.teachingScheduleTable(lecturer);
            System.out.println("--------------------------");
        }
        teachingManagement.PayrollTable();
    }
}
