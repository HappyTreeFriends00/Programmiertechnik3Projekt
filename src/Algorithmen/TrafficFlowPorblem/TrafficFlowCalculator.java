package Algorithmen.TrafficFlowPorblem;

import Algorithmen.AbstractFlowOfSystemCalculator;
import Algorithmen.RoadSystem;

public class TrafficFlowCalculator extends AbstractFlowOfSystemCalculator {

    public int[][] calculateOptimalTrafficFlow(RoadSystem roadSystem){
        return calculateFlowForSystem(roadSystem);
    }
}
