package Algorithmen;

public interface IObjectGetName {
    boolean visited = false;

    void setVisited(boolean visited);
    boolean isVisited();
    String getName();
    boolean isTrap();
    boolean isSource();

}
