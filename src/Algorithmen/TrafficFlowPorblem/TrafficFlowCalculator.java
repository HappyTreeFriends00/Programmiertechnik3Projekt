package Algorithmen.TrafficFlowPorblem;

import Algorithmen.AbstractFlowOfSystemCalculator;
import Algorithmen.RoadSystem;

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

    public int[][] getGraphWithMaxFlow(RoadSystem roadSystem){
        int[][] resultGraph = calculateOptimalTrafficFlow(roadSystem);

        for (int i = 0; i < resultGraph.length; i++) {
            for (int j = 0; j < resultGraph.length; j++) {
                if(roadSystem.edge[i][j] == 0){
                   resultGraph[i][j] = 0;
                }
            }
        }
        return resultGraph;
    }
}
