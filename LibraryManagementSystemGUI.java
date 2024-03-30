import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryManagementSystemGUI extends JFrame {

    private Library library = new Library();

    public LibraryManagementSystemGUI() {
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add Book Form
        JTextField bookIdInput = new JTextField();
        bookIdInput.setBorder(BorderFactory.createTitledBorder("Book ID"));
        panel.add(bookIdInput);

        JTextField bookTitleInput = new JTextField();
        bookTitleInput.setBorder(BorderFactory.createTitledBorder("Book Title"));
        panel.add(bookTitleInput);

        JTextField bookAuthorInput = new JTextField();
        bookAuthorInput.setBorder(BorderFactory.createTitledBorder("Book Author"));
        panel.add(bookAuthorInput);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = bookIdInput.getText();
                String title = bookTitleInput.getText();
                String author = bookAuthorInput.getText();
                Book newBook = new Book(id, title, author);
                library.addBook(newBook);
                bookIdInput.setText("");
                bookTitleInput.setText("");
                bookAuthorInput.setText("");
            }
        });
        panel.add(addButton);

        // Remove Book Form
        JTextField removeBookIdInput = new JTextField();
        removeBookIdInput.setBorder(BorderFactory.createTitledBorder("Book ID to Remove"));
        panel.add(removeBookIdInput);

        JButton removeButton = new JButton("Remove Book");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = removeBookIdInput.getText();
                Book bookToRemove = library.findBookById(id);
                if (bookToRemove != null) {
                    library.removeBook(bookToRemove);
                    removeBookIdInput.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found.");
                }
            }
        });
        panel.add(removeButton);

        // Search Book Form
        JTextField searchBookInput = new JTextField();
        searchBookInput.setBorder(BorderFactory.createTitledBorder("Search by Title/Author"));
        panel.add(searchBookInput);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchBookInput.getText();
                library.searchBooks(searchText);
                searchBookInput.setText("");
            }
        });
        panel.add(searchButton);

        // Check Out Book Form
        JTextField checkoutBookIdInput = new JTextField();
        checkoutBookIdInput.setBorder(BorderFactory.createTitledBorder("Book ID to Check Out"));
        panel.add(checkoutBookIdInput);

        JTextField checkoutMemberNameInput = new JTextField();
        checkoutMemberNameInput.setBorder(BorderFactory.createTitledBorder("Your Name"));
        panel.add(checkoutMemberNameInput);

        JButton checkoutButton = new JButton("Check Out");
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookId = checkoutBookIdInput.getText();
                String memberName = checkoutMemberNameInput.getText();
                if (library.findMemberByName(memberName) != null) {
                    Book book = library.findBookById(bookId);
                    if (book != null && book.isAvailable()) {
                        book.checkoutBook(memberName);
                        checkoutBookIdInput.setText("");
                        checkoutMemberNameInput.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Book not found or already checked out.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You are not a member. Please register first.");
                }
            }
        });
        panel.add(checkoutButton);

        // Return Book Form
        JTextField returnBookIdInput = new JTextField();
        returnBookIdInput.setBorder(BorderFactory.createTitledBorder("Book ID to Return"));
        panel.add(returnBookIdInput);

        JButton returnButton = new JButton("Return Book");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookId = returnBookIdInput.getText();
                Book book = library.findBookById(bookId);
                if (book != null && !book.isAvailable()) {
                    book.returnBook();
                    returnBookIdInput.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found or already returned.");
                }
            }
        });
        panel.add(returnButton);

        add(panel);
        pack();
        setLocationRelativeTo(null); // Center the frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibraryManagementSystemGUI().setVisible(true);
            }
        });
    }
}
