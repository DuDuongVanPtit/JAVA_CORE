package Day3;

import Day2.model.Book;
import Day2.model.Reader;
import Day2.service.LibraryManagement;
import Day3.model.Lecturer;
import Day3.model.Subject;
import Day3.service.TeachingManagement;

import java.util.Scanner;

public class Main {
    static Lecturer[] lecturers = new Lecturer[10000];
    static Subject[] subjects = new Subject[10000];
    public static int lecturerCnt = 0;
    public static int subjectCnt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("input 0 to finish\n" +
                    "input 1 to add an new subject list\n" +
                    "input 2 to add an new lecturer list\n" +
                    "input 3 to create an teaching schedule table\n" +
                    "input 4 to sort teaching schedule table by lecturer name\n" +
                    "input 5 to sort teaching schedule table by taught hours (decrease)\n" +
                    "input 6 create a payroll table");
            System.out.println("--------------------");
            int choice = scanner.nextInt();
            if (choice == 0) break;
            switch (choice){
                case 1:
                    System.out.print("input the number of subject: ");
                    int m = scanner.nextInt();
                    scanner.nextLine();
                    for(int i = 0; i < m; i++){
                        Subject subject = Subject.inputSubject(subjectCnt + 1, scanner);
                        subjects[subjectCnt++] = subject;
                    }
                    System.out.println("--------------------------");
                    System.out.println("subject list:");
                    int j = 0;
                    while(subjects[j] != null){
                        System.out.println(subjects[j]);
                        j++;
                    }
                    System.out.println("--------------------------");
                    break;
                case 2:
                    System.out.print("input the number of lecturer: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    for(int i = 0; i < n; i++){
                        Lecturer lecturer = Lecturer.inputLecturer(lecturerCnt + 1, scanner);
                        lecturers[lecturerCnt++] = lecturer;
                    }
                    System.out.println("--------------------------");
                    System.out.println("lecturer list:");
                    int k = 0;
                    while(lecturers[k] != null){
                        System.out.println(lecturers[k]);
                        k++;
                    }
                    System.out.println("--------------------------");
                    break;
                case 3:
                    TeachingManagement.alert(lecturers, subjects);
                    if(lecturers[0] != null && subjects[0] != null){
                        TeachingManagement teachingManagement = new TeachingManagement(lecturers, subjects);
                        teachingManagement.lecturerManagement();
                        for(int i = 0; i < lecturerCnt; i++){
                            teachingManagement.teachingScheduleTable(lecturers[i]);
                        }
                    }
                    break;
                case 4:
                    TeachingManagement.alert(lecturers, subjects);
                    if(lecturers[0] != null && subjects[0] != null){
                        TeachingManagement teachingManagement = new TeachingManagement(lecturers, subjects);
                        teachingManagement.sortByLecturerName();
                    }
                    break;
                case 5:
                    TeachingManagement.alert(lecturers, subjects);
                    if(lecturers[0] != null && subjects[0] != null){
                        TeachingManagement teachingManagement = new TeachingManagement(lecturers, subjects);
                        teachingManagement.sortByTaughtHours();
                    }
                    break;
                case 6:
                    TeachingManagement.alert(lecturers, subjects);
                    if(lecturers[0] != null && subjects[0] != null){
                        TeachingManagement teachingManagement = new TeachingManagement(lecturers, subjects);
                        teachingManagement.PayrollTable();
                    }

            }

        }
    }
}
