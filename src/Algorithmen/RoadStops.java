package Algorithmen;

public class RoadStops implements IObjectGetName{
    private boolean isSource;
    private boolean isTrap;
    private String roadStopName;
    private int roadStopNumber;
    private boolean visited = false;

    public RoadStops(String roadStopName, boolean isSource, boolean isTrap, int roadStopNumber) {
        this.isSource = isSource;
        this.isTrap = isTrap;
        this.roadStopName = roadStopName;
        this.roadStopNumber = roadStopNumber;
    }

    public boolean isSource() {
        return isSource;
    }

    public boolean isTrap() {
        return isTrap;
    }

    @Override
    public String getName() {
        return String.valueOf(roadStopNumber);
    }

    @Override
    public void setVisited(boolean visited){
        this.visited = visited;
    }

    @Override
    public boolean isVisited() {
        return this.visited;
    }
}
