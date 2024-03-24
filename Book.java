public class Book {
    private String title;
    private String author;
    private String callNumber;
    private Members borrower;
    private int daysLate;
    private double lateFee;
    private int bookCount;

    public Book(String title, String author, String callNumber) {
        this.title = title;
        this.author = author;
        this.callNumber = callNumber;
        this.borrower = null;
        this.daysLate = 0;
        this.lateFee = 0.0;
        this.bookCount = 1; // Assuming each book starts with a count of 1
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public Members getBorrower() {
        return borrower;
    }

    public void setBorrower(Members borrower) {
        this.borrower = borrower;
    }

    public int getDaysLate() {
        return daysLate;
    }

    public void setDaysLate(int daysLate) {
        this.daysLate = daysLate;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public void calculateLateFee() {
        this.lateFee = 0.5 * daysLate; 
    }

}