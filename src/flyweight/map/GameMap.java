package flyweight.map;

import flyweight.tiles.TileFactory;

public class GameMap {
    private final Tile[][] tiles;

    public GameMap(int width, int height, TileFactory factory) {
        tiles = new Tile[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = factory.createTile(x, y);
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
