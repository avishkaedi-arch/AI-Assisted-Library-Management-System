import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=========================================");
        System.out.println("  Welcome to the Library Management System  ");
        System.out.println("=========================================");

        library.addBook(new Book("B001","Java Programming","James Gosling"));
        library.addBook(new Book("B002","Clean Code","Robert Martin"));
        library.addBook(new Book("B003","Algorithms","Thomas Cormen"));

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");
            System.out.print("Please enter your choice (1-7): ");

            // Read the input securely (handling non-integer values)
            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline character
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.nextLine(); // Clear the invalid input from scanner buffer
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- Add a New Book ---");
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();

                    // Create a new Book object and add it to the library
                    Book newBook = new Book(id, title, author);
                    library.addBook(newBook);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.println("\n--- Search Book ---");
                    System.out.print("Enter the title of the book to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;

                case 4:
                    System.out.println("\n--- Borrow Book ---");
                    System.out.print("Enter the ID of the book you want to borrow: ");
                    String borrowId = scanner.nextLine();
                    library.borrowBook(borrowId);
                    break;

                case 5:
                    System.out.println("\n--- Return Book ---");
                    System.out.print("Enter the ID of the book you want to return: ");
                    String returnId = scanner.nextLine();
                    library.returnBook(returnId);
                    break;

                case 6:
                    System.out.println("\n--- Remove Book ---");
                    System.out.print("Enter the ID of the book to remove from the system: ");
                    String removeId = scanner.nextLine();
                    library.removeBook(removeId);
                    break;

                case 7:
                    System.out.println("\nExiting the system. Thank you for using the Library Management System!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select an option from 1 to 7.");
            }
        }

        scanner.close(); // Close the resource
    }
}