import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            this.dueDate = new Date(System.currentTimeMillis() + (10L * 24 * 60 * 60 * 1000));
        }
    }

    public void returnBook() {
        if (!this.available) {
            this.available = true;
            this.borrower = "";
            this.dueDate = null; 
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",").append(title).append(",").append(author).append(",");
        sb.append(available).append(",");
        sb.append(borrower).append(",");
        if (!available) { 
            sb.append(dateFormat.format(dueDate));
        }
        return sb.toString();
    }

    public static Book fromFileFormat(String line) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] parts = line.split(",");
        String id = parts[0];
        String title = parts[1];
        String author = parts[2];
        boolean available = Boolean.parseBoolean(parts[3]);
        String borrower = "";
        Date dueDate = null;
    
        if (parts.length > 4) {
            borrower = parts[4];
            if (parts.length > 5 && !parts[5].isEmpty()) {
                try {
                    dueDate = dateFormat.parse(parts[5]);
                } catch (ParseException e) {
                    e.printStackTrace(); 
                }
            }
        }
    
        Book book = new Book(id, title, author);
        book.available = available;
        book.borrower = borrower;
        book.dueDate = dueDate;
        return book;
    }
    
    
}
