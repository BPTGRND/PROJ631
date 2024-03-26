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

        System.out.println("Shortest: " + bus.displayPath(bus.shortest(busStop1, busStop4)) + "\n");
        System.out.println("Fastest: " + bus.displayPath(bus.fastest(busStop1, busStop4)) + "\n");
        System.out.println("Foremost: " + bus.displayPath(bus.foremost(busStop1, busStop4)) + "\n");
    }
}
