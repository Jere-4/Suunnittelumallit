package command;

public class TogglePixelCommand implements Command {
    private PixelGridModel model;

    public TogglePixelCommand(PixelGridModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.togglePixel();
    }
}
