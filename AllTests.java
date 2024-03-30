import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AllTests {

	@Test
	void testCheckOutBookBorrower() {
		Book book1 = new Book ("300", "Study of Precipitation", "Vin Stawman");
		String borrower = "Dylan Conman";
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
		Book book1 = new Book ("300", "Study of Precipitation", "Vin Stawman");
		String borrower = "Dylan Conman";
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
		Book book1 = new Book ("300", "Study of Precipitation", "Vin Stawman");
		String borrower = "Dylan Conman";
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
		Book book1 = new Book ("300", "Study of Precipitation", "Vin Stawman");
		String borrower = "Dylan Conman";
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
		Book book1 = new Book ("300", "Study of Precipitation", "Vin Stawman");
		String borrower = "Dylan Conman";
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
		Book book1 = new Book("300", "Study of Precipitation", "Vin Stawman");
		String borrower = "Dylan Conman";
		try {
			book1.checkoutBook(borrower);
			book1.returnBook();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(book1.getDueDate() == null);
	}
	
	@Test
	void testToFileFormat() {
		Members member = new Members("1", "John Doe", "123456789", "123 Main St");
		String expectedString = "1;John Doe;123456789;123 Main St";
		String text = "";
		try {
			text = member.toFileFormat();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(text, expectedString);
        }
        
        @Test
        void testAddBook() {
		Library library = new Library();
		Book book = new Book("1", "Book Title", "Author");
		try {
			library.addBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(library.searchBooksByTitle("Book Title").contains(book));
	 }

	    @Test
	    void testRemoveBook() {
		Library library = new Library();
		Book book = new Book("1", "Book Title", "Author");
		try {
			library.addBook(book);
		        library.removeBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(library.searchBooksByTitle("Book Title").contains(book));
	    }

	    @Test
	    void testAddMember() {
		Library library = new Library();
		Members member = new Members("10", "John Doe", "123456789", "123 Main St");
		try {
			library.addMember(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(member, library.findMemberById("10"));
	    }

	    @Test
	    void testRemoveMember() {
		Library library = new Library();
		try {
			Members member = new Members("5", "John Doe", "123456789", "123 Main St");
			library.addMember(member);
			library.removeMember("5");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertNull(library.findMemberById("5")); 
	    }
}
