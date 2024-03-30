import java.util.Date;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;
    private String borrower; // New field to store borrower's name
    private Date dueDate; // New field to store due date for borrowed books

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
        this.borrower = null; // Initialize borrower to null
        this.dueDate = null; // Initialize dueDate to null
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void checkoutBook(String memberName) {
        if (this.available) {
            this.available = false;
            this.borrower = memberName;
            this.dueDate = new Date(System.currentTimeMillis() + (7 * 24 * 60 * 60 * 1000)); // 7 days from now
        }
    }

    public void returnBook() {
        if (!this.available) {
            this.available = true;
            this.borrower = null;
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
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",").append(title).append(",").append(author).append(",");
        sb.append(available).append(",");
        if (available) {
            sb.append("null,null"); // No borrower and due date for available books
        } else {
            sb.append(borrower).append(",").append(dueDate.getTime()); // Store borrower and due date
        }
        return sb.toString();
    }

    public static Book fromFileFormat(String line) {
        String[] parts = line.split(",");
        if (parts.length >= 6) {
            String id = parts[0];
            String title = parts[1];
            String author = parts[2];
            boolean available = Boolean.parseBoolean(parts[3]);
            String borrower = parts[4].equals("null") ? null : parts[4];
            Date dueDate = parts[5].equals("null") ? null : new Date(Long.parseLong(parts[5]));
            Book book = new Book(id, title, author);
            book.available = available;
            book.borrower = borrower;
            book.dueDate = dueDate;
            return book;
        } else {
            // Handle case where there are not enough elements in the array
            return null; // Or throw an exception
        }
    }
    
}
