package template_method;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DiceRaceGame extends Game {

    private static final int TARGET = 30;
    private final Random rng = new Random();

    private int numberOfPlayers;
    private String[] playerNames;
    private int[] scores;

    private boolean gameOver;
    private int winnerIndex = -1;

    private Scanner scanner;

    @Override
    public void initializeGame(int numberOfPlayers) {
        if (numberOfPlayers < 1) {
            throw new IllegalArgumentException("There must be at least 1 player.");
        }
        this.numberOfPlayers = numberOfPlayers;
        this.playerNames = new String[numberOfPlayers];
        this.scores = new int[numberOfPlayers];
        this.gameOver = false;
        this.winnerIndex = -1;
        this.scanner = new Scanner(System.in);

        // Default names: Player 1, Player 2, ...
        for (int i = 0; i < numberOfPlayers; i++) {
            playerNames[i] = "Player " + (i + 1);
            scores[i] = 0;
        }

        System.out.println("=== Thirty To Win: Reach exactly " + TARGET + " ===");
        System.out.println("Rules:");
        System.out.println("  • On your turn, choose to roll 1 or 2 dice (d6).");
        System.out.println("  • If your score goes over " + TARGET + ", you BUST and reset to 0.");
        System.out.println("  • First to reach exactly " + TARGET + " wins.\n");
        System.out.println("Players: " + Arrays.toString(playerNames));
        System.out.println("Let's begin!\n");
    }

    @Override
    public boolean endOfGame() {
        return gameOver;
    }

    @Override
    public void playSingleTurn(int player) {
        if (gameOver) return; // Defensive

        String name = playerNames[player];
        System.out.println("--------------------------------------------------");
        System.out.println(name + "'s turn. Current score: " + scores[player]);
        System.out.println(scoreboard());

        int diceCount = askDiceCount(name); // 1 or 2

        int roll1 = rollDie();
        int total = roll1;
        StringBuilder rollReport = new StringBuilder("Rolled: [" + roll1);

        if (diceCount == 2) {
            int roll2 = rollDie();
            total += roll2;
            rollReport.append(", ").append(roll2);
        }
        rollReport.append("]  (Total this turn: ").append(total).append(")");
        System.out.println(rollReport);

        int newScore = scores[player] + total;

        if (newScore > TARGET) {
            System.out.println("BUST! You exceeded " + TARGET + ". Your score resets to 0.");
            scores[player] = 0;
        } else {
            scores[player] = newScore;
            System.out.println(name + "'s new score: " + scores[player]);
            if (newScore == TARGET) {
                gameOver = true;
                winnerIndex = player;
            }
        }
        System.out.println(); // spacing
    }

    @Override
    public void displayWinner() {
        System.out.println("==================================================");
        if (winnerIndex >= 0) {
            System.out.println(playerNames[winnerIndex] + " wins! Reached exactly " + TARGET + "!");
        } else {
            System.out.println("Game ended without a winner.");
        }
        System.out.println(scoreboard());
        System.out.println("Thanks for playing!");
    }

    private int rollDie() {
        return rng.nextInt(6) + 1;
    }

    private int askDiceCount(String name) {
        while (true) {
            System.out.print(name + ", roll 1 or 2 dice? Enter 1 or 2: ");
            String line = scanner.nextLine().trim();
            if (line.equals("1")) return 1;
            if (line.equals("2")) return 2;
            System.out.println("Invalid input. Please type 1 or 2.");
        }
    }

    private String scoreboard() {
        StringBuilder sb = new StringBuilder("Scoreboard: ");
        for (int i = 0; i < numberOfPlayers; i++) {
            if (i > 0) sb.append("  |  ");
            sb.append(playerNames[i]).append(": ").append(scores[i]);
        }
        return sb.toString();
    }
}

