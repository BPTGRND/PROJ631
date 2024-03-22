import java.util.List;

public class BusLineV2 {
    // ATTRIBUTS
    private final List<String> path;
    private final int departureTime;

    // CONSTRUCTOR
    public BusLineV2(List<String> path, int departureTime) {
        this.path = path;
        this.departureTime = departureTime;
    }

    // GETTERS
    public List<String> getPath() {
        return path;
    }

    public int getDepartureTime() {
        return departureTime;
    }
}
