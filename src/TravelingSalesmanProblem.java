import java.util.ArrayList;

public class TravelingSalesmanProblem {

    static ArrayList<Node> NodeList = new ArrayList<>();
    static ArrayList<Node> RouteList = new ArrayList<>();

    public static void CityAdder(String cityName, double xCoord, double yCoord) {
        Node city = new Node(cityName, xCoord, yCoord);
        NodeList.add(city);
    }

    /* Calculate the distance between two given nodes.
     * Uses Pythagoras to determine the shortest distance in a straight line.
     */
    public static double DistanceCalculator(Node City1, Node City2) {
        double xDist = Math.pow((City1.xCoord - City2.xCoord), 2);
        double yDist = Math.pow((City1.yCoord - City2.yCoord), 2);
        return (Math.sqrt(xDist + yDist));
    }

    /* Determines the optimal route for the salesman.
     * Starts at a random node and calculates distance from there.
     * However, it does not take the shortest route overall.
     * Only goes to the closest city every time.
     */

    public static ArrayList<Node> BestRouteFrom(int startNode) {
        RouteList.clear();
        RouteList.add(NodeList.get(startNode));

        int RouteListTracker = 0;
        double SmallestDistance = 1000;
        Node SmallestDistanceCity = null;
        double totaldistance = 0;

        for (int i = 0; i < NodeList.size(); i++) {
            if (RouteList.containsAll(NodeList)) {
                break;
            }
            if (!RouteList.contains(NodeList.get(i))) {
                double Temp = DistanceCalculator(RouteList.get(RouteListTracker), NodeList.get(i));
                if (Temp < SmallestDistance) {
                    SmallestDistance = Temp;
                    SmallestDistanceCity = NodeList.get(i);
                }
            }
            if (i == (NodeList.size() - 1)) {
                if (!RouteList.contains(SmallestDistanceCity)) {
                    RouteList.add(SmallestDistanceCity);
                }
                totaldistance += SmallestDistance;
                SmallestDistance = 1000;
                i = -1;
                RouteListTracker++;
                if (RouteListTracker == NodeList.size()) {
                    break;
                }
            }
        }
        System.out.println(totaldistance);
        return RouteList;
    }

    public static double RouteOrder(int startNode) {
//        Node RandomNode = NodeList.get(new Random().nextInt(NodeList.size()));
        RouteList.clear();
        RouteList.add(NodeList.get(startNode));


        int RouteListTracker = 0;
        double SmallestDistance = 1000;
        Node SmallestDistanceCity = null;
        double totaldistance = 0;

        for (int i = 0; i < NodeList.size(); i++) {
            if (RouteList.containsAll(NodeList)) {
                break;
            }
            if (!RouteList.contains(NodeList.get(i))) {
                double Temp = DistanceCalculator(RouteList.get(RouteListTracker), NodeList.get(i));
                if (Temp < SmallestDistance) {
                    SmallestDistance = Temp;
                    SmallestDistanceCity = NodeList.get(i);
                }
            }
            if (i == (NodeList.size() - 1)) {
                if (!RouteList.contains(SmallestDistanceCity)) {
                    RouteList.add(SmallestDistanceCity);
                }
                totaldistance += SmallestDistance;
                SmallestDistance = 1000;
                i = -1;
                RouteListTracker++;
                if (RouteListTracker == NodeList.size()) {
                    break;
                }
            }
        }
        return totaldistance;
    }

    public static ArrayList<Node> FindOptimalRoute() {
        ArrayList<Node> OptimalRoute = new ArrayList<>();
        double BestRouteDistance = 1000;
        for (int i2 = 0; i2 < NodeList.size(); i2++) {
            if (RouteOrder(i2) < BestRouteDistance) {
                BestRouteDistance = RouteOrder(i2);
                OptimalRoute.clear();
                OptimalRoute.addAll(RouteList);
            }
            if (i2 == NodeList.size() - 1) {
                System.out.println(BestRouteDistance);
                return OptimalRoute;
            }
        }
        return OptimalRoute;
    }
}

