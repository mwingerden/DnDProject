import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

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

    void battle() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int turnTracker = 0;
        String option;
        int roundCounter = 1;
        int characterCounter;
        Character character;
        do {
            characterCounter = 1;
            while(true) {
                if(tracker.isEmpty()) {
                    return;
                }
                System.out.println("Turn: " + roundCounter);
                for(CharacterTurn ct : tracker) {
                    System.out.print(characterCounter++ + ")" + ct);
                }
                if(turnTracker >= tracker.size()) {
                    turnTracker = 0;
                }
                character = tracker.get(turnTracker).getCharacter();
                System.out.println("\n" + character);
                System.out.println("\nEnter Option(Enter nothing for next turn): ");
                System.out.println("1.) health");
                System.out.println("2.) add");
                System.out.println("3.) end");
                option = scanner.nextLine();
                if(option.equalsIgnoreCase("health") || option.equals(("1"))) {
                    healthOption();
                    checkTracker();
                }
                else if(option.equalsIgnoreCase("add") || option.equals("2")) {
                    addMoreCharacters();
                }
                else {
                    break;
                }
                for(CharacterTurn ct : tracker) {
                    if(ct.getCharacter().hashCode() == character.hashCode()) {
                        turnTracker = tracker.indexOf(ct);
                    }
                }
            }
            roundCounter++;
            turnTracker++;
        }while(!(option.equalsIgnoreCase("end") || option.equals("3")));
    }

    void checkTracker() {
        tracker.removeIf(ct -> ct.getHp() <= 0);
    }

    void healthOption() {
        Scanner scanner = new Scanner(System.in);
        String option;
        System.out.println("Enter the corresponding number of the enemy: ");
        option = scanner.nextLine();
        if(Integer.parseInt(option) <= -1 || Integer.parseInt(option) >= tracker.size() + 1) {
            System.out.println("Please enter appropriate number.");
        }
        CharacterTurn instance = tracker.get(Integer.parseInt(option) - 1);
        System.out.println("Enter positive number for adding or negative number for subtraction: ");
        option = scanner.nextLine();
        instance.setHp(instance.getHp() + Integer.parseInt(option));
        System.out.println();
    }

    void addMoreCharacters() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Scanner scanner = new Scanner(System.in);
        String enemyName;
        int enemyAmount;
        do {
            System.out.println("Enter enemy name(hit return if done): ");
            enemyName = scanner.nextLine();
            if(!Objects.equals(enemyName, "")) {
                enemyName = enemyName.replaceAll(" ", "_");
                System.out.println("Enter enemy amount(Enter 0 to cancel): ");
                enemyAmount = Integer.parseInt(scanner.nextLine());
                if(enemyAmount < 0) {
                    System.out.println("Enter a number that isn't negative");
                }
            }
            else {
                return;
            }
            Character enemy = mapper.readValue(new File("./enemies/" + enemyName + ".json"), Enemy.class);
            addCharacter(enemy, enemyAmount);
        }while(!Objects.equals(enemyName, ""));
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
