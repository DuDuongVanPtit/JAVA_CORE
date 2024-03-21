package Day3;

import java.util.Scanner;

public class TeachingManagement {
    private static final int MAX_CLASSES_PER_SUBJECT = 3;
    private static final int MAX_TOTAL_TAUGHT_HOURS = 200;
    private Lecturer[] lecturers;
    private Subject[] subjects;
    private int[][] listSbjId;//lưu id cuả môn học mà các giảng viên dạy
    private int[] taughtHours;//số tiết giảng dạy của mỗi giảng viên
    private int[] taughtClasses;//số lớp giảng dạy của mỗi giảng viên

    public TeachingManagement(Lecturer[] lecturers, Subject[] subjects) {
        this.lecturers = lecturers;
        this.subjects = subjects;
        this.listSbjId = new int[lecturers.length + 5][MAX_TOTAL_TAUGHT_HOURS];
        this.taughtHours = new int[lecturers.length + 5];
        this.taughtClasses = new int[lecturers.length + 5];
    }

    public void lecturerManagement(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < lecturers.length; i++){
            System.out.println("nhập thông tin giảng dạy cho giảng viên " + lecturers[i].getName());
            int lecturerId = Integer.parseInt(lecturers[i].getLectureId());
            int[] cntTm = new int[subjects.length + 1];
            int cnt = 0;
            while (taughtHours[lecturerId] < MAX_TOTAL_TAUGHT_HOURS){
                System.out.println("nhập mã môn học để cho giảng viên dạy(nhập 0 để hoàn thành): ");
                boolean check = false;
                String sbj = scanner.nextLine();
                if(sbj.equals("0")) break;
                Subject tmp = null;
                for(Subject s : subjects){
                    if(s.getSubjectId().equals(sbj)){
                        tmp = s;
                        check = true;
                        break;
                    }
                }
                if(check){
                    if(taughtHours[lecturerId] + tmp.getTotalHours() <= 200 || cntTm[Integer.parseInt(sbj)] < 3){
                        if(taughtHours[lecturerId] + tmp.getTotalHours() <= 200 && cntTm[Integer.parseInt(sbj)] < 3){
                            taughtHours[lecturerId] += tmp.getTotalHours();
                            cntTm[Integer.parseInt(sbj)]++;
                            taughtClasses[lecturerId]++;
                            listSbjId[lecturerId][cnt++] = Integer.parseInt(sbj);
                            System.out.println("thành công.");
                        }
                        else if(taughtHours[lecturerId] + tmp.getTotalHours() > 200){
                            System.out.println("không thành công, giảng viên không được dạy quá 200 tiết học!");
                        }
                        else if(cntTm[Integer.parseInt(sbj)] >= MAX_CLASSES_PER_SUBJECT){
                            System.out.println("không thành công, giảng viên không được dạy quá 3 lớp cho 1 môn học!");
                        }

                    }
                }
                else{
                    System.out.println("không thành công, vui lòng nhập đúng mã môn học!");
                }
            }
            System.out.println("--------------------------");
        }
    }

    public void teachingScheduleTable(Lecturer lecturer){
        System.out.println("các lớp được giảng viên " + lecturer.getName() + " giảng dạy: ");
        int lecturerId = Integer.parseInt(lecturer.getLectureId());
        int[] c = new int[subjects.length + 5];

        for (int j = 0; j < taughtClasses[lecturerId]; j++) {
            int subjectId = listSbjId[lecturerId][j];
            c[subjectId]++;
        }
        for(int j = 0; j < c.length; j++){
            if(c[j] != 0){
                Subject subject = findSubjectById(j);
                System.out.println(" - " + subject.getSubjectName() + " x " + c[j]);
            }
        }
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
        for(int i = 0; i < lecturers.length - 1; i++){
            for(int j = i + 1; j < lecturers.length; j++){
                if(lecturers[i].getName().compareTo(lecturers[j].getName()) > 0){
                    Lecturer tmp = lecturers[i];
                    lecturers[i] = lecturers[j];
                    lecturers[j] = tmp;
                }
            }
        }
        for(Lecturer l : lecturers){
            System.out.println(l);
        }
        System.out.println("--------------------");
    }
    public void sortByTaughtHours(){
        for(int i = 0; i < lecturers.length - 1; i++){
            int lecturerIId = Integer.parseInt(lecturers[i].getLectureId());
            for(int j = i + 1; j < lecturers.length; i++){
                int lecturerJId = Integer.parseInt(lecturers[j].getLectureId());
                if(taughtHours[lecturerIId] < taughtHours[lecturerJId]){
                    Lecturer tmp = lecturers[i];
                    lecturers[i] = lecturers[j];
                    lecturers[j] = tmp;
                }
            }
        }
        for(Lecturer l : lecturers){
            System.out.println(l + " " + taughtHours[Integer.parseInt(l.getLectureId())]);
        }
        System.out.println("--------------------");
    }

    public void PayrollTable(){
        System.out.println("PAYROLL TABLE");
        for(Lecturer l : lecturers){
            int lecturerId = Integer.parseInt(l.getLectureId());
            double total = 0.0;

            int[] c = new int[subjects.length + 5];
            for (int j = 0; j < taughtClasses[lecturerId]; j++) {
                int subjectId = listSbjId[lecturerId][j];
                c[subjectId]++;
            }
            for(int j = 0; j < c.length; j++){
                if(c[j] != 0){
                    Subject subject = findSubjectById(j);
                    total += (subject.getFeePerHour() * subject.getTotalHours()) * (double)c[j];
                }
            }
            System.out.println("tiền lương của giảng viên " + l.getName() + " là: " + total);

        }
    }
}
