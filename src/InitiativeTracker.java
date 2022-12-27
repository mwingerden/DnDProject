import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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

    void battle() {
        Scanner scanner = new Scanner(System.in);
        int turnTracker = 0;
        String option;
        int count = 1;
        int countTwo;
        System.out.println("Turn: " + count++);
        do {
            countTwo = 1;
            for(CharacterTurn ct : tracker) {
                System.out.print(countTwo + ")" + ct);
            }
            Character character = tracker.get(turnTracker++).getCharacter();
            System.out.println("\n" + character);
            if(turnTracker >= tracker.size()) {
                turnTracker = 0;
            }
            System.out.println("\nClick next for the next character in turn order: ");
            option = scanner.nextLine();
            if(option.equalsIgnoreCase("next")) {
                System.out.println("Turn: " + count++);
            }
            else if(option.equalsIgnoreCase("health")) {
                System.out.println("Enter the corresponding number of the enemy: ");
            }
        }while(!option.equalsIgnoreCase("end"));
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
