import java.util.PriorityQueue;

public class RoadConstructionCostCalculator {

    public int[][] calculateMinimalCostToBuildStreets(City city){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Node[] nodes = new Node[city.getAllHousesOfTheCity().size()];
        int[][] graph = new int[city.getAllHousesOfTheCity().size()][city.getAllHousesOfTheCity().size()];

        for (int i = 0; i < city.getAllHousesOfTheCity().size(); i++) {
            Node node;
            House thisHouse = city.getAllHousesOfTheCity().get(i);
            if(city.getAllHousesOfTheCity().indexOf(thisHouse)== 0){
                node = new Node(thisHouse, 0, null);
            }else {
                node = new Node(thisHouse, 9999, null);
            }
            nodes[i] = node;
            priorityQueue.add(node);
        }

        while (priorityQueue.iterator().hasNext()) {
            Node actualHouse = priorityQueue.remove();
                for (int anotherHouse = 0; anotherHouse < city.getAllHousesOfTheCity().size(); anotherHouse++) {
                    if (city.getWays()[city.getAllHousesOfTheCity().indexOf(actualHouse.house)][anotherHouse] != 0) {
                        for (Node thisNode : nodes) {
                            if (thisNode.house == city.getAllHousesOfTheCity().get(anotherHouse) &&
                                    thisNode.key > city.getWays()[city.getAllHousesOfTheCity().indexOf(actualHouse.house)][anotherHouse]) {
                                thisNode.key = city.getWays()[city.getAllHousesOfTheCity().indexOf(actualHouse.house)][anotherHouse];
                                thisNode.previous = actualHouse.house;
                            }
                        }
                    }
                }
                if (actualHouse.key != 0) {
                    if (actualHouse.previous != null) {
                        graph[city.getAllHousesOfTheCity().indexOf(actualHouse.house)][city.getAllHousesOfTheCity().indexOf(actualHouse.previous)] = actualHouse.key;
                        graph[city.getAllHousesOfTheCity().indexOf(actualHouse.previous)][city.getAllHousesOfTheCity().indexOf(actualHouse.house)] = actualHouse.key;
                    }
                }
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
