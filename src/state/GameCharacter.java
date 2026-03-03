package state;

import java.util.List;

public class GameCharacter {

    // --- Progression thresholds ---
    public static final int NOVICE_TO_INTERMEDIATE_XP = 50;
    public static final int INTERMEDIATE_TO_EXPERT_XP = 150;
    public static final int EXPERT_TO_MASTER_XP = 300;

    // --- Action effects ---
    public static final int TRAIN_XP_GAIN = 10;
    public static final int MEDITATE_HP_GAIN = 7;
    public static final int FIGHT_XP_GAIN = 20;
    public static final int FIGHT_HP_COST = 12;

    // --- Health bounds ---
    public static final int MAX_HP = 100;
    public static final int MIN_HP = 0;

    private final String name;
    private int experience;
    private int health;

    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.state = new NoviceState(); // starting state
    }

    public void train() {
        state.train(this);
        checkLevelUp();
    }

    public void meditate() {
        state.meditate(this);
        checkLevelUp();
    }

    public void fight() {
        state.fight(this);
        checkLevelUp();
    }

    // State transitions based on XP thresholds
    private void checkLevelUp() {
        CharacterState oldState = this.state;
        if (experience >= EXPERT_TO_MASTER_XP) {
            this.state = new MasterState();
        } else if (experience >= INTERMEDIATE_TO_EXPERT_XP) {
            this.state = new ExpertState();
        } else if (experience >= NOVICE_TO_INTERMEDIATE_XP) {
            this.state = new IntermediateState();
        } else {
            if (!(this.state instanceof NoviceState)) {
                this.state = new NoviceState();
            }
        }

        if (oldState.getClass() != this.state.getClass()) {
            System.out.println(">>> Level up! You are now: " + getStateName());
        }
    }

    public void addExperience(int amount) {
        int old = this.experience;
        this.experience = Math.max(0, this.experience + amount);
        int delta = this.experience - old;
        if (delta > 0) {
            System.out.println(" XP +" + delta + " (Total: " + this.experience + ")");
        } else if (delta < 0) {
            System.out.println(" XP " + delta + " (Total: " + this.experience + ")");
        }
    }

    public void addHealth(int delta) {
        int old = this.health;
        this.health = Math.max(MIN_HP, Math.min(MAX_HP, this.health + delta));
        int actualDelta = this.health - old;
        if (actualDelta > 0) {
            System.out.println(" HP +" + actualDelta + " (Total: " + this.health + ")");
        } else if (actualDelta < 0) {
            System.out.println(" HP " + actualDelta + " (Total: " + this.health + ")");
        }
    }

    public String getStateName() {
        return state.getName();
    }

    public String getAvailableActionsAsText() {
        // Build readable list like: [T]rain  [M]editate  [F]ight  [Q]uit
        List<String> actions = state.actions();
        StringBuilder sb = new StringBuilder();
        if (actions.contains("T")) sb.append("[T]rain  ");
        if (actions.contains("M")) sb.append("[M]editate  ");
        if (actions.contains("F")) sb.append("[F]ight  ");
        sb.append("[Q]uit");
        return sb.toString().trim();
    }

    public String nextLevelXpInfo() {
        if (isMaster()) return "";
        int xp = this.experience;

        int nextTarget;
        String nextName;
        if (xp < NOVICE_TO_INTERMEDIATE_XP) {
            nextTarget = NOVICE_TO_INTERMEDIATE_XP;
            nextName = "Intermediate";
        } else if (xp < INTERMEDIATE_TO_EXPERT_XP) {
            nextTarget = INTERMEDIATE_TO_EXPERT_XP;
            nextName = "Expert";
        } else {
            nextTarget = EXPERT_TO_MASTER_XP;
            nextName = "Master";
        }
        int remaining = nextTarget - xp;
        return String.format("%s at %d XP (%d more XP needed)", nextName, nextTarget, Math.max(0, remaining));
    }

    public String getName() { return name; }
    public int getExperience() { return experience; }
    public int getHealth() { return health; }
    public boolean isMaster() { return state instanceof MasterState; }
}
