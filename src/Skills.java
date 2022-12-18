import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Skills {
    private final String name;
    private final String stat;
    private final String note;

    @JsonCreator
    private Skills(@JsonProperty("name") String name, @JsonProperty("stat") String stat,
                   @JsonProperty("note") String note) {
        this.name = name;
        this.stat = stat;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public String getStat() {
        return stat;
    }

    public String getNote() {
        return note;
    }
}
