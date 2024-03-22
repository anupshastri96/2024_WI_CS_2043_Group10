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
        this.bookCount = 1;
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

    public Members getBorrower() {
        return borrower;
    }

    public void setBorrower(Members borrower) {
        this.borrower = borrower;
    }
	public int getBookCount() {
		return bookCount;
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
