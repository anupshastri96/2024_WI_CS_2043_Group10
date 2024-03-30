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
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Available: " + (book.isAvailable() ? "Yes" : "No"));
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Available: " + (book.isAvailable() ? "Yes" : "No"));
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
        Iterator<Members> iterator = members.iterator();
        while (iterator.hasNext()) {
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
        try (PrintWriter writer = new PrintWriter(new FileWriter("books.txt"))) {
            for (Book book : books) {
                writer.println(book.toFileFormat());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                books.add(Book.fromFileFormat(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveMembersToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("members.txt"))) {
            for (Members member : members) {
                writer.println(member.toFileFormat());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMembersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("members.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                members.add(Members.fromFileFormat(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
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
    public void searchBooks(String searchText) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(searchText) || book.getAuthor().equalsIgnoreCase(searchText)) {
                System.out.println(book);
            }
        }
    }
    
    
}
