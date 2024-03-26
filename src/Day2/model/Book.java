package Day2.model;

import java.util.Scanner;

public class Book {
    private String bookId, name, author, category, publicationYear;

    public Book(String bookId, String name, String author, String category, String publicationYear) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.category = category;
        this.publicationYear = publicationYear;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMajor() {
        return category;
    }

    public void setMajor(String category) {
        this.category = category;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public static Book inputBooks(int bookId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 4 lines to insert a new book");

        String a = "" + bookId;
        while(a.length() < 5){
            a = "0" + a;
        }

        System.out.print("Book name:");
        String b = scanner.nextLine();
        System.out.print("Author:");
        String c = scanner.nextLine();
        System.out.print("Category:");
        String d = null;
        while(true){
            System.out.print("chose reader type:\n");
            System.out.println("\t1: KHTN\n\t2: VH\n\t3: NT\n\t4: DTVT\n\t5: CNTT");
            int type = scanner.nextInt();
            switch (type){
                case 1:
                    d = "KHTN";
                    break;
                case 2:
                    d = "VH";
                    break;
                case 3:
                    d = "NT";
                    break;
                case 4:
                    d = "DTVT";
                    break;
                case 5:
                    d = "CNTT";
            }
            if(type == 1 || type == 2 || type == 3 || type == 4 || type == 5){
                break;
            }
            else System.out.println("please chose the correct category number!");
        }
        scanner.nextLine();
        System.out.print("Publication year:");
        String e = scanner.nextLine();
        Book book =
                new Book(a, b, c, d, e);
        System.out.println("--------------------");
        return book;
    }

    @Override
    public String toString() {
        return
                "bookId='" + bookId + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", publicationYear='" + publicationYear + '\'';
    }
}
