package Algorithmen;

import java.util.ArrayList;

public class WaterSupplySystem extends AbstractGraph<House> implements IGetSource {
    private ArrayList<House> allHousesOfTheWaterSupplySystem = vertexList;

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

    public String getListOfAllHousesWithTheirSurnames(){
        StringBuilder stringBuilder = new StringBuilder();
        for (House house: allHousesOfTheWaterSupplySystem) {
            stringBuilder.append(house.getSurname());
            stringBuilder.append(": ");
            stringBuilder.append(house.getName()).append("\n");
        }
        return stringBuilder.toString();
    }

    public House getTrap(){
        for (House house:allHousesOfTheWaterSupplySystem) {
            if(house.isTrap()){
                return house;
            }
        }
        return null;
    }

    public House findHouseWithSurname(String name){
        for (House house:allHousesOfTheWaterSupplySystem) {
            if(house.getSurname().equals(name)){
                return house;
            }
        }
        throw new IllegalArgumentException("Stop existiert nicht");
    }
}
