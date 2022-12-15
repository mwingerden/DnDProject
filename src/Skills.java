import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Skills {
    private final String name;
    private final String stat;

    @JsonCreator
    private Skills(@JsonProperty("name") String name, @JsonProperty("stat") String stat) {
        this.name = name;
        this.stat = stat;
    }

    public String getName() {
        return name;
    }

    public String getStat() {
        return stat;
    }
}
