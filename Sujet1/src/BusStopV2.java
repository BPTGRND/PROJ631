
import java.util.HashMap;
import java.util.Map;

public class BusStopV2 {
    // ATTRIBUTS
    private final String name;
    private final Map<BusStopV2, Integer> childrenMap;

    // CONSTRUCTOR
    public BusStopV2(String name) {
        this.name = name;
        this.childrenMap = new HashMap<>();
    }

    // GETTERS
    public String getName() {
        return name;
    }

    // METHODS
    public void addChild(BusStopV2 busStop, int travelTime) {
        childrenMap.put(busStop, travelTime);
    }

    public Map<BusStopV2, Integer> getChildrenMap() {
        return childrenMap;
    }
}
