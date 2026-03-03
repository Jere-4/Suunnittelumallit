package template_method;

public class Main {
    public static void main(String[] args) {
        int players = 2; // default
        if (args.length > 0) {
            try {
                players = Integer.parseInt(args[0]);
                if (players < 1) {
                    System.out.println("Players must be >= 1. Using default 2.");
                    players = 2;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid player count. Using default 2.");
            }
        }

        Game game = new DiceRaceGame();
        game.play(players);
    }
}
