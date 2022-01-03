package Algorithmen.InvitationsDistributingProblem;

import Algorithmen.City;
import Algorithmen.House;

import java.util.ArrayList;

public class InvitationsDistributingRouteCalculator {
    public ArrayList<House> calculateEulerwayOrEulertour(City city){
        int[][] controlGraph = new int[city.edge.length][city.edge.length];
        for (int i = 0; i < city.edge.length; i++) {
            for (int j = 0; j < city.edge.length; j++) {
                //Wird benötigt damit in keiner Subtour ein Knoten zweimal abgelaufen wird
                controlGraph[i][j] = city.edge[i][j];
            }
        }
        //odd = ungerade
        int oddDegreeNodes = 0;
        ArrayList<House> housesWithOddDegree = new ArrayList<>();
        House starNode;
        for (House house: city.getAllHousesOfCity()) {
            if(house.getDegree() % 2 != 0){
                oddDegreeNodes++;
                housesWithOddDegree.add(house);
            }
        }
        if(oddDegreeNodes > 0 & oddDegreeNodes != 2) {
            throw new IllegalArgumentException("dieser Graph hat keinen Eulerweg oder Eulertour");
        }
        if(oddDegreeNodes == 2){
            starNode = housesWithOddDegree.get(0);
        }else{
            starNode = city.vertexList.get(0);
        }
        boolean tourIsFinished = false;
        ArrayList<House> subTour = new ArrayList<>();
        subTour.add(starNode);
        ArrayList<House> tour = new ArrayList<>();
        tour.add(starNode);
        House nextNode = starNode;

        while(!tourIsFinished){
            //schauen nach dem nächsten Haus welches eine Kante zum derzeitigen Haus hat
            for (int nextHouse = 0; nextHouse < city.edge.length; nextHouse++) {
                //wenn eins gefunden ist und nicht in der subTour enthalten
                if(controlGraph[city.vertexList.indexOf(nextNode)][nextHouse] != 0 ){
                    if(city.vertexList.get(nextHouse) != starNode ){
                            controlGraph[city.vertexList.indexOf(nextNode)][nextHouse] = 0;
                            controlGraph[nextHouse][city.vertexList.indexOf(nextNode)] = 0;
                            city.allHousesOfTheCity.get(nextHouse).decrementDegree();
                            city.allHousesOfTheCity.get(city.vertexList.indexOf(nextNode)).decrementDegree();
                            nextNode = city.vertexList.get(nextHouse);
                            subTour.add(nextNode);
                            break;
                    }else{
                        subTour.add(starNode);
                        starNode.decrementDegree();
                        city.allHousesOfTheCity.get(city.vertexList.indexOf(nextNode)).decrementDegree();
                        controlGraph[city.vertexList.indexOf(nextNode)][nextHouse] = 0;
                        controlGraph[nextHouse][city.vertexList.indexOf(nextNode)] = 0;
                        if(!subTour.isEmpty()) {
                            int index = tour.indexOf(subTour.get(0));
                            tour.remove(index);
                            for (House house : subTour) {
                                tour.add(index, house);
                                index++;
                            }
                        }
                        tourIsFinished = true;
                        starNode = null;
                        for (House house:city.getAllHousesOfCity()) {
                            if(house.getDegree() != 0){
                                starNode = house;
                                nextNode = starNode;
                                tourIsFinished = false;
                                subTour.clear();
                                subTour.add(starNode);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return tour;
    }

}
