package prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Recommendation> recommendations = new ArrayList<>();

    public static void main(String[] args) {
        seedData();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nBook Recommendation System");
            System.out.println("1. View recommendations");
            System.out.println("2. Clone recommendation");
            System.out.println("3. Create new recommendation");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewRecommendations();
                case 2 -> cloneRecommendation(scanner);
                case 3 -> createRecommendation(scanner);
                case 4 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    private static void seedData() {
        Recommendation kids = new Recommendation("Fantasy");
        kids.addBook(new Book("Harry Potter", "J.K. Rowling", "Fantasy", 1997));
        kids.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937));

        Recommendation sciFi = new Recommendation("Science Fiction");
        sciFi.addBook(new Book("Dune", "Frank Herbert", "Science Fiction", 1965));
        sciFi.addBook(new Book("Neuromancer", "William Gibson", "Cyberpunk", 1984));

        recommendations.add(kids);
        recommendations.add(sciFi);
    }

    private static void viewRecommendations() {
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("\n[" + i + "]");
            System.out.println(recommendations.get(i));
        }
    }

    private static void cloneRecommendation(Scanner scanner) {
        viewRecommendations();
        System.out.print("Enter index to clone: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        Recommendation clone = recommendations.get(index).clone();

        System.out.print("New target audience: ");
        clone.setTargetAudience(scanner.nextLine());

        recommendations.add(clone);
        System.out.println("Recommendation cloned and added.");
    }

    private static void createRecommendation(Scanner scanner) {
        System.out.print("Target audience: ");
        Recommendation rec = new Recommendation(scanner.nextLine());

        boolean adding = true;
        while (adding) {
            System.out.print("Book title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Genre: ");
            String genre = scanner.nextLine();
            System.out.print("Publication year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            rec.addBook(new Book(title, author, genre, year));

            System.out.print("Add another book? (y/n): ");
            adding = scanner.nextLine().equalsIgnoreCase("y");
        }
        recommendations.add(rec);
    }
}
