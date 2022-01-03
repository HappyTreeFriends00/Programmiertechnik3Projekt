package Algorithmen;

import Algorithmen.AbstractGraph;

import java.util.ArrayList;

public class City extends AbstractGraph<House> {
    public ArrayList<House> allHousesOfTheCity = vertexList;
    public int[][] ways = edge;

    public City(ArrayList<House> houses){
        super(houses);
    }

    public void addWayBuildCostBetweenTwoHouses(House firstHouse, House secondHouse, int wayBuildCost){
        addWeightForEdgeInUndirectedGraph(firstHouse,secondHouse,wayBuildCost);
    }

    public int getWayBuildCostBetweenTwoHouses(House firstHouse, House secondHouse){
        return getWeightOfEdge(firstHouse, secondHouse);
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

    public ArrayList<House> getAllHousesOfCity() {
        return vertexList;
    }

    public int[][] getWays() {
        return ways;
    }

    public void addWeightForEdgeInUndirectedGraph(House objectOne, House objectTwo, int weight){
        edge[vertexList.indexOf(objectOne)] [vertexList.indexOf(objectTwo)] = weight;
        edge[vertexList.indexOf(objectTwo)] [vertexList.indexOf(objectOne)] = weight;
        objectOne.incrementDegree();
        objectTwo.incrementDegree();
    }
}
