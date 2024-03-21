package Day2.service;

import Day2.model.Book;
import Day2.model.Reader;

import java.util.Scanner;

public class LibraryManagement {
    private static final int MAX_BORROWED_BOOKS_PER_READER = 5;
    private static final int MAX_BORROWED_COPIES_PER_BOOK = 3;

    private Reader[] readers;
    private Book[] books;
    private int[] borrowedBookCounts; // the number of borrowed books for each reader
    private int[][] borrowedBooks; // store the list of bookIds that each reader has borrowed
    private int bookCnt;
    private int readerCnt;

    public LibraryManagement(Reader[] readers, Book[] books, int readerCnt, int bookCnt) {
        this.readers = readers;
        this.books = books;
        this.borrowedBookCounts = new int[MAX_BORROWED_BOOKS_PER_READER * MAX_BORROWED_COPIES_PER_BOOK + 5];
        this.borrowedBooks = new int[readerCnt + 5][MAX_BORROWED_BOOKS_PER_READER * MAX_BORROWED_COPIES_PER_BOOK + 5];
        this.bookCnt = bookCnt;
        this.readerCnt = readerCnt;
    }

    public static Book inputBooks(int bookId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input 4 lines to insert a new book");

        String a = "" + bookId;
        while(a.length() < 5){
            a = "0" + a;
        }

        System.out.print("Book name:");
        String b = scanner.nextLine();
        System.out.print("author:");
        String c = scanner.nextLine();
        System.out.print("major:");
        String d = scanner.nextLine();
        System.out.print("publication year:");
        String e = scanner.nextLine();
        Book book =
                new Book(a, b, c, d, e);
        System.out.println("--------------------");
        return book;
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
        System.out.print("Reader type:");
        String e = scanner.nextLine();
        Reader reader =
                new Reader(a, b, c, d, e);
        System.out.println("--------------------");
        return reader;
    }

//     Lập bảng quản lý mượn sách cho từng bạn đọc
    public void borrowBooks() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < readerCnt; i++) {
            System.out.println("input borrowing information for readers " + readers[i].getName() + ":");
            int count = 0;
            int[] cntTm = new int[bookCnt + 1]; // The number of books borrowed per book/individual
            while (count < MAX_BORROWED_BOOKS_PER_READER) {
                System.out.print("enter the bookId you want to borrow(enter 0 to finish): ");
                String bookId = scanner.nextLine();
                if(bookId.equals("0")) break;
                boolean check = false;
                for(int j = 0; j < bookCnt; j++){
                    if(books[j].getBookId().equals(bookId)){
                        check = true;
                        break;
                    }
                }
                if(check){
                    int readerId = Integer.parseInt(readers[i].getReaderId());
                    if(cntTm[Integer.parseInt(bookId)] < 3){
                        borrowedBooks[readerId][count++] = Integer.parseInt(bookId);
                        borrowedBookCounts[readerId]++;
                        cntTm[Integer.parseInt(bookId)]++;
                        System.out.println("Book borrowed successfully.");
                    }
                    else{
                        System.out.println("not allow to borrow 3 books of the same genre!");
                    }

                }
                else{
                    System.out.println("unable to borrow books, please enter the correct bookId!");
                }
            }
            System.out.println("--------------------");
        }
    }

    // Hiển thị bảng quản lý mượn sách
    public void displayBorrowRecords() {
        for (int i = 0; i < readerCnt; i++) {
            System.out.println("reader: " + readers[i].getName());
            System.out.println("borrowed books:");

            int readerId = Integer.parseInt(readers[i].getReaderId());

            int[] c = new int[bookCnt + 5];

            for (int j = 0; j < borrowedBookCounts[readerId]; j++) {
                int bookId = borrowedBooks[readerId][j];
                c[bookId]++;
            }
            for(int j = 0; j < c.length; j++){
                if(c[j] != 0){
                    Book book = findBookById(j);
                    System.out.println(" - " + book.getName() + " (" + book.getAuthor() + ")" + " x " + c[j]);
                }
            }
            System.out.println("--------------------");
        }
    }

    public Book findBookById(int bookId){
        for(int i = 0; i < bookCnt; i++){
            if(bookId == Integer.parseInt(books[i].getBookId())){
                return books[i];
            }
        }
        return null;
    }

    public void sortReaderByName(){
        for(int i = 0; i < readerCnt - 1; i++){
            for(int j = i + 1; j < readerCnt; j++){
                if(readers[i].getName().compareTo(readers[j].getName()) > 0){
                    Reader tmp = readers[i];
                    readers[i] = readers[j];
                    readers[j] = tmp;
                }
            }
        }
        for(int i = 0; i < readerCnt; i++){
            System.out.println(readers[i]);
        }
        System.out.println("--------------------");
    }
    public void sortByBorrowedBookCounts(){
        for(int i = 0; i < readerCnt - 1; i++){
            int readerIdI = Integer.parseInt(readers[i].getReaderId());
            for(int j = i + 1; j < readerCnt; j++){
                int readerIdJ = Integer.parseInt(readers[j].getReaderId());
                if(borrowedBookCounts[readerIdI] > borrowedBookCounts[readerIdJ]){
                    Reader tmp = readers[i];
                    readers[i] = readers[j];
                    readers[j] = tmp;
                }
            }
        }
        for(int i = 0; i < readerCnt; i++){
            System.out.println(readers[i]);
        }
    }
    public void findBorrowRecordsByReaderName(String name){
        boolean check = true;
        for(int i = 0;i < readerCnt; i++){
            if(readers[i].getName().equals(name)){
                check = false;
                System.out.println("reader: " + readers[i].getName());
                System.out.println("borrowed books:");

                int readerId = Integer.parseInt(readers[i].getReaderId());

                int[] c = new int[bookCnt + 5];

                for (int j = 0; j < borrowedBookCounts[readerId]; j++) {
                    int bookId = borrowedBooks[readerId][j];
                    c[bookId]++;
                }
                for(int j = 0; j < c.length; j++){
                    if(c[j] != 0){
                        Book book = findBookById(j);
                        System.out.println(" - " + book.getName() + " (" + book.getAuthor() + ")" + " x " + c[j]);
                    }
                }

                System.out.println("--------------------");
            }
        }
        if (check) System.out.println("not result found!");
    }
}
