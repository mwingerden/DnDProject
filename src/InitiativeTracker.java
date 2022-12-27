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
        int roundCounter = 1;
        int characterCounter;
        do {
            if(tracker.isEmpty()) {
                return;
            }
            System.out.println("Turn: " + roundCounter++);
            characterCounter = 1;
            for(CharacterTurn ct : tracker) {
                System.out.print(characterCounter++ + ")" + ct);
            }
            if(turnTracker >= tracker.size()) {
                turnTracker = 0;
            }
            Character character = tracker.get(turnTracker++).getCharacter();
            System.out.println("\n" + character);
            System.out.println("\nEnter Option(Enter nothing for next turn): ");
            System.out.println("1.) health");
            option = scanner.nextLine();
            if(option.equalsIgnoreCase("health") || option.equalsIgnoreCase("1")) {
                healthOption();
                checkTracker();
            }
        }while(!option.equalsIgnoreCase("end"));
    }

    void checkTracker() {
        tracker.removeIf(ct -> ct.getHp() <= 0);
    }

    void healthOption() {
        Scanner scanner = new Scanner(System.in);
        String option;
        System.out.println("Enter the corresponding number of the enemy: ");
        option = scanner.nextLine();
        if(Integer.parseInt(option) <= -1 || Integer.parseInt(option) >= tracker.size()) {
            System.out.println("Please enter appropriate number.");
        }
        CharacterTurn instance = tracker.get(Integer.parseInt(option) - 1);
        System.out.println("Enter positive number for adding or negative number for subtraction: ");
        option = scanner.nextLine();
        instance.setHp(instance.getHp() + Integer.parseInt(option));
        System.out.println();
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
