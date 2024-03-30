import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookTest {
	
	@Test
	void testCheckOutBookBorrower() {
		Book book1 = Book (300, "Study of Precipitation", "Vin Stawman")
		String borrower = "Dylan Conman"
		try {
			book1.checkoutBook(borrower);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(book1.getBorrower() == borrower);
	}
	
	@Test
	void testCheckOutBookAvailable() {
		Book book1 = Book (300, "Study of Precipitation", "Vin Stawman")
		String borrower = "Dylan Conman"
		try {
			book1.checkoutBook(borrower);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(book1.isAvailable() == false);
	}
	
	@Test
	void testCheckOutBookDueDate() {
		Book book1 = Book (300, "Study of Precipitation", "Vin Stawman")
		String borrower = "Dylan Conman"
		try {
			book1.checkoutBook(borrower);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(book1.getDueDate() != null);
	}
	
	@Test
	void testReturnBookBorrower() {
		Book book1 = Book (300, "Study of Precipitation", "Vin Stawman")
		String borrower = "Dylan Conman"
		try {
			book1.checkoutBook(borrower);
			book1.returnBook();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(book1.getBorrower() == null);
	}
	
	@Test
	void testReturnBookAvailable() {
		Book book1 = Book (300, "Study of Precipitation", "Vin Stawman")
		String borrower = "Dylan Conman"
		try {
			book1.checkoutBook(borrower);
			book1.returnBook();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(book1.isAvailable() == true);
	}
	
	@Test
	void testReturnBookDueDate() {
		Book book1 = Book (300, "Study of Precipitation", "Vin Stawman")
		String borrower = "Dylan Conman"
		try {
			book1.checkoutBook(borrower);
			book1.returnBook();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(book1.getDueDate() == null);
	}
}
