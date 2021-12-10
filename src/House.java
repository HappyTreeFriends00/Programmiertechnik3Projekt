public class House implements IObjectGetName {
    private int houseNumber;
    private boolean isSource;
    private boolean isTrap;

    public House(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public House(int houseNumber, boolean isSource, boolean isTrap) {
        this.houseNumber = houseNumber;
        this.isSource = isSource;
        this.isTrap = isTrap;
    }

    @Override
    public String getName() {
        return String.valueOf(houseNumber);
    }

    public int getHouseNumber() {
        return houseNumber;
    }
}
