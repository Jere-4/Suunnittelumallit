package state;

public abstract class BaseState implements CharacterState {
    protected void notAllowed(String action, GameCharacter c) {
        System.out.println(" You cannot " + action + " at the " + getName() + " level.");
    }

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
}
