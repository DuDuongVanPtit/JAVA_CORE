package Day2.service;

import Day2.Main;
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

    public LibraryManagement(Reader[] readers, Book[] books) {
        this.readers = readers;
        this.books = books;
        this.borrowedBookCounts = new int[MAX_BORROWED_BOOKS_PER_READER * MAX_BORROWED_COPIES_PER_BOOK + 5];
        this.borrowedBooks = new int[Day2.Main.readerCnt + 5][MAX_BORROWED_BOOKS_PER_READER * MAX_BORROWED_COPIES_PER_BOOK + 5];
    }

//     Lập bảng quản lý mượn sách cho từng bạn đọc
    public void borrowBooks() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < Day2.Main.readerCnt; i++) {
            System.out.println("input borrowing information for readers " + readers[i].getName() + ":");
            int[] cntTm = new int[Day2.Main.bookCnt + 1]; // The number of books borrowed per book/individual
            while (readers[i].getBorrowBookCnt() <= MAX_BORROWED_BOOKS_PER_READER) {
                if(readers[i].getBorrowBookCnt() == 5){
                    System.out.println("Reader " + readers[i].getName() +  " have finished 5 times of borrowing books!");
                    break;
                }
                System.out.print("enter the bookId you want to borrow(enter 0 to finish): ");
                String bookId = scanner.nextLine();
                if(bookId.equals("0")) break;
                boolean check = false;
                for(int j = 0; j < Day2.Main.bookCnt; j++){
                    if(books[j].getBookId().equals(bookId)){
                        check = true;
                        break;
                    }
                }
                if(check){
                    System.out.print("enter the number of book has bookId " + bookId +  " you want to borrow(enter 0 to finish): ");
                    int bookAmount = scanner.nextInt();
                    scanner.nextLine();
                    int readerId = Integer.parseInt(readers[i].getReaderId());
                    if(readers[i].getQuantityPerBook(Integer.parseInt(bookId)) + bookAmount <= 3 && readers[i].getBorrowBookCnt() + bookAmount <= 5){
                        readers[i].setBorrowBookCnt(readers[i].getBorrowBookCnt() + bookAmount);
                        int bId = Integer.parseInt(bookId);
                        readers[i].setQuantityPerBook(bId, readers[i].getQuantityPerBook(bId) + bookAmount);
                        readers[i].setBorrowedBooks(readers[i].getBorrowBookCnt(), Integer.parseInt(bookId));

                        cntTm[Integer.parseInt(bookId)] += bookAmount;

                        System.out.println("Book borrowed successfully.");
                    }
                    else if(readers[i].getBorrowBookCnt() + bookAmount > 5){
                        System.out.println("One person is not allowed to borrow more than 5 books");
                    }
                    else if(readers[i].getQuantityPerBook(Integer.parseInt(bookId)) + bookAmount > 3){
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
        for (int i = 0; i < Day2.Main.readerCnt; i++) {
            System.out.println("reader: " + readers[i].getName());
            System.out.println("borrowed books:");

            int readerId = Integer.parseInt(readers[i].getReaderId());

            int[] c = new int[Day2.Main.bookCnt + 5];

            for (int j = 0; j < readers[i].getBorrowBookCnt(); j++) {
                int bookId = readers[i].getBorrowedBooks(j + 1);
                c[bookId]++;
            }
            for(int j = 1; j < c.length; j++){
                if(c[j] != 0){
                    Book book = findBookById(j);
                    System.out.println(" - " + book.getName() + " (" + book.getAuthor() + ")" + " x " +
                            readers[i].getQuantityPerBook(Integer.parseInt(book.getBookId())));
                }
            }
            System.out.println("--------------------");
        }
    }

    public Book findBookById(int bookId){
        for(int i = 0; i < Day2.Main.bookCnt; i++){
            if(bookId == Integer.parseInt(books[i].getBookId())){
                return books[i];
            }
        }
        return null;
    }
    public void sortReaderByName(){
        for(int i = 0; i < Day2.Main.readerCnt - 1; i++){
            for(int j = i + 1; j < Day2.Main.readerCnt; j++){
                if(readers[i].getName().compareTo(readers[j].getName()) > 0){
                    Reader tmp = readers[i];
                    readers[i] = readers[j];
                    readers[j] = tmp;
                }
            }
        }
        for(int i = 0; i < Day2.Main.readerCnt; i++){
            System.out.println(readers[i]);
        }
        System.out.println("--------------------");
    }
    public void sortByBorrowedBookCounts(){
        for(int i = 0; i < Day2.Main.readerCnt - 1; i++){
            int readerIdI = Integer.parseInt(readers[i].getReaderId());
            for(int j = i + 1; j < Day2.Main.readerCnt; j++){
                int readerIdJ = Integer.parseInt(readers[j].getReaderId());
                if(readers[i].getBorrowBookCnt() < readers[j].getBorrowBookCnt()){
                    Reader tmp = readers[i];
                    readers[i] = readers[j];
                    readers[j] = tmp;
                }
            }
        }
        for(int i = 0; i < Day2.Main.readerCnt; i++){
            System.out.println(readers[i]);
        }
    }
    public void findBorrowRecordsByReaderName(String name){
        boolean check = true;
        for(int i = 0; i < Day2.Main.readerCnt; i++){
            if(readers[i].getName().equals(name)){
                check = false;
                System.out.println("reader: " + readers[i].getName());
                System.out.println("borrowed books:");

                int readerId = Integer.parseInt(readers[i].getReaderId());

                int[] c = new int[Day2.Main.bookCnt + 5];

                for (int j = 0; j < readers[i].getBorrowBookCnt(); j++) {
                    int bookId = readers[i].getBorrowedBooks(j + 1);
                    c[bookId]++;
                }
                for(int j = 1; j < c.length; j++){
                    if(c[j] != 0){
                        Book book = findBookById(j);
                        System.out.println(" - " + book.getName() + " (" + book.getAuthor() + ")" + " x " +
                                readers[i].getQuantityPerBook(Integer.parseInt(book.getBookId())));
                    }
                }
                System.out.println("--------------------");
            }
        }
        if (check) System.out.println("not result found!");
    }
    public static void alert(Reader[] readers, Book[] books){
        if(readers[0] == null && books[0] == null){
            System.out.println("book list and reader list are empty, please add information for them.");
        }
        else if(readers[0] == null){
            System.out.println("reader list is empty, please add information for it.");
        }
        else if(books[0] == null){
            System.out.println("book list is empty, please add information for it.");
        }
    }
}
