import java.util.ArrayList;
import java.util.Objects;

public class WaterSupplyMaxFlowCalculator {

    public int[][] calculateMaxFlowForWaterSupplySystem(WaterSupplySystem waterSupplySystem){
        boolean givesMoreExtendedWays = true;
        int[][] maxPossibleFlowInWaterSupplySystem = new int[waterSupplySystem.edge.length][waterSupplySystem.edge.length];
        int[][] restNetwork = new int[waterSupplySystem.edge.length][waterSupplySystem.edge.length];
        for (int j = 0; j < waterSupplySystem.edge.length; j++) {
            for (int i = 0; i < waterSupplySystem.edge.length; i++) {
                restNetwork[j][i] = waterSupplySystem.edge[j][i];
            }
        }
        //Von Source bis Trap der derzeitige Pfad
        ArrayList<House> currentPath = new ArrayList<>();
        House sourceNode = waterSupplySystem.getSource();
        House trapNode = waterSupplySystem.getTrap();
        House nextNode = sourceNode;
        int currentMaxFlow = 99999;
        while (givesMoreExtendedWays){
            for (int i = 0; i < waterSupplySystem.edge.length; i++) {
                if(Objects.equals(nextNode,trapNode)){
                    for(House house: currentPath){
                        if(currentPath.get(waterSupplySystem.vertexList.indexOf(house) + 1) != null) {
                            restNetwork[waterSupplySystem.vertexList.indexOf(house)][waterSupplySystem.vertexList.indexOf(house) + 1] = currentMaxFlow;
                        }
                    }
                    //reset von currentPath und currentMaxFlow für den nächsten Path
                    currentPath.clear();
                    currentMaxFlow = 99999;
                }
                //falls Node eine gewichtete und gerichtete Kante hat
                if(restNetwork[waterSupplySystem.vertexList.indexOf(nextNode)] [i] != 0){
                    //und falls Node seine Kante kleiner ist als der derzeitige maximal fluss
                    if(restNetwork[waterSupplySystem.vertexList.indexOf(nextNode)] [i] < currentMaxFlow){
                        //currentMaxFlow wird aktualisiert der Node wird im derzeitigen Pfad gespeichert und der nächste Node wird genommen
                        currentMaxFlow = waterSupplySystem.edge[waterSupplySystem.vertexList.indexOf(nextNode)] [i];
                        currentPath.add(nextNode);
                        nextNode = waterSupplySystem.vertexList.get(i);
                        break;
                    }
                    //ansonsten das gleiche ohne den currentMaxFlow zu aktualisieren
                    else{
                        currentPath.add(nextNode);
                        nextNode = waterSupplySystem.vertexList.get(i);
                        break;
                    }
                }
                if(i + 1 == waterSupplySystem.edge.length){
                    givesMoreExtendedWays = false;
                }
            }
        }

        return restNetwork;
    }

}
