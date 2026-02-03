package factory_method;

public class RoadTile implements Tile {
    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    public String getType() {
        return "road";
    }

    @Override
    public void action() {
        // unused
    }
}
