public class Edge {
    private final BusStop source;
    private final BusStop destination;
    private final int weight;

    public Edge(BusStop source, BusStop destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        source.addEdge(this);
    }

    public BusStop getSource() {
        return source;
    }
    public BusStop getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}
