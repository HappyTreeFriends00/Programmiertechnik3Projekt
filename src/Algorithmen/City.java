package Algorithmen;

import java.util.ArrayList;

public class City extends AbstractGraph<House> {
    public ArrayList<House> allHousesOfTheCity = vertexList;
    public int[][] ways = edge;

    public City(ArrayList<House> houses){
        super(houses);
    }

    public void printAllHousesWithWayBuildCostOut(int[][] graph){
        printGraphOut(allHousesOfTheCity, graph);
    }

    public House findHouseWithHouseNumber(int houseNumber){
        for (House house: vertexList) {
            if(house.getHouseNumber() == houseNumber){
                return house;
            }
        }
        throw new IllegalArgumentException("Es scheint kein haus mit dieser hausnummer zu existieren");
    }

    public ArrayList<House> getAllHousesOfCity() {
        return vertexList;
    }

    public int[][] getWays() {
        return ways;
    }

    @Override
    public void addWeightForEdgeInUndirectedGraph(House objectOne, House objectTwo, int weight){
        edge[vertexList.indexOf(objectOne)] [vertexList.indexOf(objectTwo)] = weight;
        edge[vertexList.indexOf(objectTwo)] [vertexList.indexOf(objectOne)] = weight;
        objectOne.incrementDegree();
        objectTwo.incrementDegree();
    }

    public void addWeightForEdgeInUndirectedGraphAndOnlyOfObjectOneWillIncrementDegree(House objectOne, House objectTwo, int weight){
        edge[vertexList.indexOf(objectOne)] [vertexList.indexOf(objectTwo)] = weight;
        edge[vertexList.indexOf(objectTwo)] [vertexList.indexOf(objectOne)] = weight;
        objectOne.incrementDegree();
    }

    public House getSource(){
        for (House house:allHousesOfTheCity) {
            if(house.isSource()){
                return house;
            }
        }
        return null;
    }

    public House getTrap(){
        for (House house:allHousesOfTheCity) {
            if(house.isTrap()){
                return house;
            }
        }
        return null;
    }

    public House findHouseWithSurname(String name){
        for (House house:allHousesOfTheCity) {
            if(house.getSurname().equals(name)){
                return house;
            }
        }
        throw new IllegalArgumentException("Stop existiert nicht");
    }
}
