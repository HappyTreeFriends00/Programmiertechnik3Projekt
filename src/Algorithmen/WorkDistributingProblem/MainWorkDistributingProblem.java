package Algorithmen.WorkDistributingProblem;

import Algorithmen.WorkDistributingList;
import Algorithmen.WorkerOrWork;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class MainWorkDistributingProblem {
    public static void main(String[] args) {
        ArrayList<WorkerOrWork> workerOrWorkArrayList = new ArrayList<>();
        System.out.println("Bitte geben Sie alle Arbeiter und jede Arbeit ein. Sobald sie fertig sind mit der eingabe \"fertig\" und enter bestätigen");
        Scanner scanner = new Scanner(System.in);
        boolean giveMoreWorkerOrWork = true;
        boolean givesMoreWeightBetweenNodes = true;
        int index = 1;
        while (giveMoreWorkerOrWork) {
            if (scanner.hasNext()) {
                String workerOrWorkName = scanner.next();
                if (workerOrWorkName.equals("fertig")) {
                    giveMoreWorkerOrWork = false;
                    break;
                }
                System.out.println("Ist die Eingabe ein Arbeiter bitte mit \"y\" bestätigen oder eine Arbeit dann bitte mit einem anderen Buchstaben bestätigen \bestätigen");
                String workerOrWorker = scanner.next();
                if (workerOrWorkArrayList.isEmpty()) {
                    WorkerOrWork workerOrWork;
                    if (workerOrWorker.equals("y")) {
                        workerOrWork = new WorkerOrWork(index,false,false,workerOrWorkName, true);
                    } else {
                        workerOrWork = new WorkerOrWork(index,false,false,workerOrWorkName, false);
                    }
                    workerOrWorkArrayList.add(workerOrWork);
                    System.out.println("Der nächste Arbeiter oder die nächste Arbeit");
                    index++;
                } else {
                    boolean workerOrWorkExist = false;
                    for (WorkerOrWork workerOrWork : workerOrWorkArrayList) {
                        if (workerOrWork.getWorkerName().equals(workerOrWorkName)) {
                            System.out.println("Der Arbeiter oder die Arbeit existiert bereits");
                            workerOrWorkExist = true;
                        }
                    }
                    if (!workerOrWorkExist) {
                        WorkerOrWork workerOrWork;
                        if (workerOrWorker.equals("y")) {
                            workerOrWork = new WorkerOrWork(index,false,false,workerOrWorkName, true);
                        } else {
                            workerOrWork = new WorkerOrWork(index,false,false,workerOrWorkName, false);
                        }
                        workerOrWorkArrayList.add(workerOrWork);
                        System.out.println("Der nächste Arbeiter oder die nächste Arbeit");
                        index++;
                    }
                }
            } else {
                giveMoreWorkerOrWork = false;
            }
        }
        WorkerOrWork source = new WorkerOrWork(0, true, false, "source", false);
        WorkerOrWork trap = new WorkerOrWork(index + 1, false, true, "trap", false);
        WorkDistributingList workDistributingList = new WorkDistributingList(workerOrWorkArrayList, source, trap);

        System.out.println("Als nächstes braucht die Software noch die Angaben welcher Arbeiter welche Arbeit ausführen kann");

        while (givesMoreWeightBetweenNodes) {
            System.out.println("Der erste Arbeiter bitte");
            if (scanner.hasNext()) {
                String worker = scanner.next();
                String work = null;
                int weight = 1;
                if (worker.equals("fertig")) {
                    givesMoreWeightBetweenNodes = false;
                    break;
                }
                System.out.println("Die Arbeit die er ausführen kann");
                if (scanner.hasNext()) {
                    work = scanner.next();
                }
                workDistributingList.addWeightForEdgeInDirectedGraph(workDistributingList.findWorkerOrWorkWithName(worker), workDistributingList.findWorkerOrWorkWithName(work), weight);
            }
        }
        WorkDistributingCalculator calculator = new WorkDistributingCalculator();

        for (Map.Entry<WorkerOrWork, WorkerOrWork> entry: calculator.giveListWorkerWithWorkMatch(workDistributingList).entrySet()) {
            System.out.println(entry.getKey().getWorkerName() + " passt zu " + entry.getValue().getWorkerName());
        }
    }
}
