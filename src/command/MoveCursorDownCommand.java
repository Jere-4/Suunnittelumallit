package command;

public class MoveCursorDownCommand implements Command {
    private PixelGridModel model;

    public MoveCursorDownCommand(PixelGridModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.moveDown();
    }
}
