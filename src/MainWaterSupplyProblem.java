import java.util.ArrayList;

public class MainWaterSupplyProblem {
    public static void main(String[] args) {
        House wasserwerk = new House(1,true, false);
        House thoma = new House(2,false, false);
        House dogan = new House(3,false, false);
        House adler = new House(4,false, false);
        House ilona = new House(5,false, false);
        House club = new House(6,false, false);
        House bogart = new House(7,false, false);
        House holler = new House(8,false, true);
        House[] houseArray = {wasserwerk, thoma, dogan, adler, ilona, club, holler, bogart};
        ArrayList<House> houses = new ArrayList<>();
        for (int i = 0; i < houseArray.length; i++) {
            houses.add(houseArray[i]);
        }
        //WaterSupplySystem waterSupplySystem = new WaterSupplySystem();
    }
}
