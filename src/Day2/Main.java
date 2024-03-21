package Day2;

import Day2.model.Book;
import Day2.model.Reader;
import Day2.service.LibraryManagement;

import javax.jws.Oneway;
import java.util.Scanner;

public class Main {
    static Book[] books = new Book[10000];
    public static int bookCnt = 0;
    static Reader[] readers = new Reader[10000];
    public static int readerCnt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("input 0 to finish\n" +
                    "input 1 to add an new book list\n" +
                    "input 2 to add an new reader list\n" +
                    "input 3 to create an borrowed book table\n" +
                    "input 4 to sort borrowed book table by reader name\n" +
                    "input 5 to sort borrowed book table by the number of borrowed book (decrease)\n" +
                    "input 6 to find by reader name");
            System.out.println("--------------------");

            int choice = scanner.nextInt();
            if (choice == 0) break;

            switch (choice){
                case 1:
                    System.out.print("input the number of new book: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    Book[] newBooks = new Book[n];

                    for(int i = 0; i < n; i++){
                        Book book = Book.inputBooks(bookCnt + 1);
                        newBooks[i] = book;
                        books[bookCnt++] = book;
                    }
                    System.out.println("book list");
                    int j = 0;
                    while(books[j] != null){
                        System.out.println(books[j]);
                        j++;
                    }
                    System.out.println("--------------------");
                    break;

                case 2:
                    System.out.print("Input the number of new reader: ");
                    int m = scanner.nextInt();
                    scanner.nextLine();
                    Reader[] newReaders = new Reader[m];

                    for(int i = 0; i < m; i++){
                        Reader reader = Reader.inputReaders(readerCnt + 1);
                        newReaders[i] = reader;
                        readers[readerCnt++] = reader;

                    }
                    System.out.println("Reader list:");
                    int k = 0;
                    while(readers[k] != null){
                        System.out.println( "\t" + readers[k]);
                        k++;
                    }
                    System.out.println("--------------------");
                    break;

                case 3:
                    LibraryManagement.alert(readers, books);
                    if(readers[0] != null && books[0] != null){
                        LibraryManagement libraryManagement = new LibraryManagement(readers, books);
                        libraryManagement.borrowBooks();
                        libraryManagement.displayBorrowRecords();
                    }
                    break;

                case 4:
                    LibraryManagement.alert(readers, books);
                    if(readers[0] != null && books[0] != null) {
                        LibraryManagement libraryManagement = new LibraryManagement(readers, books);
                        libraryManagement.sortReaderByName();
                    }
                    break;
                case 5:
                    LibraryManagement.alert(readers, books);
                    if(readers[0] != null && books[0] != null) {
                        LibraryManagement libraryManagement = new LibraryManagement(readers, books);
                        libraryManagement.sortByBorrowedBookCounts();
                    }
                    break;

                case 6:
                    LibraryManagement.alert(readers, books);
                    if(readers[0] != null && books[0] != null) {
                        LibraryManagement libraryManagement = new LibraryManagement(readers, books);
                        System.out.print("input name of reader you want to find: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        libraryManagement.findBorrowRecordsByReaderName(name);
                    }
                    break;
            }

        }
    }
}
