import java.io.IOException;

public class UI {
    private final InitiativeTracker initiativeTracker;

    public UI() {
        this.initiativeTracker = new InitiativeTracker();
    }

    void add() throws IOException {
        initiativeTracker.addEnemy();
        initiativeTracker.addAlley();
        initiativeTracker.addPlayer();
    }

    void battleDisplay() throws IOException {
        if(initiativeTracker.isEmpty() > 0) {
            initiativeTracker.battle();
        }
        else {
            System.out.println("No enemies entered.");
        }
    }
}
