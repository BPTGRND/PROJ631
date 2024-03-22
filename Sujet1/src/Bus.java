import java.util.*;

public class Bus {
    // CONSTRUCTOR
    public Bus() {}

    // METHODS
    public List<String> shortest(BusStopV2 start, BusStopV2 end) {
        List<String> shortestPath = new ArrayList<>();
        shortestPath.add(start.getName());

        if (start == end) {
            return shortestPath;
        }

        List<String> shortestPathFound = new ArrayList<>();
        int shortestDistance = Integer.MAX_VALUE;

        for (Map.Entry<BusStopV2, Integer> entry : start.getChildrenMap().entrySet()) {
            BusStopV2 nextStop = entry.getKey();

            if (!shortestPath.contains(nextStop.getName())) {
                List<String> path = shortest(nextStop, end);

                if (!path.isEmpty()) {
                    path.addFirst(start.getName());
                    int distance = path.size();

                    if (distance < shortestDistance) {
                        shortestDistance = distance;
                        shortestPathFound = path;
                    }
                }
            }
        }
        return shortestPathFound;
    }

    public List<String> fastest(BusStopV2 start, BusStopV2 end) {
        Map<BusStopV2, Integer> distances = new HashMap<>();
        Map<BusStopV2, BusStopV2> predecessors = new HashMap<>();
        PriorityQueue<BusStopV2> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        distances.put(start, 0);
        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
            BusStopV2 current = priorityQueue.poll();

            if (current == end) {
                break;
            }

            int currentDistance = distances.get(current);

            for (Map.Entry<BusStopV2, Integer> entry : current.getChildrenMap().entrySet()) {
                BusStopV2 nextStop = entry.getKey();
                int weight = entry.getValue();
                int totalDistance = currentDistance + weight;

                if (!distances.containsKey(nextStop) || totalDistance < distances.get(nextStop)) {
                    distances.put(nextStop, totalDistance);
                    predecessors.put(nextStop, current);
                    priorityQueue.add(nextStop);
                }
            }
        }

        List<String> path = new ArrayList<>();
        BusStopV2 current = end;

        while (current != null) {
            path.addFirst(current.getName());
            current = predecessors.get(current);
        }

        return path;
    }
}
