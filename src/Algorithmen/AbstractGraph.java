package Algorithmen;

import java.util.ArrayList;

public abstract class AbstractGraph<T>{
    public ArrayList<T> vertexList;
    public int[][] edge;

    public AbstractGraph(ArrayList<T> objects){
        this.vertexList = new ArrayList<>();
        this.edge = new int[objects.size()][objects.size()];
        for (T object: objects) {
            vertexList.add(object);
            this.edge[vertexList.indexOf(object)] [vertexList.indexOf(object)] = 0;
        }
    }

    public void addWeightForEdgeInUndirectedGraph(T objectOne, T objectTwo, int weight){
        edge[vertexList.indexOf(objectOne)] [vertexList.indexOf(objectTwo)] = weight;
        edge[vertexList.indexOf(objectTwo)] [vertexList.indexOf(objectOne)] = weight;
    }

    public void addWeightForEdgeInDirectedGraph(T startNode, T endNode, int weight){
        edge[vertexList.indexOf(startNode)] [vertexList.indexOf(endNode)] = weight;
    }

    public int getWeightOfEdge(T objectOne, T objectTwo){
        return edge[vertexList.indexOf(objectOne)][vertexList.indexOf(objectTwo)];
    }

    public void printGraphOut(ArrayList<? extends IObjectGetName> vertexList, int[][] edges){
        StringBuilder sb = new StringBuilder();
        sb.append("      ");
        for (IObjectGetName object: vertexList){
            sb.append(object.getName() + "      ");
        }
        sb.append("\n");
        for (IObjectGetName object: vertexList) {
            sb.append(object.getName());
            for(int nextVertex = 0; nextVertex < edges.length; nextVertex++){
                sb.append("     ");
                sb.append(edges[vertexList.indexOf(object)][nextVertex] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
