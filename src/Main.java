import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TravelingSalesmanProblem.CityAdder("leeuwarden", 53.201390, 5.808590);
        TravelingSalesmanProblem.CityAdder("utrecht", 52.090830, 5.122220);
        TravelingSalesmanProblem.CityAdder("groningen", 53.219170, 6.566670);
        TravelingSalesmanProblem.CityAdder("arnhem", 51.980000, 5.911110);
        TravelingSalesmanProblem.CityAdder("maastricht", 50.848330, 5.688890);
        TravelingSalesmanProblem.CityAdder("assen", 52.996670, 6.562500);
        TravelingSalesmanProblem.CityAdder("lelystad", 52.508330, 5.475000);
        TravelingSalesmanProblem.CityAdder("amsterdam", 52.374030, 4.889690);
        TravelingSalesmanProblem.CityAdder("den haag", 52.076670, 4.298610);
        TravelingSalesmanProblem.CityAdder("middelburg", 51.500000, 3.613890);
        TravelingSalesmanProblem.CityAdder("'s hertogenbos", 51.699170, 5.304170);

        ArrayList<Node> OptimalRoute = TravelingSalesmanProblem.FindOptimalRoute();
        System.out.println("Shortest total distance: " + TravelingSalesmanProblem.BestTotalDistance);
        System.out.println("Optimal route: ");
        for (Node node : OptimalRoute) {
//            System.out.println(node.CityName + " (" + node.xCoord + " , " + node.yCoord + ")");
            System.out.print(node.CityName + " ");
        }
        System.out.println();
        System.out.println("Best route from " + TravelingSalesmanProblem.NodeList.get(0).CityName + ": ");
        ArrayList<Node> RouteFrom = TravelingSalesmanProblem.BestRouteFrom(0);
        for (Node node : RouteFrom) {
            System.out.print(node.CityName + ", ");
        }
    }
}
