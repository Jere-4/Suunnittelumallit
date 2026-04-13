package flyweight.map;

import flyweight.tiles.TileType;

public class Tile {
    private final TileType type;
    private final int x;
    private final int y;

    public Tile(TileType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public TileType getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
