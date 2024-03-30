import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI extends JFrame {
    private Library library;

    public LibraryGUI(Library library) {
        this.library = library;
        setTitle("Library Management System");
        setSize(640, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(Color.MAGENTA);
        JButton addBookButton = new JButton("Add Book");
        JButton removeBookButton = new JButton("Remove Book");
        JButton searchBookButton = new JButton("Search Book");
        JButton getMembershipButton = new JButton("Get Membership");
        JButton getAnalyticsButton = new JButton("Get Analytics");

        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter title:");
                String author = JOptionPane.showInputDialog("Enter author:");
                String callNumber = JOptionPane.showInputDialog("Enter call number:");
                Book newBook = new Book(title, author, callNumber);
                library.addBook(newBook);
                JOptionPane.showMessageDialog(null, "Book added successfully!");
            }
        });

        removeBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String callNumber = JOptionPane.showInputDialog("Enter call number of the book to remove:");
                library.removeBook(callNumber);
                JOptionPane.showMessageDialog(null, "Book removed successfully!");
            }
        });

        searchBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String callNumber = JOptionPane.showInputDialog("Enter call number of the book to search:");
                boolean bookFound = library.checkForBook(new Book("", "", callNumber));
                if (bookFound) {
                    JOptionPane.showMessageDialog(null, "Book found in the library!");
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found in the library.");
                }
            }
        });

        getMembershipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Members functionality will be added later.");
            }
        });

        getAnalyticsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Analytics functionality will be added later.");
            }
        });
        
        addBookButton.setBackground(Color.CYAN);
        searchBookButton.setBackground(Color.GREEN);
        removeBookButton.setBackground(Color.RED);
        getMembershipButton.setBackground(Color.PINK);
        getAnalyticsButton.setBackground(Color.ORANGE);


        panel.add(addBookButton);
        panel.add(removeBookButton);
        panel.add(searchBookButton);
        panel.add(getMembershipButton);
        panel.add(getAnalyticsButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        Library library = new Library(1, "123 Main St", "Main Branch");
        new LibraryGUI(library);
    }
}