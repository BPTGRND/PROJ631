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

        System.out.println("Shortest: " + bus.shortest(stop1, stop4));
        System.out.println("Fastest: " + bus.fastest(stop1, stop4));
    }
}
