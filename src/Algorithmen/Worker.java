package Algorithmen;

public class Worker implements IObjectGetName{
    private boolean visited = false;
    private int workerNumber;
    private boolean isSource;
    private boolean isTrap;
    private String workerName;

    public Worker(int workerNumber, boolean isSource, boolean isTrap, String workerName) {
        this.workerNumber = workerNumber;
        this.isSource = isSource;
        this.isTrap = isTrap;
        this.workerName = workerName;
    }

    @Override
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public boolean isVisited() {
        return this.visited;
    }

    @Override
    public String getName() {
        return String.valueOf(workerNumber);
    }

    @Override
    public boolean isTrap() {
        return this.isTrap;
    }

    public String getWorkerName() {
        return workerName;
    }
}
