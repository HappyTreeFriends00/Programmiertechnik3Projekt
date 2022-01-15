package Algorithmen;

import java.util.ArrayList;

public abstract class AbstractGraph<T> implements IGetSource{
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

    public AbstractGraph(ArrayList<T> objects, T source, T trap){
        this.vertexList = new ArrayList<>();
        this.edge = new int[objects.size() + 2][objects.size() + 2];
        vertexList.add(source);
        this.edge[vertexList.indexOf(source)] [vertexList.indexOf(source)] = 0;
        for (T object: objects) {
            vertexList.add(object);
            this.edge[vertexList.indexOf(object)] [vertexList.indexOf(object)] = 0;
        }
        vertexList.add(trap);
        this.edge[vertexList.indexOf(trap)] [vertexList.indexOf(trap)] = 0;
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
        String leerzeichen = "     ";
        StringBuilder sb = new StringBuilder();
        int[] lengthHorizontal = new int[vertexList.size() + 1];
        int lengthOfFirstObject = vertexList.get(0).getName().length();
        for (int i = 0; i < vertexList.get(0).getName().length() ; i++) {
            sb.append(" ");
        }
        sb.append("     ");
        lengthHorizontal[0] = sb.toString().length();
        int index = 1;
        int entireLength = 0;
        for (IObjectGetName object: vertexList){
            sb.append(object.getName() + "      ");
            lengthHorizontal[index] = sb.toString().length();
            for (int i = 0; i < index; i++) {
                    lengthHorizontal[index] -= lengthHorizontal[i];
            }
            index++;
        }
        sb.append("\n");
        for (IObjectGetName object: vertexList) {
            sb.append(object.getName());
            if(!(object.getName().length() == lengthOfFirstObject)){
                if(object.getName().length() < lengthOfFirstObject){
                    for (int i = 0; i < lengthOfFirstObject - object.getName().length(); i++) {
                        sb.append(" ");
                    }
                }else{
                    lengthHorizontal[0] = (leerzeichen.length() + lengthOfFirstObject) - object.getName().length() + 1;
                }
            }
            for(int nextVertex = 0; nextVertex < edges.length; nextVertex++){
                for (int i = 1; i < lengthHorizontal[nextVertex]; i++) {
                    sb.append(" ");
                }
                sb.append(edges[vertexList.indexOf(object)][nextVertex]);
            }
            sb.append("\n");
            lengthHorizontal[0] = leerzeichen.length() + lengthOfFirstObject;
        }
        System.out.println(sb.toString());
    }

    public abstract IObjectGetName getSource();

    public abstract IObjectGetName getTrap();

    public void setEveryVisitedToNotVisited(ArrayList<? extends IObjectGetName> list){
        for (IObjectGetName o: list ) {
                o.setVisited(false);
        }
    }
}
