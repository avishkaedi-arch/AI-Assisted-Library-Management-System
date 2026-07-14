import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\n========== BOOK LIST ==========");

        for (Book book : books) {
            System.out.println(book);
            System.out.println("----------------------------");
        }
    }

    public void searchBook(String title) {
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Found");
                System.out.println(book);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void borrowBook(int id) {

        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isBorrowed()) {
                    book.borrowBook();
                    System.out.println("Book borrowed successfully.");

                } else {
                    System.out.println("Book is already borrowed.");
                }

                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    public void returnBook(int id) {

        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isBorrowed()) {

                    book.returnBook();
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book ID not found.");
    }
    public void removeBook(int id) {

        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book ID not found.");
    }
}
