import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DnDInitiativeTracker {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Character enemy1 = mapper.readValue(new File("./enemies/adult_black_dragon.json"),Enemy.class);
    }
}