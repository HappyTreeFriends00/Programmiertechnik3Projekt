import java.util.ArrayList;

public class City extends AbstractGraph{
    private ArrayList<House> allHousesOfTheCity = vertexList;
    private int[][] ways = edge;

    public City(ArrayList<House> houses){
        super(houses);
    }

    public void addWayBuildCostBetweenTwoHouses(House firstHouse, House secondHouse, int wayBuildCost){
        addWeightForEdge(firstHouse,secondHouse,wayBuildCost);
    }

    public int getWayBuildCostBetweenTwoHouses(House firstHouse, House secondHouse){
        return getWeightOfEdge(firstHouse, secondHouse);
    }

    public void printAllHousesWithWayBuildCostOut(){
        printGraphOut(allHousesOfTheCity, edge);
    }

    public void printAllHousesWithWayBuildCostOut(int[][] graph){
        printGraphOut(allHousesOfTheCity, graph);
    }

    public House getHouseWithHouseNumber(int houseNumber){
        House searchedHouse = null;
        for (House house: allHousesOfTheCity) {
            if(house.getHouseNumber() == houseNumber){
                searchedHouse = house;
            }
        }
        return searchedHouse;
    }

    public ArrayList<House> getAllHousesOfTheCity() {
        return allHousesOfTheCity;
    }

    public int[][] getWays() {
        return ways;
    }
}
