package factory_method;

import java.util.Scanner;

public class Game {

    // Factory method that creates a map
    public static Map createMap(String type, int width, int height) {
        if (type.equalsIgnoreCase("city")) {
            return new CityMap(width, height);
        } else if (type.equalsIgnoreCase("wilderness")) {
            return new WildernessMap(width, height);
        }
        throw new IllegalArgumentException("Unknown map type: " + type);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose map type (city / wilderness): ");
        String type = scanner.nextLine();

        Map map = createMap(type, 10, 10);
        System.out.println("\nGenerated Map:");
        map.display();

        scanner.close();
    }
}
