import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BusStop stop1 = new BusStop("Stop1");
        BusStop stop2 = new BusStop("Stop2");
        BusStop stop3 = new BusStop("Stop3");
        BusStop stop4 = new BusStop("Stop4");
        BusStop stop5 = new BusStop("Stop5");

        BusLine redLine = new BusLine("RedLine", 611);
        redLine.addStop(stop1);
        redLine.addStop(stop2);
        redLine.addStop(stop3);
        redLine.addStop(stop4);
        redLine.addSegmentTime(stop1, stop2, 10);
        redLine.addSegmentTime(stop2, stop3, 10);
        redLine.addSegmentTime(stop3, stop4, 10);

        BusLine greenLine = new BusLine("GreenLine", 605);
        greenLine.addStop(stop1);
        greenLine.addStop(stop4);
        greenLine.addSegmentTime(stop1, stop4, 50);

        BusLine blueLine = new BusLine("BlueLine", 600);
        blueLine.addStop(stop1);
        blueLine.addStop(stop5);
        blueLine.addStop(stop4);
        blueLine.addSegmentTime(stop1, stop5, 20);
        blueLine.addSegmentTime(stop5, stop4, 20);

        List<BusLine> busLines = new ArrayList<>();
        busLines.add(redLine);
        busLines.add(greenLine);
        busLines.add(blueLine);

        System.out.println("SHORTEST: " + findShortestLine(busLines).getName());
        System.out.println("FASTEST: " + findFastestLine(busLines).getName());
        System.out.println("FOREMOST: " + findForemostLine(busLines).getName());
    }

    public static BusLine findShortestLine(List<BusLine> lines) {
        BusLine SHORTEST = lines.getFirst();
        for (BusLine line : lines) {
            if (line.getNumberOfSegments() < SHORTEST.getNumberOfSegments()) {
                SHORTEST = line;
            }
        }
        return SHORTEST;
    }

    public static BusLine findFastestLine(List<BusLine> lines) {
        BusLine FASTEST = lines.getFirst();
        for (BusLine line : lines) {
            if (line.getTotalTime() < FASTEST.getTotalTime()) {
                FASTEST = line;
            }
        }
        return FASTEST;
    }

    public static BusLine findForemostLine(List<BusLine> lines) {
        BusLine FOREMOST = lines.getFirst();
        for (BusLine line : lines) {
            if (line.getArrivalTime() < FOREMOST.getArrivalTime()) {
                FOREMOST = line;
            }
        }
        return FOREMOST;
    }
}