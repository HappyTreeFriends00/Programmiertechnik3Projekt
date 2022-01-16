package Algorithmen.InvitationsDistributingProblem;

import Algorithmen.City;
import Algorithmen.House;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class InvitationsDistributingRouteCalculatorTest {

    @Test
    void eulerTour(){
        House house1 = new House(1);
        House house2 = new House(2);
        House house3 = new House(3);
        House house4 = new House(4);
        House house5 = new House(5);
        House house6 = new House(6);

        House[] houseArray = {house1, house2, house3, house4, house5,house6};
        ArrayList<House> houses = new ArrayList<>();
        for (int i = 0; i < houseArray.length; i++) {
            houses.add(houseArray[i]);
        }
        City city = new City(houses);
        city.addWeightForEdgeInUndirectedGraph(house1,house5,1);
        city.addWeightForEdgeInUndirectedGraph(house1,house4,1);
        city.addWeightForEdgeInUndirectedGraph(house1,house2,1);
        city.addWeightForEdgeInUndirectedGraph(house5,house4,1);
        city.addWeightForEdgeInUndirectedGraph(house5,house2,1);
        city.addWeightForEdgeInUndirectedGraph(house4,house2,1);
        city.addWeightForEdgeInUndirectedGraph(house4,house3,1);
        city.addWeightForEdgeInUndirectedGraph(house2,house3,1);
        city.addWeightForEdgeInUndirectedGraph(house1,house6,1);
        city.addWeightForEdgeInUndirectedGraph(house5,house6,1);

        InvitationsDistributingRouteCalculator calculator = new InvitationsDistributingRouteCalculator();
        Iterable<House> resultList = calculator.calculateEulerwayOrEulertour(city);
        House[] controlArray = {house1, house5, house2, house4, house5,house6,house1, house2, house3, house4,house1};
        Iterable<House> controlList = new ArrayList<>(Arrays.asList(controlArray));

        Assertions.assertIterableEquals(controlList, resultList);
    }

    @Test
    void eulerWeg(){
        House house1 = new House(1);
        House house2 = new House(2);
        House house3 = new House(3);
        House house4 = new House(4);
        House house5 = new House(5);

        House[] houseArray = {house1, house2, house3, house4, house5};
        ArrayList<House> houses = new ArrayList<>();
        for (int i = 0; i < houseArray.length; i++) {
            houses.add(houseArray[i]);
        }
        City city = new City(houses);
        city.addWeightForEdgeInUndirectedGraph(house1,house5,1);
        city.addWeightForEdgeInUndirectedGraph(house1,house4,1);
        city.addWeightForEdgeInUndirectedGraph(house1,house2,1);
        city.addWeightForEdgeInUndirectedGraph(house5,house4,1);
        city.addWeightForEdgeInUndirectedGraph(house5,house2,1);
        city.addWeightForEdgeInUndirectedGraph(house4,house2,1);
        city.addWeightForEdgeInUndirectedGraph(house4,house3,1);
        city.addWeightForEdgeInUndirectedGraph(house2,house3,1);

        InvitationsDistributingRouteCalculator calculator = new InvitationsDistributingRouteCalculator();
        Iterable<House> resultList = calculator.calculateEulerwayOrEulertour(city);
        House[] controlArray = {house1, house2, house3, house4, house1,house5, house2, house4, house5};
        Iterable<House> controlList = new ArrayList<>(Arrays.asList(controlArray));

        Assertions.assertIterableEquals(controlList, resultList);
    }

   /* @Test
    void makeGraphToAnPossibleEulergraphTest(){
        House house1 = new House(1);
        House house2 = new House(2);
        House house3 = new House(3);
        House house4 = new House(4);
        House house5 = new House(5);
        House house6 = new House(6);
        House house7 = new House(7);
        House house8 = new House(8);
        House house9 = new House(9);
        House house10 = new House(10);

        ArrayList<House> arrayList = new ArrayList<>(Arrays.asList(house1,house2,house3,house4,house5, house6, house7, house8, house9, house10));

        City city = new City(arrayList);

        city.addWeightForEdgeInUndirectedGraph(house1, house2,3);
        city.addWeightForEdgeInUndirectedGraph(house2, house3,3);
        city.addWeightForEdgeInUndirectedGraph(house3, house7,3);
        city.addWeightForEdgeInUndirectedGraph(house7, house8,2);
        city.addWeightForEdgeInUndirectedGraph(house3, house6,2);
        city.addWeightForEdgeInUndirectedGraph(house6, house9,3);
        city.addWeightForEdgeInUndirectedGraph(house9, house5,2);
        city.addWeightForEdgeInUndirectedGraph(house9, house10,3);
        city.addWeightForEdgeInUndirectedGraph(house10, house4,2);

        InvitationsDistributingRouteCalculator calculator = new InvitationsDistributingRouteCalculator();
        City solutionCity = calculator.makeGraphToAnPossibleEulergraph(city);
        city.printGraphOut(solutionCity.vertexList, solutionCity.edge);
        //calculator.calculateEulerwayOrEulertour();




    }*/

}