import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Library library = new Library();

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Book ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Title: ");
                    String title = input.nextLine();

                    System.out.print("Author: ");
                    String author = input.nextLine();

                    Book book = new Book(id, title, author);

                    library.addBook(book);

                    break;

                case 2:

                    library.displayBooks();

                    break;

                case 3:

                    System.out.print("Enter title: ");

                    String search = input.nextLine();

                    library.searchBook(search);

                    break;

                case 4:

                    System.out.print("Enter Book ID: ");

                    int borrowId = input.nextInt();

                    library.borrowBook(borrowId);

                    break;

                case 5:

                    System.out.print("Enter Book ID: ");

                    int returnId = input.nextInt();

                    library.returnBook(returnId);

                    break;

                case 6:

                    System.out.print("Enter Book ID: ");

                    int removeId = input.nextInt();

                    library.removeBook(removeId);

                    break;

                case 7:

                    System.out.println("Thank you for using the system.");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        input.close();
    }
}