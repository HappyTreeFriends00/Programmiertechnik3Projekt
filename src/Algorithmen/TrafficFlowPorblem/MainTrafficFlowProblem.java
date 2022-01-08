package Algorithmen.TrafficFlowPorblem;

import Algorithmen.RoadStops;
import Algorithmen.RoadSystem;

import java.util.ArrayList;
import java.util.Arrays;

public class MainTrafficFlowProblem {
    public static void main(String[] args) {
        RoadStops motorwayEntrance = new RoadStops("motorway entrance", true, false, 1);
        RoadStops firstTrafficLight = new RoadStops("first traffic light", false, false, 2);
        RoadStops secondTrafficLight = new RoadStops("second traffic light", false, false, 3);
        RoadStops thirdTrafficLight = new RoadStops("third traffic light", false, false, 4);
        RoadStops fourthTrafficLight = new RoadStops("fourth traffic light", false, false, 5);
        RoadStops parkingSpot = new RoadStops("parking spot", false, true, 6);

        ArrayList<RoadStops> roadStops = new ArrayList<>(Arrays.asList(motorwayEntrance, firstTrafficLight, secondTrafficLight, thirdTrafficLight, fourthTrafficLight, parkingSpot));
        RoadSystem roadSystem = new RoadSystem(roadStops);

        roadSystem.addWeightForEdgeInDirectedGraph(motorwayEntrance, firstTrafficLight, 14);
        roadSystem.addWeightForEdgeInDirectedGraph(motorwayEntrance, secondTrafficLight, 16);
        roadSystem.addWeightForEdgeInDirectedGraph(firstTrafficLight, fourthTrafficLight, 15);
        roadSystem.addWeightForEdgeInDirectedGraph(secondTrafficLight, firstTrafficLight, 6);
        roadSystem.addWeightForEdgeInDirectedGraph(secondTrafficLight, thirdTrafficLight, 15);
        roadSystem.addWeightForEdgeInDirectedGraph(thirdTrafficLight, parkingSpot, 17);
        roadSystem.addWeightForEdgeInDirectedGraph(fourthTrafficLight, secondTrafficLight, 4);
        roadSystem.addWeightForEdgeInDirectedGraph(fourthTrafficLight, thirdTrafficLight, 7);
        roadSystem.addWeightForEdgeInDirectedGraph(fourthTrafficLight, parkingSpot, 10);

        roadSystem.printGraphOut(roadSystem.vertexList, roadSystem.getStreets());
        TrafficFlowCalculator calculator = new TrafficFlowCalculator();
        roadSystem.printGraphOut(roadSystem.vertexList, calculator.calculateOptimalTrafficFlow(roadSystem));
    }
}
