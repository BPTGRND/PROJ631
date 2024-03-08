import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusLine {
    private final String name;
    private final Map<List<BusStop>, Integer> segmentTimes;
    int departureTime;

    public BusLine(String name, int departureTime) {
        this.name = name;
        this.departureTime = departureTime;
        this.segmentTimes = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addSegmentTime(BusStop fromStop, BusStop toStop, int time) {
        List<BusStop> segmentKey = new ArrayList<>();
        segmentKey.add(fromStop);
        segmentKey.add(toStop);
        segmentTimes.put(segmentKey, time);
    }

    public int getNumberOfSegments() {
        return segmentTimes.size();
    }

    public int getTotalTime() {
        int totalTime = 0;
        for (int time : segmentTimes.values()) {
            totalTime += time;
        }
        return totalTime;
    }

    public int getArrivalTime() {
        return departureTime + getTotalTime();
    }
}
