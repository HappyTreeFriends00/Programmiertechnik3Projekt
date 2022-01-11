package Algorithmen.TrafficFlowPorblem;

import Algorithmen.AbstractFlowOfSystemCalculator;
import Algorithmen.RoadSystem;
import Algorithmen.WaterSupplySystem;

public class TrafficFlowCalculator extends AbstractFlowOfSystemCalculator {

    public int[][] calculateOptimalTrafficFlow(RoadSystem roadSystem){
        return calculateFlowForSystem(roadSystem);
    }

    public int getMaxFlowRate(RoadSystem roadSystem){
        int maxFlowRate = 0;
        for (int i = 0; i < roadSystem.edge.length; i++) {
            maxFlowRate += calculateOptimalTrafficFlow(roadSystem)[roadSystem.vertexList.indexOf(roadSystem.getSource())][i];
        }
        return maxFlowRate;
    }
}
