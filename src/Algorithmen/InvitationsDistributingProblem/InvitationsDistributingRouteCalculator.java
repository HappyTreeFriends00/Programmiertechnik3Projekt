package Algorithmen.InvitationsDistributingProblem;

import Algorithmen.City;
import Algorithmen.House;

import java.util.ArrayList;

public class InvitationsDistributingRouteCalculator {
   
    public ArrayList<House> calculateEulerwayOrEulertour(City city){
        int[][] controlGraph = new int[city.edge.length][city.edge.length];
        for (int i = 0; i < city.edge.length; i++) {
            for (int j = 0; j < city.edge.length; j++) {
                //Wird benötigt damit in keiner Subtour eine Kante+ zweimal abgelaufen wird
                controlGraph[i][j] = city.edge[i][j];
            }
        }
        //odd = ungerade
        int oddDegreeNodes = 0;
        ArrayList<House> housesWithOddDegree = new ArrayList<>();
        House startNode;
        House endNode;
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
            startNode = housesWithOddDegree.get(0);
            endNode = housesWithOddDegree.get(1);
        }else{
            startNode = city.vertexList.get(0);
            endNode = null;
        }
        boolean tourIsFinished = false;
        ArrayList<House> subTour = new ArrayList<>();
        subTour.add(startNode);
        ArrayList<House> tour = new ArrayList<>();
        tour.add(startNode);
        House nextNode = startNode;

        while(!tourIsFinished){
            //schauen nach dem nächsten Haus welches eine Kante zum derzeitigen Haus hat
            for (int nextHouse = 0; nextHouse < city.edge.length; nextHouse++) {
                //wenn eins gefunden ist und nicht in der subTour enthalten
                if(controlGraph[city.vertexList.indexOf(nextNode)][nextHouse] != 0 ){
                    if(isEulerwegOrEulertour(endNode,startNode,city,nextHouse)){
                            controlGraph[city.vertexList.indexOf(nextNode)][nextHouse] = 0;
                            controlGraph[nextHouse][city.vertexList.indexOf(nextNode)] = 0;
                            city.allHousesOfTheCity.get(nextHouse).decrementDegree();
                            city.allHousesOfTheCity.get(city.vertexList.indexOf(nextNode)).decrementDegree();
                            nextNode = city.vertexList.get(nextHouse);
                            subTour.add(nextNode);
                            break;
                    }else{
                        substituteTourelementWithSubtour(subTour, tour, city, controlGraph,nextNode,nextHouse);
                        tourIsFinished = true;
                        startNode = null;
                        for (House house:city.getAllHousesOfCity()) {
                            if(house.getDegree() != 0){
                                startNode = house;
                                nextNode = startNode;
                                tourIsFinished = false;
                                subTour.clear();
                                subTour.add(startNode);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return tour;
    }
    
    
    public void substituteTourelementWithSubtour(ArrayList<House> subTour, ArrayList<House> tour, City city, int[][] controlGraph, House nextNode, int nextHouse){
        subTour.add(city.vertexList.get(nextHouse));
        city.vertexList.get(nextHouse).decrementDegree();
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
    }

    public boolean isEulerwegOrEulertour(House endNode, House startNode, City city, int nextHouse){
        if(endNode != null){
            if(!(endNode.getDegree() == 1 & city.vertexList.get(nextHouse) == endNode)){
                return true;
            }else{
                return false;
            }
        }
        else{
            if(city.vertexList.get(nextHouse) != startNode){
                return true;
            }
            else {
                return false;
            }
        }
    }

}
