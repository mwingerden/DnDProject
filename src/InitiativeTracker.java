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

    void addCharacter(Character Character, int amount, int initiative) {
        for(int i = 1; i <= amount; i++) {
            tracker.add(new CharacterTurn(Character, initiative));
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
                Character Character = new Player(playerName);
                System.out.println("Enter initiative: ");
                initiative = scanner.nextLine();
                addCharacter(Character, 1, Integer.parseInt(initiative));
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
        Character ally;
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
        Character enemy;
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
        Character Character;
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
                Character = tracker.get(turnTracker).getCharacter();
                System.out.println("\n" + Character);
                System.out.println("\nEnter Option(Enter nothing for next turn): ");
                System.out.println("1.) health");
                System.out.println("2.) add");
                System.out.println("3.) action");
                System.out.println("4.) end");
                option = scanner.nextLine();
                if(option.equalsIgnoreCase("health") || option.equals(("1"))) {
                    healthOption();
                    checkTracker();
                }
                else if(option.equalsIgnoreCase("add") || option.equals("2")) {
                    addMoreCharacters();
                }
                else if(option.equalsIgnoreCase("action") || option.equals("3")) {
                    attack();
                }
                else {
                    break;
                }
                for(CharacterTurn ct : tracker) {
                    if(ct.getCharacter().hashCode() == Character.hashCode()) {
                        turnTracker = tracker.indexOf(ct);
                    }
                }
            }
            roundCounter++;
            turnTracker++;
        }while(!(option.equalsIgnoreCase("end") || option.equals("4")));
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

    void attack() {
        Dice dice = new Dice();
        Scanner scanner = new Scanner(System.in);
        String option;
        int roll = dice.dTwenty();
        int amount;
        int total = 0;
        int bonus;

        do {
            System.out.println("Initial Roll: " + roll);
            System.out.println("Add bonus to hit: ");
            option = scanner.nextLine();
            System.out.println("Final Roll: " + (roll + Integer.parseInt(option)));
            System.out.println("Enter yes if hit, nothing if no hit: ");
            option = scanner.nextLine();
            if(!option.isEmpty()) {
                System.out.println("Enter amount of dice to roll: ");
                amount = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the dice to roll: ");
                System.out.println("1.) d20 ");
                System.out.println("2.) d12 ");
                System.out.println("3.) d10 ");
                System.out.println("4.) d8 ");
                System.out.println("5.) d6 ");
                System.out.println("6.) d4 ");
                System.out.println("7.) d100 ");
                option = scanner.nextLine();
                System.out.println("Add bonus to hit: ");
                bonus = Integer.parseInt(scanner.nextLine());
                for(int i = 0; i < amount; i++) {
                    if(option.equalsIgnoreCase("d20") || option.equals("1")) {
                        roll = dice.dTwenty();
                    }
                    else if(option.equalsIgnoreCase("d12") || option.equals("2")) {
                        roll = dice.dTwenty();
                    }
                    else if(option.equalsIgnoreCase("d10") || option.equals("3")) {
                        roll = dice.dTwelve();
                    }
                    else if(option.equalsIgnoreCase("d8") || option.equals("4")) {
                        roll = dice.dEight();
                    }
                    else if(option.equalsIgnoreCase("d6") || option.equals("5")) {
                        roll = dice.dSix();
                    }
                    else if(option.equalsIgnoreCase("d4") || option.equals("6")) {
                        roll = dice.dFour();
                    }
                    else if(option.equalsIgnoreCase("d100") || option.equals("7")) {
                        roll = dice.dOneHundred();
                    }
                    total += roll + bonus;
                }

            }
            System.out.println("Total Damage: " + total);

            System.out.println("Enter nothing if character is done attacking.");
            option = scanner.nextLine();
        }while(!option.isEmpty());

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
