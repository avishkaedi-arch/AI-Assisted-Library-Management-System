import java.util.ArrayList;

public class Library {
    // List to store the book inventory
    private ArrayList<Book> books;

    /**
     * Constructor initializes an empty library.
     */
    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a new book to the library system.
     * @param book The Book object to add
     */
    public void addBook(Book book) {

        for (Book b : books) {
            if (b.getId().equals(book.getId())) {
                System.out.println("A book with this ID already exists.");
                return;
            }
        }

        books.add(book);
        System.out.println("Added to library: \"" + book.getTitle() + "\"");
    }

    /**
     * Displays all books currently in the library system.
     */
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is currently empty.");
            return;
        }
        System.out.println("\n--- Library Inventory ---");
        for (Book book : books) {
            System.out.println(book); // Calls the Book's toString() method
        }
        System.out.println("-------------------------\n");
    }

    /**
     * Searches for a book by its title (case-insensitive).
     * @param title The title to search for
     * @return The Book object if found, or null if not found
     */
    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + book);
                return book;
            }
        }
        System.out.println("Book with title \"" + title + "\" not found.");
        return null;
    }

    /**
     * Borrows a book from the library by its ID.
     * @param id The unique ID of the book to borrow
     */
    public void borrowBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.borrowBook(); // Triggers the internal logic inside Book.java
                return;
            }
        }
        System.out.println("Transaction failed: Book ID " + id + " does not exist.");
    }

    /**
     * Returns a borrowed book back to the library by its ID.
     * @param id The unique ID of the book to return
     */
    public void returnBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.returnBook(); // Triggers the internal logic inside Book.java
                return;
            }
        }
        System.out.println("Transaction failed: Book ID " + id + " does not exist.");
    }

    /**
     * Removes a book completely from the library database by its ID.
     * @param id The unique ID of the book to remove
     * @return true if successfully removed, false otherwise
     */
    public boolean removeBook(String id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                String removedTitle = books.get(i).getTitle();
                books.remove(i);
                System.out.println("Successfully removed \"" + removedTitle + "\" from the system.");
                return true;
            }
        }
        System.out.println("Removal failed: Book ID " + id + " does not exist.");
        return false;
    }
}