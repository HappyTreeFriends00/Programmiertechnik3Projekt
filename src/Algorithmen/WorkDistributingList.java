package Algorithmen;

import java.util.ArrayList;

public class WorkDistributingList extends AbstractGraph<WorkerOrWork> {

    public ArrayList<WorkerOrWork> allWorkerOrWorkOfTheList = vertexList;
    public int[][] possibleWorkForWorker = edge;

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

    public WorkerOrWork getWorkerOrWorkWithWorkNumber(int workNumber){
        for (WorkerOrWork workerOrWork: vertexList) {
            if(workerOrWork.getWorkerOrWorkNumber() == workNumber){
                return workerOrWork;
            }
        }
        throw new IllegalArgumentException("Es scheint keine Arbeit oder Arbeiter mit dieser Nummer zu geben");
    }

    public ArrayList<WorkerOrWork> getAllWorkerOrWorkOfTheList() {
        return allWorkerOrWorkOfTheList;
    }

    public int[][] getPossibleWorkForWorker() {
        return possibleWorkForWorker;
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
}
