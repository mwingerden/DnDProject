import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class InitiativeTracker {
    private final List<CharacterTurn> tracker;
    private final List<CharacterTurn> deadTracker;
    private final ObjectMapper mapper;

    public InitiativeTracker() {
        this.tracker = new ArrayList<>();
        this.deadTracker = new ArrayList<>();
        this.mapper = new ObjectMapper();
    }

    private void addCharacter(Character Character, int amount) {
        for(int i = 1; i <= amount; i++) {
            tracker.add(new CharacterTurn(Character, Character.rollInitiative()));
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
                tracker.add(new CharacterTurn(Character, Integer.parseInt(initiative)));
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
            addCharacter(ally, enemyAmount);
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
            addCharacter(enemy, enemyAmount);
        }while(!Objects.equals(enemyName, ""));
    }

    void battle() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int turnTracker = 0;
        String option;
        int roundCounter = 1;
        int characterCounter;
        Character character;
        do {
            while(true) {
                characterCounter = 1;
                if(tracker.isEmpty()) {
                    return;
                }
                System.out.println("Turn: " + roundCounter);
                for(CharacterTurn ct : tracker) {
                    if(ct.getCharacter() instanceof Enemy) {
                        System.out.print(characterCounter++ + ")" + ANSI.ANSI_RED + ct + ANSI.ANSI_RESET);
                    }
                    else if(ct.getCharacter() instanceof Ally) {
                        System.out.print(characterCounter++ + ")" + ANSI.ANSI_BLUE + ct + ANSI.ANSI_RESET);
                    }
                    else {
                        System.out.print(characterCounter++ + ")" + ANSI.ANSI_YELLOW + ct + ANSI.ANSI_RESET);
                    }
                }
                if(turnTracker >= tracker.size()) {
                    turnTracker = 0;
                }
                character = tracker.get(turnTracker).getCharacter();
                System.out.println("\n" + character);
                System.out.println("\nEnter Option(Enter nothing for next turn): ");
                System.out.println("1.) health");
                System.out.println("2.) add");
                System.out.println("3.) action");
                System.out.println("4.) saving throw");
                System.out.println("5.) skill check");
                System.out.println("6.) condition");
                System.out.println("7.) revive");
                System.out.println("8.) end");
                option = scanner.nextLine();
                if(option.equalsIgnoreCase("health") || option.equals(("1"))) {
                    health();
                    checkTracker();
                }
                else if(option.equalsIgnoreCase("add") || option.equals("2")) {
                    addMoreCharacters();
                }
                else if(option.equalsIgnoreCase("action") || option.equals("3")) {
                    attack();
                }
                else if(option.equalsIgnoreCase("saving throw") || option.equals("4")) {
                    rollSavingThrow();
                }
                else if(option.equalsIgnoreCase("skill check") || option.equals("5")) {
                    rollSkillCheck();
                }
                else if(option.equalsIgnoreCase("condition") || option.equals("6")) {
                    addCondition();
                }
                else if(option.equalsIgnoreCase("revive") || option.equals("7")) {
                    revive();
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
        }while(!(option.equalsIgnoreCase("end") || option.equals("8")));
    }

    void checkTracker() {
        for(int i = 0; i < tracker.size(); i++) {
            if(tracker.get(i).getHp() <= 0) {
                deadTracker.add(tracker.get(i));
                tracker.remove(tracker.get(i));
            }
        }
    }

    void addCondition() {
        Scanner scanner = new Scanner(System.in);
        String option;
        int placement;
        do {
            System.out.println("Select character to modify condition(Enter nothing if done): ");
            option = scanner.nextLine();
            if(option.isEmpty()) {
                return;
            }
            placement = Integer.parseInt(option) - 1;
            if(placement < 0 || placement > tracker.size()) {
                System.out.println("Enter number in the range of characters.");
                continue;
            }
            if(!tracker.get(placement).getCondition().isEmpty()) {
                System.out.println("This character already has a condition. Enter yes if you want to remove condition, nothing if no: ");
                option = scanner.nextLine();
                if (!option.isEmpty()) {
                    tracker.get(placement).setCondition("");
                }
                continue;
            }
            System.out.println("Enter condition: ");
            option = scanner.nextLine();
            tracker.get(placement).setCondition(option);
        }while(true);
    }

    void revive() {
        int initialTracker;
        int health = 0;
        String option;
        Scanner scanner = new Scanner(System.in);

        do {
            initialTracker = 1;
            if(!deadTracker.isEmpty()) {
                for(CharacterTurn characterTurn : deadTracker) {
                    System.out.println(initialTracker + ".) " + characterTurn);
                }
                System.out.println("Enter corresponding number to revive(Enter nothing when done): ");
                option = scanner.nextLine();
                if(!option.isEmpty()) {
                    initialTracker = Integer.parseInt(option) - 1;
                    if(initialTracker < 0 || initialTracker > deadTracker.size()) {
                        System.out.println("Enter appropriate number.");
                        continue;
                    }
                    System.out.println("Enter corresponding HP healed: ");
                    health = Integer.parseInt(scanner.nextLine());
                    CharacterTurn characterTurn = deadTracker.get(initialTracker);
                    characterTurn.setHp(health);
                    deadTracker.remove(characterTurn);
                    tracker.add(characterTurn);
                }
                else {
                    break;
                }
            }
            else {
                System.out.println("No one has died yet.");
                break;
            }
        }while(true);

    }

    void health() {
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

    void rollSavingThrow() {
        String option;
        Scanner scanner = new Scanner(System.in);
        Character character;
        int roll = 0;
        do {
            System.out.println("Enter number with corresponding character: ");
            option = scanner.nextLine();
            //TODO: Add check for 0 input
            //TODO: Add option for advantage/disadvantage
            character = tracker.get(Integer.parseInt(option) - 1).getCharacter();
            System.out.println("Enter Ability for Saving Throw");
            System.out.println("1.) Strength");
            System.out.println("2.) Dexterity");
            System.out.println("3.) Constitution");
            System.out.println("4.) Intelligence");
            System.out.println("5.) Wisdom");
            System.out.println("6.) Charisma");
            option = scanner.nextLine();

            if(option.equalsIgnoreCase("strength") || option.equals("1")) {
                roll = character.savingThrow("str");
            }
            else if(option.equalsIgnoreCase("dexterity") || option.equals("2")) {
                roll = character.savingThrow("dex");
            }
            else if(option.equalsIgnoreCase("constitution") || option.equals("3")) {
                roll = character.savingThrow("con");
            }
            else if(option.equalsIgnoreCase("intelligence") || option.equals("4")) {
                roll = character.savingThrow("int");
            }
            else if(option.equalsIgnoreCase("wisdom") || option.equals("5")) {
                roll = character.savingThrow("wis");
            }
            else if(option.equalsIgnoreCase("charisma") || option.equals("6")) {
                roll = character.savingThrow("cha");
            }

            System.out.println("The Saving Throw Roll: " + roll);

            System.out.println("Enter nothing if done.");
            option = scanner.nextLine();
        }while(!option.isEmpty());
    }

    void rollSkillCheck() {
        String option;
        Scanner scanner = new Scanner(System.in);
        Character character;
        int roll = 0;
        do {
            System.out.println("Enter number with corresponding character: ");
            option = scanner.nextLine();
            //TODO: Add check for 0 input
            //TODO: Add option for advantage/disadvantage
            character = tracker.get(Integer.parseInt(option) - 1).getCharacter();
            System.out.println("Enter Skill Check: ");
            System.out.println("1.) Acrobatics");
            System.out.println("2.) Animal Handling");
            System.out.println("3.) Arcana");
            System.out.println("4.) Athletics");
            System.out.println("5.) Deception");
            System.out.println("6.) History");
            System.out.println("7.) Insight");
            System.out.println("8.) Intimidation");
            System.out.println("9.) Investigation");
            System.out.println("10.) Medicine");
            System.out.println("11.) Nature");
            System.out.println("12.) Perception");
            System.out.println("13.) Performance");
            System.out.println("14.) Persuasion");
            System.out.println("15.) Religion");
            System.out.println("16.) Sleight of Hand");
            System.out.println("17.) Stealth");
            System.out.println("18.) Survival");
            option = scanner.nextLine();

            if(option.equalsIgnoreCase("acrobatics") || option.equals("1")) {
                roll = character.skillCheck("acrobatics");
            }
            else if(option.equalsIgnoreCase("animal handling") || option.equals("2")) {
                roll = character.skillCheck("animal handling");
            }
            else if(option.equalsIgnoreCase("arcana") || option.equals("3")) {
                roll = character.skillCheck("arcana");
            }
            else if(option.equalsIgnoreCase("athletics") || option.equals("4")) {
                roll = character.skillCheck("athletics");
            }
            else if(option.equalsIgnoreCase("deception") || option.equals("5")) {
                roll = character.skillCheck("deception");
            }
            else if(option.equalsIgnoreCase("history") || option.equals("6")) {
                roll = character.skillCheck("history");
            }
            else if(option.equalsIgnoreCase("insight") || option.equals("7")) {
                roll = character.skillCheck("insight");
            }
            else if(option.equalsIgnoreCase("intimidation") || option.equals("8")) {
                roll = character.skillCheck("intimidation");
            }
            else if(option.equalsIgnoreCase("investigation") || option.equals("9")) {
                roll = character.skillCheck("investigation");
            }
            else if(option.equalsIgnoreCase("medicine") || option.equals("10")) {
                roll = character.skillCheck("medicine");
            }
            else if(option.equalsIgnoreCase("nature") || option.equals("11")) {
                roll = character.skillCheck("nature");
            }
            else if(option.equalsIgnoreCase("perception") || option.equals("12")) {
                roll = character.skillCheck("perception");
            }
            else if(option.equalsIgnoreCase("performance") || option.equals("13")) {
                roll = character.skillCheck("performance");
            }
            else if(option.equalsIgnoreCase("persuasion") || option.equals("14")) {
                roll = character.skillCheck("persuasion");
            }
            else if(option.equalsIgnoreCase("religion") || option.equals("15")) {
                roll = character.skillCheck("religion");
            }
            else if(option.equalsIgnoreCase("sleight of hand") || option.equals("16")) {
                roll = character.skillCheck("sleight of hand");
            }
            else if(option.equalsIgnoreCase("stealth") || option.equals("17")) {
                roll = character.skillCheck("stealth");
            }
            else if(option.equalsIgnoreCase("survival") || option.equals("18")) {
                roll = character.skillCheck("survival");
            }

            System.out.println("The Skill Check Roll: " + roll);

            System.out.println("Enter nothing if done.");
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
