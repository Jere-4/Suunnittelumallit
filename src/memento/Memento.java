package memento;

import javafx.scene.paint.Color;

public class Memento implements IMemento {

    private final Color color1;
    private final Color color2;
    private final Color color3;
    private final boolean checked;

    public Memento(Color c1, Color c2, Color c3, boolean checked) {
        this.color1 = c1;
        this.color2 = c2;
        this.color3 = c3;
        this.checked = checked;
    }

    public Color getColor1() { return color1; }
    public Color getColor2() { return color2; }
    public Color getColor3() { return color3; }
    public boolean isChecked() { return checked; }
}