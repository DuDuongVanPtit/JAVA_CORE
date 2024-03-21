package Day2.model;

import Day2.Main;

import java.util.Scanner;

public class Reader {
    private String readerId, name, address, phoneNumber, readerType;
    private int borrowBookCnt = 0;

    private int[] borrowedBooks;


    public Reader(String readerId, String name, String address, String phoneNumber, String readerType) {
        this.readerId = readerId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.readerType = readerType;
        this.borrowedBooks = new int[10000];
    }

    public int getBorrowedBooks(int index) {
        return borrowedBooks[index];
    }

    public void setBorrowedBooks(int borrowedBookCnt, int bookId) {
        this.borrowedBooks[borrowedBookCnt] = bookId;
    }

    public int getBorrowBookCnt() {
        return borrowBookCnt;
    }

    public void setBorrowBookCnt(int borrowBookCnt) {
        this.borrowBookCnt = borrowBookCnt;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
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

    public String getReaderType() {
        return readerType;
    }

    public void setReaderType(String readerType) {
        this.readerType = readerType;
    }

    public static Reader inputReaders(int readerId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input 4 lines to insert a new reader");

        String a = "" + readerId;
        while(a.length() < 5){
            a = "0" + a;
        }

        System.out.print("Reader name:");
        String b = scanner.nextLine();
        System.out.print("Reader address:");
        String c = scanner.nextLine();
        System.out.print("Reader phone number:");
        String d = scanner.nextLine();
        String e = null;
        while(true){
            System.out.print("chose reader type:\n");
            System.out.println("\t1: pupil\n\t2: student\n\t3: teacher");
            int type = scanner.nextInt();
            switch (type){
                case 1:
                    e = "pupil";
                    break;
                case 2:
                    e = "student";
                    break;
                case 3:
                    e = "teacher";
                    break;
            }
            if(type == 1 || type == 2 || type == 3){
                break;
            }
            else System.out.println("please chose the correct type of reader!");
        }
        scanner.nextLine();
        Reader reader =
                new Reader(a, b, c, d, e);
        System.out.println("--------------------");
        return reader;
    }
    @Override
    public String toString() {
        return
                "readerId='" + readerId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", readerType='" + readerType + '\'';
    }
}
