import java.util.ArrayList;

public class Library {
	private int libraryID;
	private String address;
        private String branchName;
        private ArrayList<Book> bookList = new ArrayList<Book>;

        public Library (int libraryID, String address, String branchName) {
	    this.libraryID = libraryID;
	    this.address = address;
	    this.branchName = branchName;
	}
	
	public void addBook (Book book) {
	    bookList.add(book);
	}
	
	//work on removeBook method
	public void removeBook(String callNumber) {
		for (Book book : books) {
		    if (book.getCallNumber().equals(callNumber)) {
		        books.remove(book);
		        return; // Exit the method once the book is removed
		    }
		}
		System.out.println("Book with call number " + callNumber + " not found.");
        }
	
	//work on trackBook method
	public void trackBook (Book book) {
	}
	
	//work on checkOutBook function
	public void checkOutBook (Book book) {
	}
	
	//work on checkOutBook function
	public void returnBook(Book book) {
	}
	
	//work on checkOutBook function
	public void searchBook (Book book) {
	}
	
	//work on checkOutBook function
	public void renewMembership (Member menber) {
	}
	
	//work on checkOutBook function
	public String analyzeData () {
	    return
	}
	
	public int getLibraryID () {
	    return libraryID;
	}
	
	public String getAddress() {
	    return address;
	}
	
	public String getBranchName() {
	    return branchName;
	}
	
	public void getBookList() {
	    int size = bookList.size(); 
    	    for (int i = 0; i < size; i++) {
    	    	System.out.println(bookList[i].toString);
    	    }
	}
	
} 
