package Algorithmen;

public class Person implements IObjectGetName{
    private boolean visited = false;
    private int personNumber;
    private boolean isSource;
    private boolean isTrap;
    private String personName;
    private boolean isFemale;

    public Person(int personNumber, boolean isSource, boolean isTrap, String personName, boolean isFemale) {
        this.personNumber = personNumber;
        this.isSource = isSource;
        this.isTrap = isTrap;
        this.personName = personName;
        this.isFemale = isFemale;
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
        return String.valueOf(personNumber);
    }

    @Override
    public boolean isTrap() {
        return this.isTrap;
    }

    public String getPersonName() {
        return personName;
    }

    public int getWorkerOrWorkNumber() {
        return personNumber;
    }

    public boolean isSource() {
        return isSource;
    }

    public boolean isFemale() {
        return isFemale;
    }
}
