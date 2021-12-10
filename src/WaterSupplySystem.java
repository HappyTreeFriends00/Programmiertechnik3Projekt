import java.util.ArrayList;

public class WaterSupplySystem extends AbstractGraph<House> {
    private ArrayList<House> allHousesOfTheWaterSupplySystem = vertexList;
    private int[][] directedWaterSupplyWays = edge;

    public WaterSupplySystem(ArrayList<House> houses) {
        super(houses);
    }
}
