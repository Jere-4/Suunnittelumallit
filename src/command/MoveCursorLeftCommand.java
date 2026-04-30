package command;

public class MoveCursorLeftCommand implements Command {
    private PixelGridModel model;

    public MoveCursorLeftCommand(PixelGridModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.moveLeft();
    }
}
