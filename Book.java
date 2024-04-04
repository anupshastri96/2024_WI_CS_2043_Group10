import java.util.Date;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;
    private String borrower;
    private Date dueDate;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
        this.borrower = "";
        this.dueDate = new Date();
    }

    // Getters and setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public String getBorrower() { return borrower; }
    public Date getDueDate() { return dueDate; }

    public void setBorrower(String borrower) { this.borrower = borrower; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public void checkoutBook(String memberName) {
        if (this.available) {
            this.available = false;
            this.borrower = memberName;
            // Setting the due date to one week ahead from now
            this.dueDate = new Date(System.currentTimeMillis() + (7 * 24 * 60 * 60 * 1000));
        }
    }

    public void returnBook() {
        if (!this.available) {
            this.available = true;
            this.borrower = "";
            this.dueDate = new Date();
        }
    }

    @Override
    public String toString() {
        return "Book{" +
               "id='" + id + '\'' +
               ", title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", available=" + available +
               ", borrower='" + borrower + '\'' +
               ", dueDate=" + dueDate +
               '}';
    }

    public String toFileFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",").append(title).append(",").append(author).append(",");
        sb.append(available).append(",");
        sb.append(borrower).append(",").append(dueDate.getTime());
        return sb.toString();
    }

    public static Book fromFileFormat(String line) {
        String[] parts = line.split(",");
        String id = parts[0];
        String title = parts[1];
        String author = parts[2];
        boolean available = Boolean.parseBoolean(parts[3]);
        String borrower = parts[4];
        Date dueDate = new Date(Long.parseLong(parts[5]));
        Book book = new Book(id, title, author);
        book.available = available;
        book.borrower = borrower;
        book.dueDate = dueDate;
        return book;
    }
}
