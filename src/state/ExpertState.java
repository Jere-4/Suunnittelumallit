package state;

import java.util.ArrayList;
import java.util.List;

public class ExpertState extends BaseState {
    @Override
    public String getName() { return "Expert"; }

    @Override
    public void train(GameCharacter c) {
        System.out.println("You master advanced forms and intense regimens...");
        c.addExperience(GameCharacter.TRAIN_XP_GAIN);
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("Deep meditation enhances your resilience...");
        c.addHealth(GameCharacter.MEDITATE_HP_GAIN);
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("You engage in a challenging duel...");
        c.addHealth(-GameCharacter.FIGHT_HP_COST);
        c.addExperience(GameCharacter.FIGHT_XP_GAIN);
        if (c.getHealth() == GameCharacter.MIN_HP) {
            System.out.println("⚠️ Your health is critically low. Consider meditating.");
        }
    }

    @Override
    public List<String> actions() {
        List<String> a = new ArrayList<>();
        a.add("T");
        a.add("M");
        a.add("F");
        return a;
    }
}
