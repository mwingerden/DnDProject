import java.io.IOException;

public class DnDInitiativeTracker {
    public static void main(String[] args) throws IOException {
        UI ui = new UI();
        ui.userInput();
        ui.battleDisplay();
    }
}