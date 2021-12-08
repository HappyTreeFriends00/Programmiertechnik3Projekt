import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*ArrayList<House> houses = new ArrayList<>();
        System.out.println("Bitte geben sie von allen Häusern einer Stadt die Hausnummer ein. Sobald sie fertig sind mit der eingabe \"fertig\" und enter bestätigen");
        Scanner scanner = new Scanner(System.in);
        boolean giveMoreHouses = true;
        boolean moreWeightWillAdd = true;
        while (giveMoreHouses) {
            if(scanner.hasNextInt()) {
                int houseNumber = scanner.nextInt();
                House house = new House(houseNumber);
                houses.add(house);
            }
            else if(scanner.hasNext()){
                givesMoreHouses = false;
            }
        }
        City city = new City(houses);

            System.out.println("jetzt geben sie bitte jeweils für jedes Haus seine " +
                    "Nachbarn und die jeweiligen Baukosten an die eine Straße kosten würde");
            Scanner scanner1 = new Scanner(System.in);
            while(moreWeightWillAdd) {
                System.out.println("Zunächst das erste Haus");
                if (scanner1.hasNextInt()) {
                    int houseNumberOne = scanner1.nextInt();
                    System.out.println("Jetzt das zweite");
                    int houseNumberTwo = scanner1.nextInt();
                    System.out.println("Und die Baukosten letztlich ohne Nachkommastelle");
                    int weight = scanner1.nextInt();
                    city.addWeightForEdge(city.getHouseWithHouseNumber(houseNumberOne), city.getHouseWithHouseNumber(houseNumberTwo), weight);
                }else{
                    moreWeightWillAdd = false;
                }
                System.out.println("Sobald sie fertig sind mit der eingabe \"fertig\" und enter bestätigen");
            }*/

        House house1 = new House(1);
        House house2 = new House(2);
        House house3 = new House(3);
        House house4 = new House(4);
        House house5 = new House(5);
        ArrayList<House> houses = new ArrayList<>();
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);
        houses.add(house4);
        houses.add(house5);

        City city = new City(houses);
        /*city.addWeightForEdge(house1,house2, 4);
        city.addWeightForEdge(house1,house3, 2);
        city.addWeightForEdge(house3,house5, 3);
        city.addWeightForEdge(house2,house4, 5);
        city.addWeightForEdge(house2,house5, 9);
        city.addWeightForEdge(house5,house4, 7);*/


        city.printAllHousesWithWayBuildCostOut();
            RoadConstructionCostCalculator calculator = new RoadConstructionCostCalculator();
          city.printAllHousesWithWayBuildCostOut(calculator.calculateMinimalCostToBuildStreets(city));

    }
}
