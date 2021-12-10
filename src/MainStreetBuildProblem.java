import java.util.ArrayList;
import java.util.Scanner;

public class MainStreetBuildProblem {
    public static void main(String[] args) {
        ArrayList<House> houses = new ArrayList<>();
        System.out.println("Bitte geben sie von allen Häusern einer Stadt die Hausnummer ein. Sobald sie fertig sind mit der eingabe \"fertig\" und enter bestätigen");
        Scanner scanner = new Scanner(System.in);
        boolean giveMoreHouses = true;
        boolean moreWeightWillAdd = true;
        while (giveMoreHouses) {
            if(scanner.hasNextInt()) {
                int houseNumber = scanner.nextInt();
                House house = new House(houseNumber);
                if(houses.isEmpty()){
                    houses.add(house);
                    System.out.println("Das nächste Haus bitte");
                }else {
                    boolean houseExist = false;
                    for (House houseForControlOfDuplicate : houses) {
                        if(houseForControlOfDuplicate.getHouseNumber() == houseNumber){
                            System.out.println("Das Haus existiert bereits");
                            houseExist = true;
                        }
                    }
                    if(!houseExist){
                        houses.add(house);
                        System.out.println("Das nächste Haus bitte");
                    }
                }
            }
            else if(scanner.hasNext()){
                giveMoreHouses = false;
            }
        }
        City city = new City(houses);

            System.out.println("jetzt geben sie bitte jeweils für jedes Haus seine " +
                    "Nachbarn und die jeweiligen Baukosten an die eine Straße kosten würde");
            Scanner scanner1 = new Scanner(System.in);
            while(moreWeightWillAdd) {
                System.out.println("Zunächst das erste Haus");
                if (scanner1.hasNextInt()) {
                    try {
                        int houseNumberOne = scanner1.nextInt();
                        System.out.println("Jetzt das zweite");
                        int houseNumberTwo = scanner1.nextInt();
                        System.out.println("Und die Baukosten letztlich ohne Nachkommastelle");
                        int weight = scanner1.nextInt();
                        city.addWeightForEdgeInUndirectedGraph(city.getHouseWithHouseNumber(houseNumberOne), city.getHouseWithHouseNumber(houseNumberTwo), weight);
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Einer der Häuser existiert nicht. Bitte versuchen sie es erneut");
                        moreWeightWillAdd = false;
                    }catch (Exception e) {
                        System.out.println("Es wurden falsche Daten eingegeben. Vorgang wird abgebrochen und ausgewertet");
                    }
                }else{
                    moreWeightWillAdd = false;
                }
                System.out.println("Sobald sie fertig sind mit der eingabe \"fertig\" und enter bestätigen");
            }

       /* House house1 = new House(1);
        House house2 = new House(2);
        House house3 = new House(3);
        House house4 = new House(4);
        House house5 = new House(5);
        House house6 = new House(6);
        House house7 = new House(7);
        House house8 = new House(8);
        House house9 = new House(9);
        House house0 = new House(0);
        House[] houseArray = {house1, house2, house3, house4, house5, house6, house7, house8, house9, house0};
        ArrayList<House> houses = new ArrayList<>();
        for (int i = 0; i < houseArray.length; i++) {
            houses.add(houseArray[i]);
        }


        City city = new City(houses);
        city.addWeightForEdgeInUndirectedGraph(house1, house3, 5);
        city.addWeightForEdgeInUndirectedGraph(house1, house4, 4);
        city.addWeightForEdgeInUndirectedGraph(house1, house2, 3);
        city.addWeightForEdgeInUndirectedGraph(house2, house3, 3);
        city.addWeightForEdgeInUndirectedGraph(house2, house6, 3);
        city.addWeightForEdgeInUndirectedGraph(house2, house4, 5);
        city.addWeightForEdgeInUndirectedGraph(house2, house5, 4);
        city.addWeightForEdgeInUndirectedGraph(house3, house2, 3);
        city.addWeightForEdgeInUndirectedGraph(house3, house6, 2);
        city.addWeightForEdgeInUndirectedGraph(house3, house7, 3);
        city.addWeightForEdgeInUndirectedGraph(house3, house8, 4);
        city.addWeightForEdgeInUndirectedGraph(house3, house1, 5);
        city.addWeightForEdgeInUndirectedGraph(house4, house1, 4);
        city.addWeightForEdgeInUndirectedGraph(house4, house0, 2);
        city.addWeightForEdgeInUndirectedGraph(house4, house5, 4);
        city.addWeightForEdgeInUndirectedGraph(house4, house2, 5);
        city.addWeightForEdgeInUndirectedGraph(house5, house0, 3);
        city.addWeightForEdgeInUndirectedGraph(house5, house9, 2);
        city.addWeightForEdgeInUndirectedGraph(house5, house6, 4);
        city.addWeightForEdgeInUndirectedGraph(house5, house2, 4);
        city.addWeightForEdgeInUndirectedGraph(house5, house4, 4);
        city.addWeightForEdgeInUndirectedGraph(house6, house3, 2);
        city.addWeightForEdgeInUndirectedGraph(house6, house8, 3);
        city.addWeightForEdgeInUndirectedGraph(house6, house2, 3);
        city.addWeightForEdgeInUndirectedGraph(house6, house5, 4);
        city.addWeightForEdgeInUndirectedGraph(house6, house9, 3);
        city.addWeightForEdgeInUndirectedGraph(house7, house8, 2);
        city.addWeightForEdgeInUndirectedGraph(house7, house3, 3);
        city.addWeightForEdgeInUndirectedGraph(house8, house7, 2);
        city.addWeightForEdgeInUndirectedGraph(house8, house9, 4);
        city.addWeightForEdgeInUndirectedGraph(house8, house3, 4);
        city.addWeightForEdgeInUndirectedGraph(house8, house6, 3);
        city.addWeightForEdgeInUndirectedGraph(house9, house8, 4);
        city.addWeightForEdgeInUndirectedGraph(house9, house5, 2);
        city.addWeightForEdgeInUndirectedGraph(house9, house0, 3);
        city.addWeightForEdgeInUndirectedGraph(house9, house6, 3);
        city.addWeightForEdgeInUndirectedGraph(house0, house4, 2);
        city.addWeightForEdgeInUndirectedGraph(house0, house5, 3);
        city.addWeightForEdgeInUndirectedGraph(house0, house9, 3);*/


        city.printGraphOut(houses, city.edge);
        RoadConstructionCostCalculator calculator = new RoadConstructionCostCalculator();
        city.printAllHousesWithWayBuildCostOut(calculator.calculateMinimalCostToBuildStreets(city));

    }
}
