package Algorithmen.WorkDistributingProblem;

import Algorithmen.WorkDistributingList;
import Algorithmen.WorkerOrWork;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class WorkDistributingCalculatorTest {

    @Test
    void calculateOptimalListOfWorkerWithWork() {
        WorkerOrWork source = new WorkerOrWork(0, true, false, "source", false);
        WorkerOrWork maier = new WorkerOrWork(1, false, false, "maier",true);
        WorkerOrWork mueller = new WorkerOrWork(2, false, false, "mueller",true);
        WorkerOrWork august = new WorkerOrWork(3, false, false, "august", true);
        WorkerOrWork schmidt = new WorkerOrWork(4, false, false, "schmidt", true);
        WorkerOrWork kunze = new WorkerOrWork(5, false, false, "kunze", true);
        WorkerOrWork hof = new WorkerOrWork(6, false, false, "hof", true);
        WorkerOrWork lustig = new WorkerOrWork(7, false, false, "lustig",true);
        WorkerOrWork strassenbau = new WorkerOrWork(8, false, false, "strassenbau", false);
        WorkerOrWork modeberatung = new WorkerOrWork(9, false, false, "modeberatung", false);
        WorkerOrWork verkehrsplanung = new WorkerOrWork(10, false, false, "verkehrsplanung", false);
        WorkerOrWork archaeologie = new WorkerOrWork(11, false, false, "archaeologie", false);
        WorkerOrWork wasserversorgung = new WorkerOrWork(12, false, false, "wasserversorgung", false);
        WorkerOrWork hochzeitsplanung = new WorkerOrWork(13, false, false, "hochzeitsplanung", false);
        WorkerOrWork wettkampfausrichtung = new WorkerOrWork(14, false, false, "wettkampfausrichtung", false);
        WorkerOrWork trap = new WorkerOrWork(15, false, true, "trap", false);

        ArrayList<WorkerOrWork> workerOrWorksList = new ArrayList<>(Arrays.asList(maier,mueller,august,schmidt,kunze,hof,lustig,strassenbau,modeberatung,verkehrsplanung,archaeologie,wasserversorgung,hochzeitsplanung,wettkampfausrichtung));
        WorkDistributingList workDistributingList = new WorkDistributingList(workerOrWorksList, source, trap);

        workDistributingList.addWeightForEdgeInDirectedGraph(maier,strassenbau, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(maier,verkehrsplanung, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(maier,archaeologie, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(mueller,modeberatung, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(mueller,hochzeitsplanung, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(august,strassenbau, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(august,wasserversorgung, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(schmidt, strassenbau, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(schmidt,verkehrsplanung, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(schmidt,wettkampfausrichtung, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(kunze,archaeologie, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(kunze,hochzeitsplanung, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(hof,strassenbau, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(hof,modeberatung, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(lustig,verkehrsplanung, 1);
        workDistributingList.addWeightForEdgeInDirectedGraph(lustig,wettkampfausrichtung, 1);



        WorkDistributingCalculator workDistributingCalculator = new WorkDistributingCalculator();
        workDistributingList.printAllWorkerWithTheirWork(workDistributingCalculator.calculateOptimalListOfWorkerWithWork(workDistributingList));
        HashMap<WorkerOrWork, WorkerOrWork> controlList = new HashMap<>();
        controlList.put(maier,archaeologie);
        controlList.put(mueller,modeberatung);
        controlList.put(august,wasserversorgung);
        controlList.put(schmidt,wettkampfausrichtung);
        controlList.put(kunze,hochzeitsplanung);
        controlList.put(hof,strassenbau);
        controlList.put(lustig,verkehrsplanung);

        Assertions.assertEquals(controlList, workDistributingCalculator.giveListWorkerWithWorkMatch(workDistributingList));

    }
}