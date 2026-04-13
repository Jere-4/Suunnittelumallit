package flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import flyweight.map.GameMap;
import flyweight.render.MapRenderer;
import flyweight.tiles.TileFactory;

public class Game extends Application {

    private static final int MAP_WIDTH = 20;
    private static final int MAP_HEIGHT = 15;
    private static final int TILE_SIZE = 32;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(
                MAP_WIDTH * TILE_SIZE,
                MAP_HEIGHT * TILE_SIZE
        );
        GraphicsContext gc = canvas.getGraphicsContext2D();

        TileFactory factory = new TileFactory();
        GameMap map = new GameMap(MAP_WIDTH, MAP_HEIGHT, factory);

        MapRenderer.render(map, gc);

        Pane root = new Pane(canvas);
        stage.setScene(new Scene(root));
        stage.setTitle("RPG Map – Flyweight Rendering");
        stage.show();
    }
}
