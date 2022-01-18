package Algorithmen.RoadConstructionProblem;

import Algorithmen.City;
import Algorithmen.House;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

class RoadConstructionCostCalculatorTest {

    @Test
    void calculateMinimalCostToBuildStreetsTest(){
        House house1 = new House(1);
        House house2 = new House(2);
        House house3 = new House(3);
        House house4 = new House(4);
        House house5 = new House(5);
        House house6 = new House(69);
        House house7 = new House(70);
        House house8 = new House(8);
        House house9 = new House(900);
        House house0 = new House(10);
        House[] houseArray = {house1, house2, house3, house4, house5, house6, house7, house8, house9, house0};
        ArrayList<House> houses = new ArrayList<>();
        Collections.addAll(houses, houseArray);


        City city = new City(houses);
        city.addWeightForEdgeInUndirectedGraph(house1, house3, 5);
        city.addWeightForEdgeInUndirectedGraph(house1, house4, 4);
        city.addWeightForEdgeInUndirectedGraph(house1, house2, 3);
        city.addWeightForEdgeInUndirectedGraph(house2, house3, 3);
        city.addWeightForEdgeInUndirectedGraph(house2, house6, 3);
        city.addWeightForEdgeInUndirectedGraph(house2, house4, 5);
        city.addWeightForEdgeInUndirectedGraph(house2, house5, 4);
        city.addWeightForEdgeInUndirectedGraph(house3, house6, 2);
        city.addWeightForEdgeInUndirectedGraph(house3, house7, 3);
        city.addWeightForEdgeInUndirectedGraph(house3, house8, 4);
        city.addWeightForEdgeInUndirectedGraph(house4, house0, 2);
        city.addWeightForEdgeInUndirectedGraph(house4, house5, 4);
        city.addWeightForEdgeInUndirectedGraph(house5, house0, 3);
        city.addWeightForEdgeInUndirectedGraph(house5, house9, 2);
        city.addWeightForEdgeInUndirectedGraph(house5, house6, 4);
        city.addWeightForEdgeInUndirectedGraph(house6, house8, 3);
        city.addWeightForEdgeInUndirectedGraph(house6, house9, 3);
        city.addWeightForEdgeInUndirectedGraph(house7, house8, 2);
        city.addWeightForEdgeInUndirectedGraph(house8, house9, 4);
        city.addWeightForEdgeInUndirectedGraph(house9, house0, 3);

        RoadConstructionCostCalculator calculator = new RoadConstructionCostCalculator();
        int[][] resultGraph = calculator.calculateMinimalCostToBuildStreets(city);
        city.printAllHousesWithWayBuildCostOut(resultGraph);

        int[][] controlGraph = {{0,3,0,0,0,0,0,0,0,0}, {3,0,3,0,0,0,0,0,0,0},{0,3,0,0,0,2,3,0,0,0},
                {0,0,0,0,0,0,0,0,0,2},{0,0,0,0,0,0,0,0,2,0},{0,0,2,0,0,0,0,0,3,0},{0,0,3,0,0,0,0,2,0,0},
                {0,0,0,0,0,0,2,0,0,0},{0,0,0,0,2,3,0,0,0,3},{0,0,0,2,0,0,0,0,3,0}};

        city.printAllHousesWithWayBuildCostOut(controlGraph);

        Assertions.assertArrayEquals(controlGraph,resultGraph);

    }

}