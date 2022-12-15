import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SThrows {
    private final String name;
    private final int order;

    @JsonCreator
    private SThrows(@JsonProperty("name") String name, @JsonProperty("order") int order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }
}
