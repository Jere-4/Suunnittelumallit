package memento;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorBox extends Rectangle {

    public ColorBox(Color color) {
        super(100, 100, color);
        setStroke(Color.BLACK);
    }

    public void setColor(Color color) {
        setFill(color);
    }
}
