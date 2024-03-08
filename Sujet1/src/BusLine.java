import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusLine {
    private final String name;
    private final List<BusStop> busStops;
    private final Map<String, Integer> segmentTimes;
    int departureTime;

    public BusLine(String name, int departureTime) {
        this.name = name;
        this.busStops = new ArrayList<>();
        this.departureTime = departureTime;
        this.segmentTimes = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addStop(BusStop stop) {
        busStops.add(stop);
    }

    public void addSegmentTime(BusStop fromStop, BusStop toStop, int time) {
        String segmentKey = fromStop.getName() + "-" + toStop.getName();
        segmentTimes.put(segmentKey, time);
    }

    public int getSegmentTime(BusStop fromStop, BusStop toStop) {
        String segmentKey = fromStop.getName() + "-" + toStop.getName();
        return segmentTimes.getOrDefault(segmentKey, -1);
    }

    public int getNumberOfSegments() {
        return busStops.size() - 1;
    }

    public int getTotalTime() {
        int totalTime = 0;
        for (int i = 0; i < busStops.size() - 1; i++) {
            BusStop fromStop = busStops.get(i);
            BusStop toStop = busStops.get(i + 1);
            int segmentTime = getSegmentTime(fromStop, toStop);
            totalTime += segmentTime;
        }
        return totalTime;
    }

    public int getArrivalTime() {
        return departureTime + getTotalTime();
    }

}
