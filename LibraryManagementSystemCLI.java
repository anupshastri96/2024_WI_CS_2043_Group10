import java.util.Scanner;
import java.util.Date;

public class LibraryManagementSystemCLI {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Library Management System CLI");
        System.out.println("----------------------------------------");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search books by title");
            System.out.println("4. Search books by author");
            System.out.println("5. Check out a book");
            System.out.println("6. Return a book");
            System.out.println("7. Add a member");
            System.out.println("8. Remove a member");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addBook(scanner, library);
                    break;
                case 2:
                    removeBook(scanner, library);
                    break;
                case 3:
                    searchBooksByTitle(scanner, library);
                    break;
                case 4:
                    searchBooksByAuthor(scanner, library);
                    break;
                case 5:
                    checkoutBook(scanner, library);
                    break;
                case 6:
                    returnBook(scanner, library);
                    break;
                case 7:
                    addMember(scanner, library);
                    break;
                case 8:
                    removeMember(scanner, library);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addBook(Scanner scanner, Library library) {
        System.out.print("Enter book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        Book newBook = new Book(id, title, author);
        library.addBook(newBook);
        System.out.println("Book added successfully.");
    }

    private static void removeBook(Scanner scanner, Library library) {
        System.out.print("Enter book ID to remove: ");
        String id = scanner.nextLine();
        Book bookToRemove = library.findBookById(id);
        if (bookToRemove != null) {
            library.removeBook(bookToRemove);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void searchBooksByTitle(Scanner scanner, Library library) {
        System.out.print("Enter the title to search: ");
        String title = scanner.nextLine();
        library.searchBooksByTitle(title);
    }

    private static void searchBooksByAuthor(Scanner scanner, Library library) {
        System.out.print("Enter the author to search: ");
        String author = scanner.nextLine();
        library.searchBooksByAuthor(author);
    }

    /**
     * @param scanner
     * @param library
     */
    private static void checkoutBook(Scanner scanner, Library library) {
        System.out.print("Enter your name: ");
        String memberName = scanner.nextLine();
    
        // Check if member exists
        if (library.findMemberByName(memberName) != null) {
            System.out.print("Enter the ID of the book to check out: ");
            String bookId = scanner.nextLine();
            Book book = library.findBookById(bookId);
            if (book != null && book.isAvailable()) {
                book.checkoutBook(memberName);
                System.out.println("Book checked out successfully.");
            } else {
                System.out.println("Book not found or already checked out.");
            }
        } else {
            System.out.println("You are not a member. Please register first.");
        }
    }
    

    private static void returnBook(Scanner scanner, Library library) {
        System.out.print("Enter the ID of the book to return: ");
        String bookId = scanner.nextLine();
        Book book = library.findBookById(bookId);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found or already returned.");
        }
    }

    private static void addMember(Scanner scanner, Library library) {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter member address: ");
        String address = scanner.nextLine();
        String memberId = Long.toHexString(System.currentTimeMillis()); // Generate unique ID for member
        Member newMember = new Member(memberId, name, phoneNumber, address);
        if (library.addMember(newMember)) {
            System.out.println("Member added successfully with ID: " + memberId);
        } else {
            System.out.println("Member already exists.");
        }
    }

    private static void removeMember(Scanner scanner, Library library) {
        System.out.print("Enter member ID to remove: ");
        String memberId = scanner.nextLine();
        if (library.removeMember(memberId)) {
            System.out.println("Member removed successfully.");
        } else {
            System.out.println("Member not found.");
        }
    }
}
