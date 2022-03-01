package model;

public class Book {
    private int bookId;
    private String bookName;
    private String authorName;
    private String bookDescription;
    
    public Book(String bookName, String authorName, String bookDescription) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookDescription = bookDescription;
    }
    
    public Book(int bookId, String bookName, String authorName, String bookDescription) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookDescription = bookDescription;
    }

    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getBookDescription() {
        return bookDescription;
    }
    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }
    
    
}
