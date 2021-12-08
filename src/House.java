public class House implements IObjectGetName {
 private int houseNumber;

 public House(int houseNumber){
     this.houseNumber = houseNumber;
 }

    @Override
    public String getName() {
        return String.valueOf(houseNumber);
    }

    public int getHouseNumber() {
        return houseNumber;
    }
}
