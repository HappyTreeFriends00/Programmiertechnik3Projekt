package Algorithmen;

public class House implements IObjectGetName {
    private int houseNumber;
    private boolean isSource;
    private boolean isTrap;
    private String surname;
    private int degree;
    private boolean visited = false;
    private boolean isNecessary = true;

    public House(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public House(int houseNumber,String surname, boolean isSource, boolean isTrap) {
        this.houseNumber = houseNumber;
        this.isSource = isSource;
        this.isTrap = isTrap;
        this.surname = surname;
    }

    public House(int houseNumber, boolean isNecessary) {
        this.houseNumber = houseNumber;
        this.isNecessary = isNecessary;
    }

    @Override
    public String getName() {
        return String.valueOf(houseNumber);
    }

    public String getSurname() {
        return surname;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public boolean isSource() {
        return isSource;
    }

    public boolean isTrap() {
        return isTrap;
    }

    public int getDegree() {
        return degree;
    }

    public void incrementDegree() {
        this.degree++;
    }

    public void decrementDegree() {
        this.degree--;
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

    public boolean isNecessary() {
        return isNecessary;
    }
}
