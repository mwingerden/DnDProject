import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DamageTypes {
    private final String name;
    private final String note;
    private final String type;

    @JsonCreator
    private DamageTypes(@JsonProperty("name") String name, @JsonProperty("note") String note,
                        @JsonProperty("type") String type) {
        this.name = name;
        this.note = note;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    public String getType() {
        return type;
    }
}
