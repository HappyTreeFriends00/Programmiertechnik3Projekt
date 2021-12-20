import java.util.ArrayList;

public class WaterSupplySystem extends AbstractGraph<House> {
    private ArrayList<House> allHousesOfTheWaterSupplySystem = vertexList;
    private int[][] directedWaterSupplyWays = edge;

    public WaterSupplySystem(ArrayList<House> houses) {
        super(houses);
    }

    public House getSource(){
        for (House house:allHousesOfTheWaterSupplySystem) {
            if(house.isSource()){
                return house;
            }
        }
        return null;
    }

    public House getTrap(){
        for (House house:allHousesOfTheWaterSupplySystem) {
            if(house.isTrap()){
                return house;
            }
        }
        return null;
    }

    public String getListOfAllHousesWithTheirSurnames(){
        StringBuilder stringBuilder = new StringBuilder();
        for (House house: allHousesOfTheWaterSupplySystem) {
            stringBuilder.append(house.getSurname());
            stringBuilder.append(": ");
            stringBuilder.append(house.getName() + "\n");
        }
        return stringBuilder.toString();
    }
}
