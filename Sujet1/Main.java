import java.util.*;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        BusStop busStop1 = new BusStop("BusStop1");
        BusStop busStop2 = new BusStop("BusStop2");
        BusStop busStop3 = new BusStop("BusStop3");
        BusStop busStop4 = new BusStop("BusStop4");
        BusStop busStop5 = new BusStop("BusStop5");

        Edge edge1 = new Edge(busStop1, busStop2, 10);
        Edge edge2 = new Edge(busStop2, busStop3, 10);
        Edge edge3 = new Edge(busStop3, busStop4, 10);
        Edge edge4 = new Edge(busStop1, busStop4, 50);
        Edge edge5 = new Edge(busStop1, busStop5, 20);
        Edge edge6 = new Edge(busStop5, busStop4, 20);

        Main main = new Main();
        System.out.println(STR."Shortest: \{main.displayPath(main.shortest(busStop1, busStop4))}");
        System.out.println(STR."Fastest: \{main.displayPath(main.fastest(busStop1, busStop4))}");
        System.out.println(STR."Foremost: \{main.displayPath(main.foremost(busStop1, busStop4))}");
        System.out.println("\n");



        Ligne ligne = new Ligne("C:/Users/bapti/Desktop/PROJ631/Sujet1/2_Piscine-Patinoire_Campus.txt");
        String regularPath = ligne.regular_path();
        Map<String, List<String>> regularSchedule = ligne.regular_date_go();
        List<BusStop> busStops = new ArrayList<>();
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
            BusStop busStop = new BusStop(busStopName);
            busStops.add(busStop);
        }
        System.out.println(main.displayPath(busStops));
        for (List<String> sortedSchedule : sortedSchedules) {
            System.out.println(sortedSchedule);
        }
    }

    // METHODS THAT TRANSFORMS A BUSSTOP LIST TO STRING LIST
    public List<String> displayPath(List<BusStop> path) {
        List<String> displayPath = new ArrayList<>();
        for (BusStop busStop : path) {
            displayPath.add(busStop.getName());
        }
        return displayPath;
    }

    // METHOD RETURNS ALL POSSIBLE PATHS
    public List<List<BusStop>> allPaths(BusStop start, BusStop end) {
        List<List<BusStop>> allPaths = new ArrayList<>();
        List<BusStop> currentPath = new ArrayList<>();
        Set<BusStop> visited = new HashSet<>();
        dfs(start, end, visited, currentPath, allPaths);
        return allPaths;
    }
    // METHOD WITH RECURSIVE DEEP SEARCH (DFS) APPROACH
    private void dfs(BusStop current, BusStop end, Set<BusStop> visited, List<BusStop> currentPath, List<List<BusStop>> allPaths) {
        visited.add(current);
        currentPath.add(current);

        if (current == end) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            for (Edge edge : current.getEdges()) {
                BusStop neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    dfs(neighbor, end, visited, currentPath, allPaths);
                }
            }
        }

        visited.remove(current);
        currentPath.removeLast();
    }

    // METHOD RETURNS THE SHORTEST PATH
    public List<BusStop> shortest(BusStop start, BusStop end) {
        Map<BusStop, BusStop> previous = new HashMap<>();
        Queue<BusStop> queue = new LinkedList<>();
        Set<BusStop> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            BusStop current = queue.poll();
            if (current == end) {
                break;
            }
            for (Edge edge : current.getEdges()) {
                BusStop neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    previous.put(neighbor, current);
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        List<BusStop> shortestPath = new ArrayList<>();
        BusStop current = end;
        while (previous.containsKey(current)) {
            shortestPath.add(current);
            current = previous.get(current);
        }
        shortestPath.add(start);
        Collections.reverse(shortestPath);
        return shortestPath;
    }

    // METHOD THAT RETURNS THE FASTEST PATH
    public List<BusStop> fastest(BusStop start, BusStop end) {
        Map<BusStop, Integer> distance = new HashMap<>();
        Map<BusStop, BusStop> previous = new HashMap<>();
        PriorityQueue<BusStop> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        for (BusStop busStop : BusStop.getAllBusStops()) {
            if (busStop == start) {
                distance.put(busStop, 0);
            } else {
                distance.put(busStop, Integer.MAX_VALUE);
            }
            queue.add(busStop);
        }

        while (!queue.isEmpty()) {
            BusStop current = queue.poll();
            if (current == end) {
                break;
            }
            for (Edge edge : current.getEdges()) {
                BusStop neighbor = edge.getDestination();
                int newDistance = distance.get(current) + edge.getWeight();
                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        List<BusStop> shortestPath = new ArrayList<>();
        BusStop current = end;
        while (previous.containsKey(current)) {
            shortestPath.add(current);
            current = previous.get(current);
        }
        shortestPath.add(start);
        Collections.reverse(shortestPath);
        return shortestPath;
    }

    // METHOD RETURNS THE FOREMOST PATH
    public List<BusStop> foremost(BusStop start, BusStop end) {
        List<List<BusStop>> allPaths = allPaths(start, end);

        List<BusStop> earliestArrivingBuses = new ArrayList<>();
        int earliestArrivalTime = Integer.MAX_VALUE;

        for (List<BusStop> path : allPaths) {
            int departureTime = getDepartureTimeForPath(path);
            int totalTravelTime = getTotalTravelTimeForPath(path);
            int arrivalTime = departureTime + totalTravelTime;

            if (arrivalTime < earliestArrivalTime) {
                earliestArrivalTime = arrivalTime;
                earliestArrivingBuses = new ArrayList<>(path);
            }
        }

        return earliestArrivingBuses;
    }
    private int getDepartureTimeForPath(List<BusStop> path) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(STR."Entrez l'heure de départ pour le chemin \{displayPath(path)}: ");
        return scanner.nextInt();
    }
    private int getTotalTravelTimeForPath(List<BusStop> path) {
        int totalTravelTime = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            BusStop currentStop = path.get(i);
            for (Edge edge : currentStop.getEdges()) {
                if (edge.getDestination() == path.get(i + 1)) {
                    totalTravelTime += edge.getWeight();
                    break;
                }
            }
        }
        return totalTravelTime;
    }
}
