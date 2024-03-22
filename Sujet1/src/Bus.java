import java.util.*;

public class Bus {
    // CONSTRUCTOR
    public Bus() {}

    // METHODS

    // METHODS FOR GET ALL PATHS BETWEEN TWO STOPS
    public List<List<String>> allPaths(BusStopV2 start, BusStopV2 end) {
        List<List<String>> allPaths = new ArrayList<>();
        List<String> currentPath = new ArrayList<>();
        currentPath.add(start.getName());
        explorePaths(start, end, currentPath, allPaths);
        return allPaths;
    }
    private void explorePaths(BusStopV2 currentStop, BusStopV2 end, List<String> currentPath, List<List<String>> allPaths) {
        if (currentStop == end) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }

        for (Map.Entry<BusStopV2, Integer> entry : currentStop.getChildrenMap().entrySet()) {
            BusStopV2 nextStop = entry.getKey();
            if (!currentPath.contains(nextStop.getName())) {
                currentPath.add(nextStop.getName());
                explorePaths(nextStop, end, currentPath, allPaths);
                currentPath.removeLast();
            }
        }
    }



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

    public List<String> foremost(BusStopV2 start, BusStopV2 end, List<BusLineV2> busLines) {
        return null;
    }
}
