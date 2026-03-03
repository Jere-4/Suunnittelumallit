package state;

import java.util.List;

public interface CharacterState {
    String getName();
    void train(GameCharacter c);
    void meditate(GameCharacter c);
    void fight(GameCharacter c);

    List<String> actions();
}
