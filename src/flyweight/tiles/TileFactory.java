package flyweight.tiles;

import flyweight.map.Tile;

import java.util.Random;

public class TileFactory {

    private final Random random = new Random();

    public Tile createTile(int x, int y) {
        int r = random.nextInt(3);
        TileType type = switch (r) {
            case 0 -> TileType.GRASS;
            case 1 -> TileType.WATER;
            default -> TileType.MOUNTAIN;
        };
        return new Tile(type, x, y);
    }
}
