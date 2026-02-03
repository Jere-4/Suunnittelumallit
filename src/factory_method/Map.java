package factory_method;

import java.util.Random;

public abstract class Map {
    protected int width;
    protected int height;
    protected Tile[][] tiles;
    protected Random random = new Random();

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[height][width];

        // fill map with tiles
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = createTile();
            }
        }
    }

    // Factory method
    protected abstract Tile createTile();

    // Display map
    public void display() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(tiles[y][x].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
