package Algorithmen.InvitationsDistributingProblem;

import Algorithmen.City;
import Algorithmen.House;

import java.util.*;

public class InvitationsDistributingRouteCalculator {
   
    public ArrayList<House> calculateEulerwayOrEulertour(City city){
        int[][] controlGraph = new int[city.edge.length][city.edge.length];
        for (int i = 0; i < city.edge.length; i++) {
            //Wird benötigt damit in keiner Subtour eine Kante zweimal abgelaufen wird
            System.arraycopy(city.edge[i], 0, controlGraph[i], 0, city.edge.length);
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
                        substituteTourElementWithSubtour(subTour, tour, city, controlGraph,nextNode,nextHouse);
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
    
    
    private void substituteTourElementWithSubtour(ArrayList<House> subTour, ArrayList<House> tour, City city, int[][] controlGraph, House nextNode, int nextHouse){
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

    private boolean isEulerwegOrEulertour(House endNode, House startNode, City city, int nextHouse){
        if(endNode != null){
            return !(endNode.getDegree() == 1 & city.vertexList.get(nextHouse) == endNode);
        }
        else{
            return city.vertexList.get(nextHouse) != startNode;
        }
    }

   public City makeGraphToAnPossibleEulergraph(City city){
       LinkedHashMap<House,House> connectedHouseHashMap = new LinkedHashMap<>();
       for (int j = 0; j < city.edge.length; j++) {
           for (int k = 0; k < city.edge.length; k++) {
               if (city.edge[j][k]!= 0){
                   House house = new House(city.allHousesOfTheCity.get(j).getHouseNumber(), false);
                   city.allHousesOfTheCity.add(house);
                   connectedHouseHashMap.put(house, city.allHousesOfTheCity.get(k));
               }
           }
       }

       City newCity = new City(city.allHousesOfTheCity);
       for (int j = 0; j < city.edge.length; j++) {
           System.arraycopy(city.edge[j], 0, newCity.edge[j], 0, city.edge.length);
       }

       for (Map.Entry<House,House> entry: connectedHouseHashMap.entrySet()) {
           newCity.addWeightForEdgeInUndirectedGraph(entry.getKey(),entry.getValue(),1);
       }

       for (int i = city.edge.length; i < newCity.allHousesOfTheCity.size(); i++) {
           for (int j = 0; j < city.edge.length; j++) {
               if(newCity.edge[i][j] != 0){
                   for (Map.Entry<House,House> entry: connectedHouseHashMap.entrySet()) {
                       if (entry.getKey().getHouseNumber() == newCity.allHousesOfTheCity.get(j).getHouseNumber() &&
                               newCity.edge[city.allHousesOfTheCity.indexOf(entry.getKey())][newCity.allHousesOfTheCity.indexOf(newCity.findHouseWithHouseNumber(newCity.allHousesOfTheCity.get(i).getHouseNumber()))] != 0) {
                           newCity.addWeightForEdgeInUndirectedGraphAndOnlyOfObjectOneWillIncrementDegree(newCity.allHousesOfTheCity.get(i), entry.getKey(), 1);
                       }
                   }
               }
           }
       }
       return newCity;
    }
}
