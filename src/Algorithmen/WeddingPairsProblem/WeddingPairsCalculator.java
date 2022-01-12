package Algorithmen.WeddingPairsProblem;

import Algorithmen.*;

import java.util.HashMap;

public class WeddingPairsCalculator extends AbstractFlowOfSystemCalculator {

    public int[][] calculateOptimalListOfWeddingPairs(PersonLovesList personLovesList){
        personLovesList.setAllPossibleRelations();
        return calculateFlowForSystem(personLovesList);
    }

    public HashMap<Person, Person> giveListPairMatch(PersonLovesList personLovesList){
        int[][] list = calculateFlowForSystem(personLovesList);
        HashMap<Person, Person> listWithWorkerAndHisWork = new HashMap<>();
        for (int i = 0; i < list.length ; i++) {
            for (int j = 0; j < list.length; j++) {
                if(list[i][j] != 0 && personLovesList.vertexList.get(i).isFemale()){
                    listWithWorkerAndHisWork.put(personLovesList.vertexList.get(i),personLovesList.vertexList.get(j));
                }
            }
        }
        return listWithWorkerAndHisWork;
    }
}
