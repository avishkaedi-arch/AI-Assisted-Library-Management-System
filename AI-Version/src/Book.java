public class Book {
    // Private instance variables (Encapsulation)
    private String id;
    private String title;
    private String author;
    private boolean isBorrowed;

    /**
     * Parameterized Constructor to initialize a new Book object.
     * By default, a new book is not borrowed.
     * * @param id     The unique identifier of the book
     * @param title  The title of the book
     * @param author The author of the book
     */
    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false; // Default status
    }

    // --- Getters ---

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // --- Business Logic Methods ---

    /**
     * Borrows the book if it is currently available.
     * * @return true if the book was successfully borrowed, false if it was already borrowed.
     */
    public boolean borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Successfully borrowed: \"" + title + "\"");
            return true;
        } else {
            System.out.println("Sorry, \"" + title + "\" is already borrowed.");
            return false;
        }
    }

    /**
     * Returns the book to the library.
     * * @return true if the book was successfully returned, false if it wasn't checked out.
     */
    public boolean returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Successfully returned: \"" + title + "\"");
            return true;
        } else {
            System.out.println("\"" + title + "\" was not borrowed.");
            return false;
        }
    }

    // --- toString Method ---

    @Override
    public String toString() {
        String status = isBorrowed ? "Borrowed" : "Available";
        return "Book Details: [ID: " + id + ", Title: \"" + title + "\", Author: " + author + ", Status: " + status + "]";
    }
}