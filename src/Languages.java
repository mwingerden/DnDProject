import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Languages {
    private final String name;
    private final boolean speaks;

    @JsonCreator
    private Languages(@JsonProperty("name") String name, @JsonProperty("speaks") boolean speaks) {
        this.name = name;
        this.speaks = speaks;
    }

    public String getName() {
        return name;
    }

    public boolean isSpeaks() {
        return speaks;
    }
}
