import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DnDInitiativeTracker {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Character enemy1 = mapper.readValue(new File("./enemies/thug.json"), Enemy.class);
        InitiativeTracker tracker = new InitiativeTracker();
        tracker.addCharacter(enemy1, 5);
        System.out.println(tracker);
    }
}