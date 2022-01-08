package Algorithmen.WaterSupplyProblem;

import Algorithmen.AbstractFlowOfSystemCalculator;
import Algorithmen.House;
import Algorithmen.WaterSupplySystem;

import java.util.ArrayList;

public class WaterSupplyMaxFlowCalculator extends AbstractFlowOfSystemCalculator {

    public int[][] calculateMaxFlowForWaterSupplySystem(WaterSupplySystem waterSupplySystem){
        return calculateFlowForSystem(waterSupplySystem);
    }

    public int getMaxFlowRate(WaterSupplySystem waterSupplySystem){
        int maxFlowRate = 0;
        for (int i = 0; i < waterSupplySystem.edge.length; i++) {
            maxFlowRate += calculateMaxFlowForWaterSupplySystem(waterSupplySystem)[waterSupplySystem.vertexList.indexOf(waterSupplySystem.getSource())][i];
        }
        return maxFlowRate;
    }
}
