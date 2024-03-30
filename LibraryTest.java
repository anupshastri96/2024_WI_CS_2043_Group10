import org.junit.Test;
import static org.junit.Assert.*;

class LibraryTest {

    @Test
    public void testAddBook() {
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
    public void testRemoveBook() {
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
    public void testAddMember() {
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
    public void testRemoveMember() {
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
