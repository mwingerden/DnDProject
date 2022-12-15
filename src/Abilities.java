import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Abilities {
    private final String name;
    private final String desc;

    @JsonCreator
    private Abilities(@JsonProperty("name") String name, @JsonProperty("desc") String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
