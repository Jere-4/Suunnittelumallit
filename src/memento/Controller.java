package memento;

import javafx.scene.paint.Color;
import java.util.Stack;

public class Controller {

    private Model model;

    private Stack<IMemento> undoStack = new Stack<>();
    private Stack<IMemento> redoStack = new Stack<>();

    public Controller(Model model) {
        this.model = model;
    }

    public void saveState() {
        undoStack.push(model.createMemento());
        redoStack.clear(); // new edit clears redo history
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(model.createMemento());
            IMemento previousState = undoStack.pop();
            model.restore(previousState);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(model.createMemento());
            IMemento nextState = redoStack.pop();
            model.restore(nextState);
        }
    }

    public Model getModel() {
        return model;
    }
}
