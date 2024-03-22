import java.util.ArrayList;
import java.util.List;

public class MainV2 {
    public static void main(String[] args) {
        BusStopV2 stop1 = new BusStopV2("BusStop1");
        BusStopV2 stop2 = new BusStopV2("BusStop2");
        BusStopV2 stop3 = new BusStopV2("BusStop3");
        BusStopV2 stop4 = new BusStopV2("BusStop4");
        BusStopV2 stop5 = new BusStopV2("BusStop5");

        stop1.addChild(stop2, 10);
        stop1.addChild(stop4, 50);
        stop1.addChild(stop5, 20);
        stop2.addChild(stop3, 10);
        stop3.addChild(stop4, 10);
        stop5.addChild(stop4, 20);

        Bus bus = new Bus();

        List<List<String>> allPaths = bus.allPaths(stop1, stop4);
        BusLineV2 line1 = new BusLineV2(allPaths.getFirst(), 611);
        BusLineV2 line2 = new BusLineV2(allPaths.get(1), 605);
        BusLineV2 line3 = new BusLineV2(allPaths.getLast(), 600);
        List<BusLineV2> busLines = new ArrayList<>();
        busLines.add(line1);
        busLines.add(line2);
        busLines.add(line3);

        System.out.println("Shortest: " + bus.shortest(stop1, stop4));
        System.out.println("Fastest: " + bus.fastest(stop1, stop4));
        System.out.println("Foremost: " + bus.foremost(stop1, stop4, busLines));
    }
}
