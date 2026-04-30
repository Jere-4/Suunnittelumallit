package command;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelArtEditor extends Application {

    private static final int SIZE = 8;
    private static final int CELL_SIZE = 40;

    private PixelGridModel model;
    private Rectangle[][] cells;

    @Override
    public void start(Stage stage) {
        model = new PixelGridModel(SIZE);
        cells = new Rectangle[SIZE][SIZE];

        GridPane grid = createGrid();

        Button generateCodeButton = new Button("Create Code");
        generateCodeButton.setFocusTraversable(false);
        generateCodeButton.setOnAction(e ->
                new GenerateCodeCommand(model).execute()
        );

        BorderPane root = new BorderPane();
        root.setCenter(grid);
        root.setBottom(generateCodeButton);
        BorderPane.setAlignment(generateCodeButton, Pos.CENTER);

        Scene scene = new Scene(root, SIZE * CELL_SIZE, SIZE * CELL_SIZE + 50);
        setupKeyboard(scene);

        stage.setTitle("8x8 Pixel Art Editor");
        stage.setScene(scene);
        stage.show();

        root.requestFocus();
        redraw();
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setStroke(Color.GRAY);
                rect.setFill(Color.WHITE);
                cells[y][x] = rect;
                grid.add(rect, x, y);
            }
        }
        return grid;
    }

    private void setupKeyboard(Scene scene) {
        scene.setOnKeyPressed(e -> {
            Command command = null;

            if (e.getCode() == KeyCode.UP)
                command = new MoveCursorUpCommand(model);
            else if (e.getCode() == KeyCode.DOWN)
                command = new MoveCursorDownCommand(model);
            else if (e.getCode() == KeyCode.LEFT)
                command = new MoveCursorLeftCommand(model);
            else if (e.getCode() == KeyCode.RIGHT)
                command = new MoveCursorRightCommand(model);
            else if (e.getCode() == KeyCode.SPACE)
                command = new TogglePixelCommand(model);

            if (command != null) {
                command.execute();
                redraw();
            }
        });
    }

    private void redraw() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                Rectangle rect = cells[y][x];

                rect.setFill(model.isPixelOn(x, y) ? Color.BLACK : Color.WHITE);

                if (model.isCursorAt(x, y)) {
                    rect.setStroke(Color.RED);
                    rect.setStrokeWidth(3);
                } else {
                    rect.setStroke(Color.GRAY);
                    rect.setStrokeWidth(1);
                }
            }
        }
    }
}
