import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class InitiativeTracker {
    private final List<CharacterTurn> tracker;
    private final ObjectMapper mapper;

    public InitiativeTracker() {
        this.tracker = new ArrayList<>();
        this.mapper = new ObjectMapper();
    }

    void addCharacter(NPC NPC, int amount, int initiative) {
        for(int i = 1; i <= amount; i++) {
            tracker.add(new CharacterTurn(NPC, initiative));
        }
        tracker.sort(Comparator.comparing(CharacterTurn::getInitiative).reversed());
    }

    int isEmpty() {
        return tracker.size();
    }

    void addPlayer() {
        Scanner scanner = new Scanner(System.in);
        String playerName;
        String initiative;
        do {
            System.out.println("Enter player name(hit return if done): ");
            playerName = scanner.nextLine();
            if(!Objects.equals(playerName, "")) {
                NPC NPC = new Player(playerName);
                System.out.println("Enter initiative: ");
                initiative = scanner.nextLine();
                addCharacter(NPC, 1, Integer.parseInt(initiative));
            }
            else {
                return;
            }
        }while(!Objects.equals(playerName, ""));
    }

    void addAlley() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String allyName;
        int enemyAmount;
        NPC ally;
        do {
            System.out.println("Enter ally name(hit return if done): ");
            allyName = scanner.nextLine();
            if(!Objects.equals(allyName, "")) {
                allyName = allyName.replaceAll(" ", "_");
                System.out.println("Enter amount(Enter 0 to cancel): ");
                enemyAmount = Integer.parseInt(scanner.nextLine());
                if(enemyAmount < 0) {
                    System.out.println("Enter a number that isn't negative");
                }
            }
            else {
                return;
            }
            ally = mapper.readValue(new File("./allies/" + allyName + ".json"), Enemy.class);
            addCharacter(ally, enemyAmount, ally.rollInitiative());
        }while(!Objects.equals(allyName, ""));
    }

    void addEnemy() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String enemyName;
        int enemyAmount;
        NPC enemy;
        do {
            System.out.println("Enter enemy name(hit return if done): ");
            enemyName = scanner.nextLine();
            if(!Objects.equals(enemyName, "")) {
                enemyName = enemyName.replaceAll(" ", "_");
                System.out.println("Enter amount(Enter 0 to cancel): ");
                enemyAmount = Integer.parseInt(scanner.nextLine());
                if(enemyAmount < 0) {
                    System.out.println("Enter a number that isn't negative");
                }
            }
            else {
                return;
            }
            enemy = mapper.readValue(new File("./enemies/" + enemyName + ".json"), Enemy.class);
            addCharacter(enemy, enemyAmount, enemy.rollInitiative());
        }while(!Objects.equals(enemyName, ""));
    }

    void battle() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int turnTracker = 0;
        String option;
        int roundCounter = 1;
        int characterCounter;
        NPC NPC;
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
                NPC = tracker.get(turnTracker).getCharacter();
                System.out.println("\n" + NPC);
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
                    if(ct.getCharacter().hashCode() == NPC.hashCode()) {
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you adding: ");
        System.out.println("1.) Enemy ");
        System.out.println("2.) Ally ");
        System.out.println("3.) Player ");
        String option = scanner.nextLine();

        if(option.equalsIgnoreCase("enemy") || option.equals("1")) {
            addEnemy();
        }
        else if (option.equalsIgnoreCase("ally") || option.equals("2")) {
            addAlley();
        }
        else if (option.equalsIgnoreCase("player") || option.equals("3")) {
            addPlayer();
        }
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
