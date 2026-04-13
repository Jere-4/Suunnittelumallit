package flyweight.render;

import flyweight.map.GameMap;
import flyweight.map.Tile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class MapRenderer {

    private static final int TILE_SIZE = 32;

    public static void render(GameMap map, GraphicsContext gc) {
        for (Tile[] row : map.getTiles()) {
            for (Tile tile : row) {
                Paint paint = TileGraphicFactory.getGraphic(tile.getType());

                gc.setFill(paint);
                gc.fillRect(
                        tile.getX() * TILE_SIZE,
                        tile.getY() * TILE_SIZE,
                        TILE_SIZE,
                        TILE_SIZE
                );
            }
        }
    }
}
