package Day2;

public class Book {
    private String bookId, name, author, major, publicationYear;

    public Book(String bookId, String name, String author, String major, String publicationYear) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.major = major;
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
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return
                "bookId='" + bookId + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", major='" + major + '\'' +
                ", publicationYear='" + publicationYear + '\'';
    }
}
