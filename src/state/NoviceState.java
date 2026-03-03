package state;

import java.util.ArrayList;
import java.util.List;

public class NoviceState extends BaseState {
    @Override
    public String getName() { return "Novice"; }

    @Override
    public void train(GameCharacter c) {
        System.out.println("You practice basic drills...");
        c.addExperience(GameCharacter.TRAIN_XP_GAIN);
    }

    @Override
    public List<String> actions() {
        List<String> a = new ArrayList<>();
        a.add("T");
        return a;
    }
}
