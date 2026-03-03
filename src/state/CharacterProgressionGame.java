package state;

import java.util.Scanner;

public class CharacterProgressionGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Character Progression (State Pattern) ===");
        System.out.print("Enter your hero's name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) name = "Hero";

        GameCharacter hero = new GameCharacter(name);

        // Main game loop
        while (true) {
            System.out.println("\n--------------------------------------------");
            System.out.printf("Name: %s | Level: %s | XP: %d | HP: %d%n",
                    hero.getName(), hero.getStateName(), hero.getExperience(), hero.getHealth());

            String nextInfo = hero.nextLevelXpInfo();
            if (!nextInfo.isEmpty()) {
                System.out.println("Next level: " + nextInfo);
            } else {
                System.out.println("You are at the final level.");
            }

            // Show available actions
            System.out.println("Available actions: " + hero.getAvailableActionsAsText());
            System.out.print("Choose action (T/M/F) or Q to quit: ");

            String input = sc.nextLine().trim().toLowerCase();
            if (input.isEmpty()) continue;

            char ch = input.charAt(0);
            if (ch == 'q') {
                System.out.println("Goodbye!");
                break;
            }

            switch (ch) {
                case 't':
                    hero.train();
                    break;
                case 'm':
                    hero.meditate();
                    break;
                case 'f':
                    hero.fight();
                    break;
                default:
                    System.out.println(" Unknown action. Try again.");
                    break;
            }

            // End condition: Master level reached
            if (hero.isMaster()) {
                System.out.println("\n Congratulations! You have reached the Master level.");
                System.out.println(" Game over.");
                break;
            }
        }

        sc.close();
    }
}
