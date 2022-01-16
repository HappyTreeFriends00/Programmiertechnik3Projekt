package Algorithmen;

import java.util.ArrayList;

public class RoadSystem extends AbstractGraph<RoadStops> {

    public ArrayList<RoadStops> allCarsOfRoadSystem = vertexList;
    public int[][] streets = edge;

    public RoadSystem(ArrayList<RoadStops> roadStops) {
        super(roadStops);
    }

    public ArrayList<RoadStops> getAllCarsOfRoadSystem() {
        return vertexList;
    }

    public int[][] getStreets() {
        return streets;
    }

    public RoadStops getSource() {
        for (RoadStops roadStops : allCarsOfRoadSystem) {
            if (roadStops.isSource()) {
                return roadStops;
            }
        }
        return null;
    }

    public RoadStops getTrap(){
        for (RoadStops stops:allCarsOfRoadSystem) {
            if(stops.isTrap()){
                return stops;
            }
        }
        return null;
    }

    public RoadStops findRoadStopWithName(String name){
        for (RoadStops stop:allCarsOfRoadSystem) {
            if(stop.getRoadStopName().equals(name)){
                return stop;
            }
        }
        throw new IllegalArgumentException("Stop existiert nicht");
    }
}
