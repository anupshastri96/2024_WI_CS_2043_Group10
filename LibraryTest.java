import org.junit.Assert;
import org.junit.jupiter.api.Test;

class LibraryTest {

    @Test
    public void testAddBook() {
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
    public void testRemoveBook() {
        Library library = new Library();
        Book book = new Book("2", "Book Title", "Author");
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
    public void testAddMember() {
        Library library = new Library();
        Members member = new Members("15", "John Doe", "123456789", "123 Main St");
        try {
        	library.addMember(member);
        } catch (Exception e) {
		// TODO Auto-generated catch block
        	e.printStackTrace();
        }
        Assert.assertEquals(member, library.findMemberById("15"));
    }

    @Test
    public void testRemoveMember() {
        Library library = new Library();
        try {
        	Members member = new Members("10", "John Doe", "123456789", "123 Main St");
        	library.addMember(member);
        	library.removeMember("10");
        } catch (Exception e) {
		// TODO Auto-generated catch block
        	e.printStackTrace();
        }
        Assert.assertNull(library.findMemberById("10"));
    }

}
