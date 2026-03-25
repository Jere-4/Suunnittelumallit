package memento;

import javafx.scene.paint.Color;

public class Model {

    private Color color1 = Color.RED;
    private Color color2 = Color.GREEN;
    private Color color3 = Color.BLUE;
    private boolean checked = false;

    public IMemento createMemento() {
        return new Memento(color1, color2, color3, checked);
    }

    public void restore(IMemento m) {
        Memento mem = (Memento) m;
        this.color1 = mem.getColor1();
        this.color2 = mem.getColor2();
        this.color3 = mem.getColor3();
        this.checked = mem.isChecked();
    }

    // Actions:
    public void changeColor1() { color1 = Color.color(Math.random(), Math.random(), Math.random()); }
    public void changeColor2() { color2 = Color.color(Math.random(), Math.random(), Math.random()); }
    public void changeColor3() { color3 = Color.color(Math.random(), Math.random(), Math.random()); }
    public void toggleChecked() { checked = !checked; }

    public Color getColor1() { return color1; }
    public Color getColor2() { return color2; }
    public Color getColor3() { return color3; }
    public boolean isChecked() { return checked; }
}
