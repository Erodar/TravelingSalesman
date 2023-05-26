public class Node {
    String CityName;
    double xCoord;
    double yCoord;

    public Node(String cityName, double xCoord, double yCoord) {
        CityName = cityName;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    @Override
    public String toString() {
        return "Node{" +
                "CityName='" + CityName + '\'' +
                ", xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                '}';
    }
}
