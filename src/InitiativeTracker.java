import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InitiativeTracker {
    private final List<CharacterTurn> tracker;

    public InitiativeTracker() {
        this.tracker = new ArrayList<>();
    }

    void addCharacter(Character character, int amount) {
        for(int i = 1; i <= amount; i++) {
            tracker.add(new CharacterTurn(character, character.rollInitiative()));
        }
        tracker.sort(Comparator.comparing(CharacterTurn::getInitiative).reversed());
    }

    int isEmpty() {
        return tracker.size();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(CharacterTurn character : tracker) {
            str.append(character.toString());
        }
        return str.toString();
    }
}
