import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class UI {
    private final InitiativeTracker initiativeTracker;
    private final ObjectMapper mapper;

    public UI() {
        this.initiativeTracker = new InitiativeTracker();
        mapper = new ObjectMapper();
    }

    public void addEnemy() throws IOException {
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
            initiativeTracker.addCharacter(enemy, enemyAmount);
        }while(!Objects.equals(enemyName, ""));

    }

    public void battleDisplay() {
        if(initiativeTracker.isEmpty() > 1) {
            initiativeTracker.battle();
        }
        else {
            System.out.println("No enemies entered.");
        }
    }
}
