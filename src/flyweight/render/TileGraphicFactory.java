package flyweight.render;

import flyweight.tiles.TileType;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {

    private static final Map<TileType, Paint> graphics = new HashMap<>();

    public static Paint getGraphic(TileType type) {
        if (!graphics.containsKey(type)) {
            graphics.put(type, createGraphic(type));
            System.out.println("Creating graphic for " + type);
        }
        return graphics.get(type);
    }

    private static Paint createGraphic(TileType type) {
        return switch (type) {
            case GRASS -> Color.LIGHTGREEN;
            case WATER -> Color.DEEPSKYBLUE;
            case MOUNTAIN -> Color.GRAY;
        };
    }
}
