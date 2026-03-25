package memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Controller {

    private Model model;

    private Stack<IMemento> undoStack = new Stack<>();
    private Stack<IMemento> redoStack = new Stack<>();
    private List<IMemento> historyList = new ArrayList<>();

    public Controller(Model model) {
        this.model = model;
    }

    public void saveState() {
        IMemento m = model.createMemento();
        undoStack.push(m);
        historyList.add(m);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(model.createMemento());
            IMemento prev = undoStack.pop();
            model.restore(prev);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(model.createMemento());
            IMemento next = redoStack.pop();
            model.restore(next);
        }
    }

    public void restoreFromHistory(IMemento m) {
        undoStack.push(model.createMemento());
        redoStack.clear();
        model.restore(m);
    }

    public List<IMemento> getHistoryList() {
        return historyList;
    }

    public Model getModel() {
        return model;
    }
}
