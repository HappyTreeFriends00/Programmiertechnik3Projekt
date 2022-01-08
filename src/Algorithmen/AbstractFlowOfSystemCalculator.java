package Algorithmen;

import java.util.ArrayList;

public abstract class AbstractFlowOfSystemCalculator {

    public int[][] calculateFlowForSystem(AbstractGraph<? extends IObjectGetName> graph){
        boolean givesMoreExtendedWays = true;
        int[][] maxPossibleFlowInWaterSupplySystem = new int[graph.edge.length][graph.edge.length];
        int[][] restNetwork = new int[graph.edge.length][graph.edge.length];
        for (int j = 0; j < graph.edge.length; j++) {
            for (int i = 0; i < graph.edge.length; i++) {
                maxPossibleFlowInWaterSupplySystem[j][i] = 0;
                restNetwork[j][i] = graph.edge[j][i];
            }
        }
        //Von Source bis Trap der derzeitige Pfad
        ArrayList<IObjectGetName> currentPath = new ArrayList<>();
        IObjectGetName sourceNode = graph.getSource();
        IObjectGetName nextNode = sourceNode;
        int currentMaxFlow = 99999;
        boolean pathIsComplete = false;
        while (givesMoreExtendedWays){
            for (int i = 0; i < graph.edge.length; i++) {
                //falls Node eine gewichtete und gerichtete Kante hat
                if(restNetwork[graph.vertexList.indexOf(nextNode)] [i] != 0 && !graph.vertexList.get(i).isVisited()){
                    //und falls Node seine Kante kleiner ist als der derzeitige maximal fluss
                    if(restNetwork[graph.vertexList.indexOf(nextNode)] [i] < currentMaxFlow){
                        //currentMaxFlow wird aktualisiert der Node wird im derzeitigen Pfad gespeichert und der nächste Node wird genommen
                        currentMaxFlow = restNetwork[graph.vertexList.indexOf(nextNode)] [i];
                        currentPath.add(nextNode);
                        nextNode.setVisited(true);
                        nextNode = graph.vertexList.get(i);
                        pathIsComplete = false;
                        break;
                    }
                    //ansonsten das gleiche ohne den currentMaxFlow zu aktualisieren
                    else{
                        currentPath.add(nextNode);
                        nextNode.setVisited(true);
                        nextNode = graph.vertexList.get(i);
                        pathIsComplete = false;
                        break;
                    }
                }else if(!nextNode.isTrap()){
                    pathIsComplete = true;
                }
            }
            if(nextNode.isTrap()){
                currentPath.add(nextNode);
                graph.setEveryVisitedToNotVisited(graph.vertexList);
                for(IObjectGetName object: currentPath){
                    if(!object.isTrap()) {
                        restNetwork[graph.vertexList.indexOf(object)][graph.vertexList.indexOf(currentPath.get(currentPath.indexOf(object) + 1))] -= currentMaxFlow;
                        maxPossibleFlowInWaterSupplySystem[graph.vertexList.indexOf(object)][graph.vertexList.indexOf(currentPath.get(currentPath.indexOf(object) + 1))] += currentMaxFlow;
                    }
                }
                //reset von currentPath und currentMaxFlow für den nächsten Path
                currentPath.clear();
                currentMaxFlow = 99999;
                nextNode = sourceNode;
            }
            if(pathIsComplete) {
                currentPath.add(nextNode);
                graph.setEveryVisitedToNotVisited(graph.vertexList);
                restNetwork[graph.vertexList.indexOf(currentPath.get(currentPath.size() -2))][graph.vertexList.indexOf(currentPath.get(currentPath.size() -1))] = 0;
                restNetwork[graph.vertexList.indexOf(currentPath.get(currentPath.size() -1))][graph.vertexList.indexOf(currentPath.get(currentPath.size() -2))] = 0;
                //reset von nextNode, currentPath und currentMaxFlow für den nächsten Path
                currentPath.clear();
                currentMaxFlow = 99999;
                nextNode = sourceNode;
                pathIsComplete = false;
                for (int i = 0; i < restNetwork.length; i++) {
                    if (restNetwork[graph.vertexList.indexOf(sourceNode)][i] != 0) {
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

}

