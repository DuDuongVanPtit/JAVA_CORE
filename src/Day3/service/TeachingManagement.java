package Day3.service;

import Day3.Main;
import Day3.model.Lecturer;
import Day3.model.Subject;

import java.util.Scanner;

public class TeachingManagement {
    private static final int MAX_CLASSES_PER_SUBJECT = 3;
    private static final int MAX_TOTAL_TAUGHT_HOURS = 200;
    private Lecturer[] lecturers;
    private Subject[] subjects;

    public TeachingManagement(Lecturer[] lecturers, Subject[] subjects) {
        this.lecturers = lecturers;
        this.subjects = subjects;
    }

    public void lecturerManagement(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < Main.lecturerCnt; i++){
            System.out.println("Enter teaching information for lecturer " + lecturers[i].getName() + ":");
            int lecturerId = Integer.parseInt(lecturers[i].getLectureId());
            int[] cntTm = new int[subjects.length + 1];
            int cnt = 0;
            while (lecturers[i].getTaughtHours() <= MAX_TOTAL_TAUGHT_HOURS){
                if(lecturers[i].getTaughtHours() == 200){
                    System.out.println("Lecturer " + lecturers[i].getName() + " has registered for a total of 200 teaching hours.");
                    break;
                }
                System.out.print("Enter the subjectId for the lecturer to teach (enter 0 to finish): ");
                boolean check = false;
                String sbj = scanner.nextLine();
                if(sbj.equals("0")) break;
                Subject tmp = null;
                for(int j = 0; j < Main.subjectCnt; j++){
                    if(subjects[j].getSubjectId().equals(sbj)){
                        tmp = subjects[j];
                        check = true;
                        break;
                    }
                }
                if(check){
                    System.out.print("Enter the number of classes to teach for the subject with ID " + sbj + " : ");
                    int classAmount = scanner.nextInt();
                    scanner.nextLine();
                    if(lecturers[i].getTaughtHours() + tmp.getTotalHours() * classAmount <= 200 &&
                            lecturers[i].getAmountPerSubject(Integer.parseInt(sbj)) + classAmount <= 3){

                        lecturers[i].setTaughtHours(lecturers[i].getTaughtHours() + tmp.getTotalHours() * classAmount);
                        lecturers[i].setAmountPerSubject(Integer.parseInt(sbj),
                                lecturers[i].getAmountPerSubject(Integer.parseInt(sbj)) + classAmount);
                        lecturers[i].setTaughtClasses(lecturers[i].getTaughtClasses() + classAmount);
                        lecturers[i].setSubjectId(lecturers[i].getTaughtClasses(), Integer.parseInt(sbj));
                        System.out.println("Add successfully");
                    }
                    else if(lecturers[i].getTaughtHours() + tmp.getTotalHours() * classAmount > 200){
                        System.out.println("The lecturer can't teach more than 200 hours!");
                    }
                    else if(lecturers[i].getAmountPerSubject(Integer.parseInt(sbj)) + classAmount > 3){
                        System.out.println("The lecturer can't teach more than 3 classes for one subject!");
                    }
                }
                else{
                    System.out.println("Unsuccessful, please enter the correct subjectId!");
                }
            }
            System.out.println("--------------------------");
        }
    }

    public void teachingScheduleTable(Lecturer lecturer){
        System.out.println("The classes taught by lecturer " + lecturer.getName() + ":");
        int lecturerId = Integer.parseInt(lecturer.getLectureId());

        int[] c = new int[lecturer.getTaughtClasses() + 5];

        for (int j = 1; j <= lecturer.getTaughtClasses(); j++) {
            int subjectId = lecturer.getSubjectId(j);
            if(subjectId != 0){
                c[subjectId]++;
            }
        }
        for(int j = 1; j < c.length; j++){
            if(c[j] != 0){
                Subject subject = findSubjectById(j);
                System.out.println(" - " + subject.getSubjectName() + " x " + lecturer.getAmountPerSubject(j));
            }
        }
        System.out.println("--------------------");
    }

    public Subject findSubjectById(int sbjId){
        for(Subject s : subjects){
            if(Integer.parseInt(s.getSubjectId()) == sbjId){
                return s;
            }
        }
        return null;
    }

    public void sortByLecturerName(){
        for(int i = 0; i < Main.lecturerCnt - 1; i++){
            for(int j = i + 1; j < Main.lecturerCnt; j++){
                if(lecturers[i].getName().compareTo(lecturers[j].getName()) > 0){
                    Lecturer tmp = lecturers[i];
                    lecturers[i] = lecturers[j];
                    lecturers[j] = tmp;
                }
            }
        }
        for(int i = 0; i < Main.lecturerCnt; i++){
            System.out.println(lecturers[i]);
        }
        System.out.println("--------------------");
    }
    public void sortByTaughtHours(){
        for(int i = 0; i < Main.lecturerCnt - 1; i++){
            for(int j = i + 1; j < Main.lecturerCnt; j++){
                if(lecturers[i].getTaughtHours() < lecturers[j].getTaughtHours()){
                    Lecturer tmp = lecturers[i];
                    lecturers[i] = lecturers[j];
                    lecturers[j] = tmp;
                }
            }
        }
        for(int i = 0; i < Main.lecturerCnt; i++){
            System.out.println("Lecturer " + lecturers[i].getName() +"(" + lecturers[i].getLectureId() + ")"
                    + " has the number of teaching hours: "
                    + lecturers[i].getTaughtHours() + "h");
        }
        System.out.println("--------------------");
    }

    public void PayrollTable(){
        System.out.println("------PAYROLL TABLE-----");
        for(int i = 0; i < Main.lecturerCnt; i++){
            double total = 0.0;
            int[] c = new int[lecturers[i].getTaughtClasses() + 5];

            for (int j = 1; j <= lecturers[i].getTaughtClasses(); j++) {
                int subjectId = lecturers[i].getSubjectId(j);
                if(subjectId != 0){
                    c[subjectId]++;
                }
            }
            for(int j = 1; j < c.length; j++){
                if(c[j] != 0){
                    Subject subject = findSubjectById(j);
                    total += (subject.getFeePerHour() * subject.getTotalHours())
                            * (double)lecturers[i].getAmountPerSubject(j);
                }
            }
            System.out.println("The salary of lecturer " + lecturers[i].getName() + " is: " + total);
        }
        System.out.println("--------------------");
    }
    public static void alert(Lecturer[] lecturers, Subject[] subjects){
        if(lecturers[0] == null && subjects[0] == null){
            System.out.println("lecturer list and subject list are empty, please add information for them.");
        }
        else if(lecturers[0] == null){
            System.out.println("lecturer list is empty, please add information for it.");
        }
        else if(subjects[0] == null){
            System.out.println("subject list is empty, please add information for it.");
        }
    }
}
