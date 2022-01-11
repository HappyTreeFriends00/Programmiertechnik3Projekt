package Algorithmen;

public class WorkerOrWork implements IObjectGetName{
    private boolean visited = false;
    private int workerNumber;
    private boolean isSource;
    private boolean isTrap;
    private String workerName;
    private boolean isWorker;

    public WorkerOrWork(int workerNumber, boolean isSource, boolean isTrap, String workerName, boolean isWorker) {
        this.workerNumber = workerNumber;
        this.isSource = isSource;
        this.isTrap = isTrap;
        this.workerName = workerName;
        this.isWorker = isWorker;
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

    public int getWorkerOrWorkNumber() {
        return workerNumber;
    }

    public boolean isSource() {
        return isSource;
    }

    public boolean isWorker() {
        return isWorker;
    }
}
