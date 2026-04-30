package command;

public class MoveCursorRightCommand implements Command {
    private PixelGridModel model;

    public MoveCursorRightCommand(PixelGridModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.moveRight();
    }
}
