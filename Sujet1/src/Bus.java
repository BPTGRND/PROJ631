import java.util.*;

public class Bus {
    // CONSTRUCTOR
    public Bus() {}

    // METHODS
    // METHOD TO GET ALL PATHS BETWEEN TWO BUS STOPS
    public List<List<BusStopV2>> allPaths(BusStopV2 start, BusStopV2 end) {
        List<List<BusStopV2>> allPaths = new ArrayList<>();
        List<BusStopV2> currentPath = new ArrayList<>();
        currentPath.add(start);
        explorePaths(start, end, currentPath, allPaths);
        return allPaths;
    }
    private void explorePaths(BusStopV2 currentStop, BusStopV2 end, List<BusStopV2> currentPath, List<List<BusStopV2>> allPaths) {
        if (currentStop == end) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }

        for (Map.Entry<BusStopV2, Integer> entry : currentStop.getChildrenMap().entrySet()) {
            BusStopV2 nextStop = entry.getKey();
            if (!currentPath.contains(nextStop)) {
                currentPath.add(nextStop);
                explorePaths(nextStop, end, currentPath, allPaths);
                currentPath.removeLast();
            }
        }
    }

    // METHOD TO DISPLAY BUS STOP NAME IN A PATH
    public List<String> displayPath(List<BusStopV2> path) {
        List<String> names = new ArrayList<>();
        for (BusStopV2 busStop : path) {
            names.add(busStop.getName());
        }
        return names;
    }

    // METHOD RETURNS SHORTEST PATH
    public List<BusStopV2> shortest(BusStopV2 start, BusStopV2 end) {
        List<BusStopV2> shortestPath = new ArrayList<>();
        shortestPath.add(start);

        if (start == end) {
            return shortestPath;
        }

        List<BusStopV2> shortestPathFound = new ArrayList<>();
        int shortestDistance = Integer.MAX_VALUE;

        for (Map.Entry<BusStopV2, Integer> entry : start.getChildrenMap().entrySet()) {
            BusStopV2 nextStop = entry.getKey();

            if (!shortestPath.contains(nextStop)) {
                List<BusStopV2> path = shortest(nextStop, end);

                if (!path.isEmpty()) {
                    path.addFirst(start);
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

    // METHOD RETURNS FASTEST PATH
    public List<BusStopV2> fastest(BusStopV2 start, BusStopV2 end) {
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

        List<BusStopV2> path = new ArrayList<>();
        BusStopV2 current = end;

        while (current != null) {
            path.addFirst(current);
            current = predecessors.get(current);
        }

        return path;
    }

    // METHOD RETURNS FOREMOST PATH
    public List<BusStopV2> foremost(BusStopV2 start, BusStopV2 end) {
        Scanner scanner = new Scanner(System.in);
        List<List<BusStopV2>> allPaths = allPaths(start, end);
        List<BusStopV2> earliestArrivingBuses = new ArrayList<>();

        int earliestArrivalTime = Integer.MAX_VALUE;

        for (List<BusStopV2> path : allPaths) {
            System.out.print("Enter departure time for path " + displayPath(path) + ": ");
            int departureTime = scanner.nextInt();

            BusLineV2 busLine = new BusLineV2(path, departureTime, "");

            int totalTravelTime = busLine.getTotalTime();
            int arrivalTime = busLine.getDepartureTime() + totalTravelTime;

            if (arrivalTime < earliestArrivalTime) {
                earliestArrivalTime = arrivalTime;
                earliestArrivingBuses.clear();
                earliestArrivingBuses.addAll(path);
            }
        }
        scanner.close();
        return earliestArrivingBuses;
    }
}