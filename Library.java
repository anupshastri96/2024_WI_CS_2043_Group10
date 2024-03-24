import java.util.ArrayList;

public class Library {
    private int libraryID;
    private String address;
    private String branchName;
    private ArrayList<Book> bookList = new ArrayList<>();

    public Library(int libraryID, String address, String branchName) {
        this.libraryID = libraryID;
        this.address = address;
        this.branchName = branchName;
    }

    public int getLibraryID() {
        return libraryID;
    }

    public void setLibraryID(int libraryID) {
        this.libraryID = libraryID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void removeBook(String callNumber) {
        for (Book book : bookList) {
            if (book.getCallNumber().equals(callNumber)) {
                bookList.remove(book);
                return; 
            }
        }
        System.out.println("Book with call number " + callNumber + " not found.");
    }

    public boolean checkForBook(Book book) {
        for (Book b : bookList) {
            if (b.getCallNumber().equals(book.getCallNumber())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkAvailability(Book book) {
        return book.getBookCount() > 0;
    }

}