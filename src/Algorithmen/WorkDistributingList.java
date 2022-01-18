package Algorithmen;

import java.util.ArrayList;

public class WorkDistributingList extends AbstractGraph<WorkerOrWork> {

    public ArrayList<WorkerOrWork> allWorkerOrWorkOfTheList = vertexList;

    public WorkDistributingList(ArrayList<WorkerOrWork> list, WorkerOrWork source, WorkerOrWork trap){
        super(list, source, trap);
        for (WorkerOrWork workerOrWork:allWorkerOrWorkOfTheList) {
            if(!(workerOrWork.isSource() || workerOrWork.isTrap())) {
                if (workerOrWork.isWorker()) {
                    addWeightForEdgeInDirectedGraph(source, workerOrWork, 1);
                } else {
                    addWeightForEdgeInDirectedGraph(workerOrWork, trap, 1);
                }
            }
        }
    }

    public void printAllWorkerWithTheirWork(int[][] graph){
        printGraphOut(allWorkerOrWorkOfTheList, graph);
    }

    public WorkerOrWork getSource(){
        for (WorkerOrWork workerOrWork:allWorkerOrWorkOfTheList) {
            if(workerOrWork.isSource()){
                return workerOrWork;
            }
        }
        return null;
    }

    public WorkerOrWork getTrap(){
        for (WorkerOrWork workerOrWork: allWorkerOrWorkOfTheList) {
            if(workerOrWork.isTrap()){
                return workerOrWork;
            }
        }
        return null;
    }

    public WorkerOrWork findWorkerOrWorkWithName(String name){
        for (WorkerOrWork workerOrWork:allWorkerOrWorkOfTheList) {
            if(workerOrWork.getWorkerName().equals(name)){
                return workerOrWork;
            }
        }
        throw new IllegalArgumentException("Arbeiter oder Arbeit existiert nicht");
    }
}
