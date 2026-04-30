package command;

public class MoveCursorUpCommand implements Command {
    private PixelGridModel model;

    public MoveCursorUpCommand(PixelGridModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.moveUp();
    }
}
