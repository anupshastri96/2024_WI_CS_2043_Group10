import java.util.ArrayList;
import java.time.LocalDate;
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
	//work on trackBook method
	public void trackBook (Book book) {
	}
	
	
	public void checkOutBook (Book book, LocalDate dateCheckedOut) {

		bookList.remove(book);
		
	}
	
	
	public void returnBook(Book book, LocalDate dueDate) {
		double lateFees = 0; 
		int daysLate = 0;
		LocalDate dateReturned = LocalDate.now();
		if(dueDate<dateReturned){
			daysLate = dateReturned - dueDate;
			lateFees = daysLate * 3;
		}
		bookList.add(book);
	}
	
	public void searchBook (Book book) {
	}
	//work on checkOutBook function
	public void renewMembership (Members member) {
		LocalDate date = LocalDate.now();
		LocalDate oldDate = member.getMembershipDate();
		if(date.getYear() - oldDate.getYear() >= 1) {
			if(date.getMonthValue() - oldDate.getMonthValue() == 0) {
				if(date.getDayOfMonth() - oldDate.getDayOfMonth() <= 0) {
					member.setMembershipDate(date);
				}
			}
		}
		else {
			return;
		}
		return;
	}
	
	//work on checkOutBook function
	public String analyzeData () {
	    return "";
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
	/*
	 * This method checks if a certain book has availablability
	 * @param book The book in question
	 * @return check A boolean value
	 */
	public boolean checkAvailabilty(Book book) {
		boolean check = false;
		if(book.getBookCount() == 0) {
			return check;
		}
		else{
			check = true;
		}
		return check;
	}
	public void getStringBookList() {
	    int size = bookList.size(); 
    	    for (int i = 0; i < size; i++) {
    	    	System.out.println(bookList.get(i).toString);
    	    }
	}

    public void setLibraryID(int libraryID) {
        this.libraryID = libraryID;
    }

    public void setAddress(String address) {
        this.address = address;
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
