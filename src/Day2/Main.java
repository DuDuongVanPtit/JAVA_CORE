package Day2;

import java.util.Scanner;

public class Main {
    public static void inputReader(int m){

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("input the number of book");
        int n = scanner.nextInt();
        scanner.nextLine();
        Book[] books = new Book[n];

        for(int i = 0; i < n; i++){
            books[i] = LibraryManagement.inputBooks(i + 1);
        }

        System.out.println("input the number of reader");
        int m = scanner.nextInt();
        scanner.nextLine();
        Reader[] readers = new Reader[m];

        for(int i = 0; i < m; i++){
            readers[i] = LibraryManagement.inputReaders(i + 1);
        }

        System.out.println("book list");
        for(int i = 0; i < n; i++){
            System.out.println(books[i]);
        }
        System.out.println("reader list");
        for(int i = 0; i < m; i++){
            System.out.println(readers[i]);
        }
        System.out.println("--------------------");
        LibraryManagement libraryManagement = new LibraryManagement(readers, books);
        libraryManagement.borrowBooks();
        libraryManagement.displayBorrowRecords();
        libraryManagement.sortReaderByName();
//        libraryManagement.sortByBorrowedBookCounts();
//        libraryManagement.findBorrowRecordsByReaderName("abc");
    }
}
