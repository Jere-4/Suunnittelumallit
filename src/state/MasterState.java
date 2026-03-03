package state;

import java.util.ArrayList;
import java.util.List;

public class MasterState extends BaseState {
    @Override
    public String getName() { return "Master"; }

    @Override
    public void train(GameCharacter c) {
        notAllowed("train", c);
    }

    @Override
    public void meditate(GameCharacter c) {
        notAllowed("meditate", c);
    }

    @Override
    public void fight(GameCharacter c) {
        notAllowed("fight", c);
    }

    @Override
    public List<String> actions() {
        // No in-game actions; game ends upon reaching Master.
        return new ArrayList<>();
    }
}
