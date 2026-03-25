package memento;

import javafx.scene.paint.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {

    private final Color color1;
    private final Color color2;
    private final Color color3;
    private final boolean checked;
    private final String timestamp;

    public Memento(Color c1, Color c2, Color c3, boolean checked) {
        this.color1 = c1;
        this.color2 = c2;
        this.color3 = c3;
        this.checked = checked;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public Color getColor1() { return color1; }
    public Color getColor2() { return color2; }
    public Color getColor3() { return color3; }
    public boolean isChecked() { return checked; }

    @Override
    public String getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return timestamp + " | Colors + Check=" + checked;
    }
}
