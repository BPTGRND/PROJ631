import java.util.*;

public class MainV2 {
    public static void main(String[] args) {
        BusStopV2 busStop1 = new BusStopV2("BusStop1");
        BusStopV2 busStop2 = new BusStopV2("BusStop2");
        BusStopV2 busStop3 = new BusStopV2("BusStop3");
        BusStopV2 busStop4 = new BusStopV2("BusStop4");
        BusStopV2 busStop5 = new BusStopV2("BusStop5");

        busStop1.addChild(busStop2, 10);
        busStop1.addChild(busStop4, 50);
        busStop1.addChild(busStop5, 20);
        busStop2.addChild(busStop3, 10);
        busStop3.addChild(busStop4, 10);
        busStop5.addChild(busStop4, 20);

        Bus bus = new Bus();

        for (List<BusStopV2> busLine : bus.allPaths(busStop1, busStop4)) {
            System.out.println(bus.displayPath(busLine));
        }

        //System.out.println("Shortest: " + bus.displayPath(bus.shortest(busStop1, busStop4)) + "\n");
        //System.out.println("Fastest: " + bus.displayPath(bus.fastest(busStop1, busStop4)) + "\n");
        //System.out.println("Foremost: " + bus.displayPath(bus.foremost(busStop1, busStop4)) + "\n");



        Ligne ligne = new Ligne("C:/Users/bapti/OneDrive/École/Polytech/EPU-3-S6/PROJ631/PROJ631/Sujet1/src/1_Poisy-ParcDesGlaisins.txt");
        System.out.println(ligne.regular_path());
        //System.out.println(ligne.regular_date_go());

        String regularPath = ligne.regular_path();
        Map<String, List<String>> regularSchedule = ligne.regular_date_go();

        List<BusStopV2> busStops = new ArrayList<>();

        String[] stops = regularPath.split(" N | \\+ ");

        List<List<String>> sortedSchedules = new ArrayList<>();
        int numberOfIndexes = regularSchedule.get(stops[0]).size();

        for (int i = 0; i < numberOfIndexes; i++) {
            sortedSchedules.add(new ArrayList<>());
        }

        for (String stop : stops) {
            List<String> stopSchedule = regularSchedule.get(stop);
            for (int i = 0; i < numberOfIndexes; i++) {
                sortedSchedules.get(i).add(stopSchedule.get(i));
            }
        }

        for (String busStopName : sortedSchedules.getFirst()) {
            BusStopV2 busStop = new BusStopV2(busStopName);
            busStops.add(busStop);
        }

        //System.out.println("\n");
        //System.out.println(bus.displayPath(busStops));
        //System.out.println(sortedSchedules.get(1));
        //System.out.println(sortedSchedules.get(2));

        List<BusStopV2> busPath = new ArrayList<>();
        for (int i = 1; i < sortedSchedules.get(1).size()-1; i++) {
            if (Objects.equals(sortedSchedules.get(1).get(i), "-")) {

            } else {
                busStops.get(i).addChild(busStops.get(i+1), (convertTimeStringToMinutes(sortedSchedules.get(1).get(i+1)) - convertTimeStringToMinutes(sortedSchedules.get(1).get(i))));
                busPath.add(busStops.get(i));
            }
        }

        for (int i = 1; i < sortedSchedules.get(2).size()-1; i++) {
            if (Objects.equals(sortedSchedules.get(2).get(i), "-")) {

            } else {
                busStops.get(i).addChild(busStops.get(i+1), (convertTimeStringToMinutes(sortedSchedules.get(2).get(i+1)) - convertTimeStringToMinutes(sortedSchedules.get(2).get(i))));
            }
        }

        //System.out.println("\n");
        //System.out.println("Fastest: " + bus.displayPath(bus.fastest(busStops.get(1), busStops.getLast())) + "\n");
    }

    public static int convertTimeStringToMinutes(String timeString) {
        String[] parts = timeString.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
