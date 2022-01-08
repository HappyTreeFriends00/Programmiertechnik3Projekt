package Algorithmen.RoadConstructionProblem;

import Algorithmen.City;
import Algorithmen.House;
import Algorithmen.InvitationsDistributingProblem.InvitationsDistributingRouteCalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class MainStreetBuildProblem {
    public static void main(String[] args) {
        ArrayList<Algorithmen.House> houses = new ArrayList<>();
        System.out.println("Bitte geben sie von allen Häusern einer Stadt die Hausnummer ein. Sobald sie fertig sind mit der eingabe \"fertig\" und enter bestätigen");
        Scanner scanner = new Scanner(System.in);
        boolean giveMoreHouses = true;
        boolean moreWeightWillAdd = true;
        while (giveMoreHouses) {
            if(scanner.hasNextInt()) {
                int houseNumber = scanner.nextInt();
                Algorithmen.House house = new Algorithmen.House(houseNumber);
                if(houses.isEmpty()){
                    houses.add(house);
                    System.out.println("Das nächste Haus bitte");
                }else {
                    boolean houseExist = false;
                    for (Algorithmen.House houseForControlOfDuplicate : houses) {
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
        Algorithmen.City city = new Algorithmen.City(houses);

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


        city.printGraphOut(houses, city.edge);
        RoadConstructionCostCalculator calculator = new RoadConstructionCostCalculator();
        city.printAllHousesWithWayBuildCostOut(calculator.calculateMinimalCostToBuildStreets(city));

        InvitationsDistributingRouteCalculator invitationsDistributingRouteCalculator = new InvitationsDistributingRouteCalculator();
        ArrayList<House> resultList = invitationsDistributingRouteCalculator.calculateEulerwayOrEulertour(city);
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Das erste Haus ist: ");
        for (House house:resultList) {
            stringBuilder.append(house.getHouseNumber());
            stringBuilder.append("\n" );
            index++;
            if(!(resultList.size() == index)){
                stringBuilder.append("von dort aus geht der Postbote weiter zum Haus:");
            }
        }

        System.out.println(stringBuilder.toString());
    }
}