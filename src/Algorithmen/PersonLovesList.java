package Algorithmen;

import java.util.ArrayList;

public class PersonLovesList extends AbstractGraph<Person> {

    public ArrayList<Person> allPersonOfTheList = vertexList;
    public int[][] relationBetweenPersons = edge;

    public PersonLovesList(ArrayList<Person> list, Person source, Person trap){
        super(list, source, trap);
        for (Person person: allPersonOfTheList) {
            if(!(person.isSource() || person.isTrap())) {
                if (person.isFemale()) {
                    addWeightForEdgeInDirectedGraph(source, person, 1);
                } else {
                    addWeightForEdgeInDirectedGraph(person, trap, 1);
                }
            }
        }
    }

    public void printAllPersonsWithTheirPreference(int[][] graph){
        printGraphOut(allPersonOfTheList, graph);
    }

    public ArrayList<Person> getAllPersonOfTheList() {
        return allPersonOfTheList;
    }

    public int[][] getRelationBetweenPersons() {
        return relationBetweenPersons;
    }

    public Person getSource(){
        for (Person person: allPersonOfTheList) {
            if(person.isSource()){
                return person;
            }
        }
        return null;
    }

    public Person getTrap(){
        for (Person person: allPersonOfTheList) {
            if(person.isTrap()){
                return person;
            }
        }
        return null;
    }

    public void setAllPossibleRelations(){
        for (int i = 1; i < allPersonOfTheList.size()-1; i++) {
            for (int j = 1; j < allPersonOfTheList.size()-1; j++) {
                if(relationBetweenPersons[i][j] != 0 && relationBetweenPersons[j][i] != 0){
                    if(allPersonOfTheList.get(i).isFemale()){
                        relationBetweenPersons[i][j] = 1;
                    }else{
                        relationBetweenPersons[j][i] = 1;
                    }
                }else{
                    relationBetweenPersons[i][j] = 0;
                }
            }

        }
    }
    public Person findPersonWithSurname(String name){
        for (Person person:allPersonOfTheList) {
            if(person.getPersonName().equals(name)){
                return person;
            }
        }
        throw new IllegalArgumentException("Stop existiert nicht");
    }
}
