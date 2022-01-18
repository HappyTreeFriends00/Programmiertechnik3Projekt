package Algorithmen;

public class RoadStops implements IObjectGetName{
    private boolean isSource;
    private boolean isTrap;
    private String roadStopName;
    private int roadStopNumber;
    private static int counter = 0;
    private boolean visited = false;

    public RoadStops(String roadStopName, boolean isSource, boolean isTrap) {
        this.isSource = isSource;
        this.isTrap = isTrap;
        this.roadStopNumber = counter;
        this.roadStopName = roadStopName;
        counter++;
    }

    public boolean isSource() {
        return isSource;
    }

    public boolean isTrap() {
        return isTrap;
    }

    @Override
    public String getName() {
        return String.valueOf(this.roadStopNumber);
    }

    @Override
    public void setVisited(boolean visited){
        this.visited = visited;
    }

    @Override
    public boolean isVisited() {
        return this.visited;
    }

    public void setTrap(boolean trap) {
        isTrap = trap;
    }

    public String getRoadStopName() {
        return roadStopName;
    }
}
