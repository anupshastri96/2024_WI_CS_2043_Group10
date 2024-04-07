import java.io.*;
import java.util.*;

public class Library {
    List<Book> books = new ArrayList<>();
    List<Members> members = new ArrayList<>();

    public Library() {
        loadBooksFromFile();
        loadMembersFromFile();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
    }

    public void removeBook(Book book) {
        books.remove(book);
        saveBooksToFile();
    }

    public List<Book> searchBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public boolean addMember(Members member) {
        if (!members.contains(member)) {
            members.add(member);
            saveMembersToFile();
            return true;
        }
        return false;
    }

    public boolean removeMember(String memberId) {
        for (Iterator<Members> iterator = members.iterator(); iterator.hasNext();) {
            Members member = iterator.next();
            if (member.getId().equals(memberId)) {
                iterator.remove();
                saveMembersToFile();
                return true;
            }
        }
        return false;
    }
    

    public Members findMemberById(String memberId) {
        for (Members member : members) {
            if (member.getId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    private void saveBooksToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Books.txt"))) {
            for (Book book : books) {
                writer.println(book.toFileFormat());
            }
        } catch (IOException e) {
            System.err.println("Error saving books to file: " + e.getMessage());
        }
    }

    private void loadBooksFromFile() {
        File file = new File("Books.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Book book = Book.fromFileFormat(line);
                    if (book != null) {
                        books.add(book);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error loading books from file: " + e.getMessage());
            }
        }
    }

    private void saveMembersToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Members.txt"))) {
            for (Members member : members) {
                writer.println(member.toFileFormat());
            }
        } catch (IOException e) {
            System.err.println("Error saving members to file: " + e.getMessage());
        }
    }

    private void loadMembersFromFile() {
        File file = new File("Members.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Members member = Members.fromFileFormat(line);
                    if (member != null) {
                        members.add(member);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error loading members from file: " + e.getMessage());
            }
        }
    }

    public Members findMemberByName(String memberName) {
        for (Members member : members) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                return member;
            }
        }
        return null;
    }

    public boolean checkoutBook(String bookId, String memberId) {
        Book book = findBookById(bookId);
        Members member = findMemberById(memberId);
        if (book != null && member != null && book.isAvailable()) {
            book.checkoutBook(member.getName());
            saveBooksToFile();
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookId) {
        Book book = findBookById(bookId);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            saveBooksToFile();
            return true;
        }else {
        return false; }
    }



    public List<Book> searchBooks(String searchText) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchText.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(searchText.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks; 
    }


    public Members findMemberByPhoneNumber(String phoneNumber) {
        for (Members member : members) {
            if (member.getPhoneNumber().equals(phoneNumber)) {
                return member;
            }
        }
        return null;
    }
    
    }
