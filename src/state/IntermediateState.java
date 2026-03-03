package state;

import java.util.ArrayList;
import java.util.List;

public class IntermediateState extends BaseState {
    @Override
    public String getName() { return "Intermediate"; }

    @Override
    public void train(GameCharacter c) {
        System.out.println("You refine techniques and push your limits...");
        c.addExperience(GameCharacter.TRAIN_XP_GAIN);
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("You meditate to restore focus and vitality...");
        c.addHealth(GameCharacter.MEDITATE_HP_GAIN);
    }

    @Override
    public List<String> actions() {
        List<String> a = new ArrayList<>();
        a.add("T");
        a.add("M");
        return a;
    }
}
