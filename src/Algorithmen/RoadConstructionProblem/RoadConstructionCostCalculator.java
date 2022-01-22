package Algorithmen.RoadConstructionProblem;

import Algorithmen.City;
import Algorithmen.House;

import java.util.PriorityQueue;

public class RoadConstructionCostCalculator {

    public int[][] calculateMinimalCostToBuildStreets(City city){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Node[] nodes = new Node[city.getAllHousesOfCity().size()];
        int[][] graph = new int[city.getAllHousesOfCity().size()][city.getAllHousesOfCity().size()];

        for (int i = 0; i < city.getAllHousesOfCity().size(); i++) {
            Node node;
            House thisHouse = city.getAllHousesOfCity().get(i);
            if(city.getAllHousesOfCity().indexOf(thisHouse)== 0){
                node = new Node(thisHouse, 0, null);
            }else {
                node = new Node(thisHouse, Integer.MAX_VALUE, null);
            }
            nodes[i] = node;
            priorityQueue.add(node);
        }

        while (priorityQueue.iterator().hasNext()) {
            Node actualHouse = priorityQueue.remove();
                for (int anotherHouse = 0; anotherHouse < city.getAllHousesOfCity().size(); anotherHouse++) {
                    if (city.getWays()[city.getAllHousesOfCity().indexOf(actualHouse.house)][anotherHouse] != 0) {
                        for (Node thisNode : nodes) {
                            if (thisNode.house == city.getAllHousesOfCity().get(anotherHouse) &&
                                    thisNode.key > city.getWays()[city.getAllHousesOfCity().indexOf(actualHouse.house)][anotherHouse]) {
                                thisNode.key = city.getWays()[city.getAllHousesOfCity().indexOf(actualHouse.house)][anotherHouse];
                                thisNode.previous = actualHouse.house;
                            }
                        }
                    }
                }
                if (actualHouse.key != 0) {
                    if (actualHouse.previous != null) {
                        graph[city.getAllHousesOfCity().indexOf(actualHouse.house)][city.getAllHousesOfCity().indexOf(actualHouse.previous)] = actualHouse.key;
                        graph[city.getAllHousesOfCity().indexOf(actualHouse.previous)][city.getAllHousesOfCity().indexOf(actualHouse.house)] = actualHouse.key;
                    }
                }
            //Wird gemacht damit die PriorityQueue sich selbst sortiert
            PriorityQueue<Node> priorityQueue1 = new PriorityQueue<>();
            for(Node node: priorityQueue){
                    priorityQueue1.add(node);
                }
            priorityQueue = priorityQueue1;
        }
        return graph;
    }

    public class Node implements Comparable<Node>{
        private House house;
        private int key;
        private House previous;

        public Node(House house, int key, House previous) {
            this.house = house;
            this.key = key;
            this.previous = previous;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.key, other.key);
        }
    }
}
