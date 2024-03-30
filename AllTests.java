import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AllTests {

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
	
	@Test
	void testToFileFormat() {
		Member member = new Member("1", "John Doe", "123456789", "123 Main St");
		String expectedString = "1;John Doe; 123456789;123 Main St";
		try {
			String text = member.toFileFormat()
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(text, expectedString)
        }
        
        @Test
        void testAddBook() {
		Library library = new Library();
		try {
			Book book = new Book("1", "Book Title", "Author");
			library.addBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(library.searchBooksByTitle("Book Title").contains(book));
	 }

	    @Test
	    void testRemoveBook() {
		Library library = new Library();
		try {
			Book book = new Book("1", "Book Title", "Author");
			library.addBook(book);
		        library.removeBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(library.searchBooksByTitle("Book Title").contains(book));
	    }

	    @Test
	    void testAddMember() {
		Library library = new Library();
		try {
			Member member = new Member("1", "John Doe", "123456789", "123 Main St");
			library.addMember(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(member, library.findMemberById("1"));
	    }

	    @Test
	    void testRemoveMember() {
		Library library = new Library();
		try {
			Member member = new Member("1", "John Doe", "123456789", "123 Main St");
			library.addMember(member);
			library.removeMember("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNull(library.findMemberById("1"))  
	    }
}
