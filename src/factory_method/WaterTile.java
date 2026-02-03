package factory_method;

public class WaterTile implements Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getType() {
        return "water";
    }

    @Override
    public void action() {
        // unused
    }
}
