import java.util.ArrayList;
import java.util.Objects;

public class WaterSupplyMaxFlowCalculator {

    public int[][] calculateMaxFlowForWaterSupplySystem(WaterSupplySystem waterSupplySystem){
        boolean givesMoreExtendedWays = true;
        int[][] maxPossibleFlowInWaterSupplySystem = new int[waterSupplySystem.edge.length][waterSupplySystem.edge.length];
        int[][] restNetwork = new int[waterSupplySystem.edge.length][waterSupplySystem.edge.length];
        for (int j = 0; j < waterSupplySystem.edge.length; j++) {
            for (int i = 0; i < waterSupplySystem.edge.length; i++) {
                maxPossibleFlowInWaterSupplySystem[j][i] = 0;
                restNetwork[j][i] = waterSupplySystem.edge[j][i];
            }
        }
        //Von Source bis Trap der derzeitige Pfad
        ArrayList<House> currentPath = new ArrayList<>();
        House sourceNode = waterSupplySystem.getSource();
        House nextNode = sourceNode;
        int currentMaxFlow = 99999;
        boolean pathIsComplete = false;
        while (givesMoreExtendedWays){
            for (int i = 0; i < waterSupplySystem.edge.length; i++) {
                //falls Node eine gewichtete und gerichtete Kante hat
                if(restNetwork[waterSupplySystem.vertexList.indexOf(nextNode)] [i] != 0){
                    //und falls Node seine Kante kleiner ist als der derzeitige maximal fluss
                    if(restNetwork[waterSupplySystem.vertexList.indexOf(nextNode)] [i] < currentMaxFlow){
                        //currentMaxFlow wird aktualisiert der Node wird im derzeitigen Pfad gespeichert und der nächste Node wird genommen
                        currentMaxFlow = restNetwork[waterSupplySystem.vertexList.indexOf(nextNode)] [i];
                        currentPath.add(nextNode);
                        nextNode = waterSupplySystem.vertexList.get(i);
                        pathIsComplete = false;
                        break;
                    }
                    //ansonsten das gleiche ohne den currentMaxFlow zu aktualisieren
                    else{
                        currentPath.add(nextNode);
                        nextNode = waterSupplySystem.vertexList.get(i);
                        pathIsComplete = false;
                        break;
                    }
                }else if(!nextNode.isTrap()){
                    pathIsComplete = true;
                }
            }
            if(nextNode.isTrap()){
                currentPath.add(nextNode);
                for(House house: currentPath){
                    if(!house.isTrap()) {
                        restNetwork[waterSupplySystem.vertexList.indexOf(house)][waterSupplySystem.vertexList.indexOf(currentPath.get(currentPath.indexOf(house) + 1))] -= currentMaxFlow;
                        maxPossibleFlowInWaterSupplySystem[waterSupplySystem.vertexList.indexOf(house)][waterSupplySystem.vertexList.indexOf(currentPath.get(currentPath.indexOf(house) + 1))] += currentMaxFlow;
                    }
                }
                //reset von currentPath und currentMaxFlow für den nächsten Path
                currentPath.clear();
                currentMaxFlow = 99999;
                nextNode = sourceNode;
            }
            if(pathIsComplete) {
                currentPath.add(nextNode);
                restNetwork[waterSupplySystem.vertexList.indexOf(sourceNode)][waterSupplySystem.vertexList.indexOf(currentPath.get(1))] = 0;
                //reset von nextNode, currentPath und currentMaxFlow für den nächsten Path
                currentPath.clear();
                currentMaxFlow = 99999;
                nextNode = sourceNode;
                pathIsComplete = false;
                for (int i = 0; i < restNetwork.length; i++) {
                    if (restNetwork[waterSupplySystem.vertexList.indexOf(sourceNode)][i] != 0) {
                        givesMoreExtendedWays = true;
                        break;
                    } else {
                        givesMoreExtendedWays = false;
                    }
                }
            }
        }
        return maxPossibleFlowInWaterSupplySystem;
    }

    public int getMaxFlowRate(WaterSupplySystem waterSupplySystem){
        int maxFlowRate = 0;
        for (int i = 0; i < waterSupplySystem.edge.length; i++) {
            maxFlowRate += calculateMaxFlowForWaterSupplySystem(waterSupplySystem)[waterSupplySystem.vertexList.indexOf(waterSupplySystem.getSource())][i];
        }
        return maxFlowRate;
    }
}
