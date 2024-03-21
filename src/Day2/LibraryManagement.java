package Day2;

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
        this.borrowedBooks = new int[readers.length + 5][MAX_BORROWED_BOOKS_PER_READER * MAX_BORROWED_COPIES_PER_BOOK + 5];
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
        for (int i = 0; i < readers.length; i++) {
            System.out.println("input borrowing information for readers " + readers[i].getName() + ":");
            int count = 0;
            int[] cntTm = new int[books.length + 1]; // The number of books borrowed per book/individual
            while (count < MAX_BORROWED_BOOKS_PER_READER) {
                System.out.print("enter the bookId you want to borrow(enter 0 to finish): ");
                String bookId = scanner.nextLine();
                if(bookId.equals("0")) break;
                boolean check = false;
                for(Book b: books){
                    if(b.getBookId().equals(bookId)){
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
        for (int i = 0; i < readers.length; i++) {
            System.out.println("reader: " + readers[i].getName());
            System.out.println("borrowed books:");

            int readerId = Integer.parseInt(readers[i].getReaderId());

            int[] c = new int[books.length + 5];

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
        for(Book b : books){
            if(bookId == Integer.parseInt(b.getBookId())){
                return b;
            }
        }
        return null;
    }

    public void sortReaderByName(){
        for(int i = 0; i < readers.length - 1; i++){
            for(int j = i + 1; j < readers.length; j++){
                if(readers[i].getName().compareTo(readers[j].getName()) > 0){
                    Reader tmp = readers[i];
                    readers[i] = readers[j];
                    readers[j] = tmp;
                }
            }
        }
        for(Reader r : readers){
            System.out.println(r);
        }
        System.out.println("--------------------");
    }
    public void sortByBorrowedBookCounts(){
        for(int i = 0; i < readers.length - 1; i++){
            int readerIdI = Integer.parseInt(readers[i].getReaderId());
            for(int j = i + 1; j < readers.length; j++){
                int readerIdJ = Integer.parseInt(readers[j].getReaderId());
                if(borrowedBookCounts[readerIdI] > borrowedBookCounts[readerIdJ]){
                    Reader tmp = readers[i];
                    readers[i] = readers[j];
                    readers[j] = tmp;
                }
            }
        }
        for(Reader r : readers){
            System.out.println(r);
        }
    }
    public void findBorrowRecordsByReaderName(String name){
        boolean check = true;
        for(Reader r : readers){
            if(r.getName().equals(name)){
                check = false;
                System.out.println("reader: " + r.getName());
                System.out.println("borrowed books:");

                int readerId = Integer.parseInt(r.getReaderId());

                int[] c = new int[books.length + 5];

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
