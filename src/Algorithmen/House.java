package Algorithmen;

public class House implements IObjectGetName {
    private int houseNumber;
    private boolean isSource;
    private boolean isTrap;
    private String surname;
    private int degree;

    public House(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public House(int houseNumber,String surname, boolean isSource, boolean isTrap) {
        this.houseNumber = houseNumber;
        this.isSource = isSource;
        this.isTrap = isTrap;
        this.surname = surname;
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
}
