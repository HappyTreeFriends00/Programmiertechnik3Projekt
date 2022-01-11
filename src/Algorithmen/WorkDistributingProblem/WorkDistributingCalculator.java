package Algorithmen.WorkDistributingProblem;

import Algorithmen.AbstractFlowOfSystemCalculator;
import Algorithmen.IObjectGetName;
import Algorithmen.WorkDistributingList;
import Algorithmen.WorkerOrWork;

import java.util.ArrayList;
import java.util.HashMap;

public class WorkDistributingCalculator extends AbstractFlowOfSystemCalculator {

    public int[][] calculateOptimalListOfWorkerWithWork(WorkDistributingList workDistributingList){
        return calculateFlowForSystem(workDistributingList);
    }

    public HashMap<WorkerOrWork, WorkerOrWork> giveListWorkerWithWorkMatch(WorkDistributingList workDistributingList){
        int[][] list = calculateFlowForSystem(workDistributingList);
        HashMap<WorkerOrWork, WorkerOrWork> listWithWorkerAndHisWork = new HashMap<>();
        for (int i = 0; i < list.length ; i++) {
            for (int j = 0; j < list.length; j++) {
                if(list[i][j] != 0 && workDistributingList.vertexList.get(i).isWorker()){
                    listWithWorkerAndHisWork.put(workDistributingList.vertexList.get(i),workDistributingList.vertexList.get(j));
                }
            }
        }
        return listWithWorkerAndHisWork;
    }

}
