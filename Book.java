public class Book {
    private String title;
    private String author;
    private String callNumber;
    private String borrower;
    private int daysLate;
    private double lateFee;

    public Book(String title, String author, String callNumber) {
        this.title = title;
        this.author = author;
        this.callNumber = callNumber;
        this.borrower = null;
        this.daysLate = 0;
        this.lateFee = 0.0;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(Member borrower) {
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

    public void calculateLateFee() {
        this.lateFee = lateFee * daysLate;
    }
}
