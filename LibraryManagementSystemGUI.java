import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener; 

import java.util.List;
import java.util.UUID;

public class LibraryManagementSystemGUI extends JFrame {
    private Library library;
    private JTextField bookIdInput, bookTitleInput, bookAuthorInput;
    private JTextField removeBookIdInput;
    private JTextField searchBookInput;
    private JTextField checkoutBookIdInput, checkoutMemberNameInput;
    private JTextField returnBookIdInput;
    private JTextField memberNameInput, memberPhoneNumberInput, memberAddressInput, removeMemberPhoneInput;

    private JLabel statusLabel;

    public LibraryManagementSystemGUI() {
        library = new Library();
        initializeComponents();
        setUpLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Library Management System");
        setSize(800, 600); 
        setLocationRelativeTo(null); 
    }

    private void initializeComponents() {
        bookIdInput = new JTextField();
        bookTitleInput = new JTextField();
        bookAuthorInput = new JTextField();
        removeBookIdInput = new JTextField();
        searchBookInput = new JTextField();
        checkoutBookIdInput = new JTextField();
        checkoutMemberNameInput = new JTextField();
        returnBookIdInput = new JTextField();
        memberNameInput = new JTextField();
        memberPhoneNumberInput = new JTextField();
        memberAddressInput = new JTextField();
        removeMemberPhoneInput = new JTextField();

        statusLabel = new JLabel("Welcome to the Library Management System!");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Serif", Font.BOLD, 20));
    }

    private void setUpLayout() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(4, 4, 4, 4);

    gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 1;
    mainPanel.add(createTitledPanel("Book ID", bookIdInput), gbc);

    gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1;
    mainPanel.add(createTitledPanel("Book Title", bookTitleInput), gbc);
    
    gbc.gridx = 2; gbc.gridy = 0; gbc.weightx = 1;
    mainPanel.add(createTitledPanel("Book Author", bookAuthorInput), gbc);

    gbc.gridx = 3; gbc.gridy = 0; gbc.weightx = 0; gbc.gridwidth = GridBagConstraints.REMAINDER;
    mainPanel.add(createButton("Add Book", e -> addBook()), gbc);

    gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 1; gbc.gridwidth = 2;
    mainPanel.add(createTitledPanel("Book ID to Remove", removeBookIdInput), gbc);

    gbc.gridx = 2; gbc.gridy = 1; gbc.weightx = 0; gbc.gridwidth = GridBagConstraints.REMAINDER;
    mainPanel.add(createButton("Remove Book", e -> removeBook()), gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.weightx = 1.0;
        mainPanel.add(createTitledPanel("Search (Title/Author)", searchBookInput), gbc);
    
        gbc.gridx = 2; gbc.gridy = 2; gbc.gridwidth = GridBagConstraints.REMAINDER; gbc.weightx = 0.0;
        mainPanel.add(createButton("Search Books", e -> searchBooks()), gbc);
    
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1; gbc.weightx = 0.5;
        mainPanel.add(createTitledPanel("Book ID to Check Out", checkoutBookIdInput), gbc);
    
        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 0.5;
        mainPanel.add(createTitledPanel("Member Name for Checkout", checkoutMemberNameInput), gbc);
    
        gbc.gridx = 2; gbc.gridy = 3; gbc.gridwidth = GridBagConstraints.REMAINDER; gbc.weightx = 0.0;
        mainPanel.add(createButton("Check Out Book", e -> checkoutBook()), gbc);
    
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.weightx = 1.0;
        mainPanel.add(createTitledPanel("Book ID to Return", returnBookIdInput), gbc);
    
        gbc.gridx = 2; gbc.gridy = 4; gbc.gridwidth = GridBagConstraints.REMAINDER; gbc.weightx = 0.0;
        mainPanel.add(createButton("Return Book", e -> returnBook()), gbc);
    
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 1; gbc.weightx = 0.33;
        mainPanel.add(createTitledPanel("Member Name", memberNameInput), gbc);
    
        gbc.gridx = 1; gbc.gridy = 5; gbc.weightx = 0.33;
        mainPanel.add(createTitledPanel("Member Phone Number", memberPhoneNumberInput), gbc);
    
        gbc.gridx = 2; gbc.gridy = 5; gbc.weightx = 0.33;
        mainPanel.add(createTitledPanel("Member Address", memberAddressInput), gbc);
    
        gbc.gridx = 3; gbc.gridy = 5; gbc.gridwidth = GridBagConstraints.REMAINDER; gbc.weightx = 0.0;
        mainPanel.add(createButton("Add Member", e -> addMember()), gbc);

    gbc.gridx = 0; gbc.gridy = 6; 
    gbc.gridwidth = 2; gbc.weightx = 1.0;
    mainPanel.add(createTitledPanel("Member Phone Number to Remove", removeMemberPhoneInput), gbc);

    gbc.gridx = 2; gbc.gridy = 6; 
    gbc.gridwidth = GridBagConstraints.REMAINDER; gbc.weightx = 0.0;
    mainPanel.add(createButton("Remove Member", e -> removeMember()), gbc);

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(statusLabel, BorderLayout.PAGE_END);
        this.pack(); 
    }
    

    private JPanel createTitledPanel(String title, JTextField textField) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.add(textField);
        return panel;
    }

    private JButton createButton(String label, ActionListener actionListener) {
        JButton button = new JButton(label);
        button.addActionListener(actionListener);
        return button;
    }

    private void addBook() {
        String id = bookIdInput.getText();
        String title = bookTitleInput.getText();
        String author = bookAuthorInput.getText();
        if (!id.isEmpty() && !title.isEmpty() && !author.isEmpty()) {
            Book newBook = new Book(id, title, author);
            library.addBook(newBook);
            statusLabel.setText("Book added successfully.");
            bookIdInput.setText("");
            bookTitleInput.setText("");
            bookAuthorInput.setText("");
        } else {
            statusLabel.setText("All fields are required.");
        }
    }

    private void removeBook() {
        String id = removeBookIdInput.getText().trim(); 
        if (id.isEmpty()) {
            statusLabel.setText("Please enter a Book ID.");
            return; 
        }
        
        Book book = library.findBookById(id);
        if (book == null) {
            statusLabel.setText("Book not found.");
            removeBookIdInput.setText(""); 
        } else {
            library.removeBook(book);
            statusLabel.setText("Book removed successfully.");
            removeBookIdInput.setText("");  
            
        }
    }
    
    private void searchBooks() {
        String searchText = searchBookInput.getText();
        List<Book> books = library.searchBooks(searchText);
        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No books found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder message = new StringBuilder("<html>"); 
            for (Book book : books) {
                String availabilityText = book.isAvailable() ? "Book Available" : "Book Not Available";
                message.append("<p>").append(book.getTitle()).append(" - ").append(book.getAuthor())
                        .append(" - ").append(availabilityText).append("</p>");
            }
            message.append("</html>");
            JOptionPane.showMessageDialog(this, message.toString(), "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    

    private void checkoutBook() {
        String bookId = checkoutBookIdInput.getText();
        String memberName = checkoutMemberNameInput.getText();
        Members member = library.findMemberByName(memberName);
        if (member != null && library.checkoutBook(bookId, member.getId())) {
            statusLabel.setText("Book checked out successfully.");
        } else {
            statusLabel.setText("Checkout failed. Book may not exist or isn't available.");
        }
    }

    private void returnBook() {
        String bookId = returnBookIdInput.getText();
        if (library.returnBook(bookId)) {
            statusLabel.setText("Book returned successfully.");
        } else {
            statusLabel.setText("Return failed. Book may not exist or is not checked out.");
        }
    }

    private void addMember() {
        String name = memberNameInput.getText();
        String phoneNumber = memberPhoneNumberInput.getText();
        String address = memberAddressInput.getText();
        if (!name.isEmpty() && !phoneNumber.isEmpty() && !address.isEmpty()) {
            String id = UUID.randomUUID().toString(); 
            Members newMember = new Members(id, name, phoneNumber, address);
            if (library.addMember(newMember)) {
                statusLabel.setText("Member added successfully.");
                memberNameInput.setText("");
                memberPhoneNumberInput.setText("");
                memberAddressInput.setText("");
            } else {
                statusLabel.setText("Failed to add member.");
            }
        } else {
            statusLabel.setText("All fields are required for adding a member.");
        }
    }

    private void removeMember() {
        String phoneNumber = removeMemberPhoneInput.getText().trim();
        if (phoneNumber.isEmpty()) {
            statusLabel.setText("Please enter a Member Phone Number.");
            return;
        }
    
        Members member = library.findMemberByPhoneNumber(phoneNumber);
        if (member != null) {
            library.removeMember(member.getId());
            statusLabel.setText("Member removed successfully.");
            removeMemberPhoneInput.setText(""); 
        } else {
            statusLabel.setText("Member not found.");
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryManagementSystemGUI().setVisible(true));
    }
}
