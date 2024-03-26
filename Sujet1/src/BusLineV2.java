import java.util.List;

public class BusLineV2 {
    // ATTRIBUTS
    private final List<BusStopV2> path;
    private final int departureTime;
    private final String name;

    // CONSTRUCTOR
    public BusLineV2(List<BusStopV2> path, int departureTime, String name) {
        this.name = name;
        this.path = path;
        this.departureTime = departureTime;
    }

    // GETTERS
    public int getDepartureTime() {
        return departureTime;
    }

    public int getTotalTime() {
        int totalTravelTime = 0;

        for (int i = 0; i < path.size() - 1; i++) {
            BusStopV2 currentStop = path.get(i);
            BusStopV2 nextStop = path.get(i + 1);

            int travelTime = currentStop.getChildrenMap().get(nextStop);

            totalTravelTime += travelTime;
        }
        return totalTravelTime;
    }
}