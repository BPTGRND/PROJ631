import java.util.ArrayList;
import java.util.List;

public class BusStop {
    private static final List<BusStop> allBusStops = new ArrayList<>();
    private final String name;
    private final List<Edge> edges;

    public BusStop(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
        allBusStops.add(this);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public static List<BusStop> getAllBusStops() {
        return allBusStops;
    }
}
