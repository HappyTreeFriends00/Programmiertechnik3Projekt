import java.util.ArrayList;

public class InvitationsDistributingRouteCalculator {

    public ArrayList<House> calculateEulerwayOrEulertour(City city){
        int[][] controlGraph = new int[city.edge.length][city.edge.length];
        for (int i = 0; i < city.edge.length; i++) {
            for (int j = 0; j < city.edge.length; j++) {
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
                        if(!subTour.contains(city.vertexList.get(nextHouse))) {
                            controlGraph[city.vertexList.indexOf(nextNode)][nextHouse] = 0;
                            controlGraph[nextHouse][city.vertexList.indexOf(nextNode)] = 0;
                            nextNode = city.vertexList.get(nextHouse);
                            subTour.add(nextNode);
                            break;
                        }
                    }else{
                      subTour.add(starNode);
                        if(!subTour.isEmpty()) {
                            int index = tour.indexOf(subTour.get(0));
                            for (House house : subTour) {
                                house.decrementDegree();
                                tour.add(index, house);
                                index++;
                            }
                        }
                        tourIsFinished = true;
                        starNode = null;
                        for (House house:city.getAllHousesOfCity()) {
                            if(house.getDegree() != 0){
                                starNode = house;
                                tourIsFinished = false;
                                subTour.clear();
                                subTour.add(starNode);
                                for (int i = 0; i < city.edge.length; i++) {
                                    for (int j = 0; j < city.edge.length; j++) {
                                        controlGraph[i][j] = city.edge[i][j];
                                    }
                                }
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
