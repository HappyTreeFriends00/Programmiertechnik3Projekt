package Algorithmen.RoadConstructionProblem;

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
        boolean givesMoreWeightBetweenNodes = true;
        while (giveMoreHouses) {
            if (scanner.hasNextInt()) {
                int houseNumber = scanner.nextInt();
                Algorithmen.House house = new Algorithmen.House(houseNumber);
                if (houses.isEmpty()) {
                    houses.add(house);
                    System.out.println("Das nächste Haus bitte");
                } else {
                    boolean houseExist = false;
                    for (Algorithmen.House houseForControlOfDuplicate : houses) {
                        if (houseForControlOfDuplicate.getHouseNumber() == houseNumber) {
                            System.out.println("Das Haus existiert bereits");
                            houseExist = true;
                        }
                    }
                    if (!houseExist) {
                        houses.add(house);
                        System.out.println("Das nächste Haus bitte");
                    }
                }
            } else if (scanner.hasNext()) {
                giveMoreHouses = false;
            }
        }
        Algorithmen.City city = new Algorithmen.City(houses);

        System.out.println("jetzt geben Sie bitte jeweils für jedes Haus seine " +
                "Nachbarn und die jeweiligen Baukosten an, die eine Straße kosten würde");
        Scanner scanner1 = new Scanner(System.in);
        while (givesMoreWeightBetweenNodes) {
            System.out.println("Zunächst das erste Haus");
            if (scanner1.hasNextInt()) {
                try {
                    int houseNumberOne = scanner1.nextInt();
                    System.out.println("Jetzt das zweite");
                    int houseNumberTwo = scanner1.nextInt();
                    System.out.println("Und die Baukosten letztlich ohne Nachkommastelle");
                    int weight = scanner1.nextInt();
                    if(city.edge[city.allHousesOfTheCity.indexOf(city.findHouseWithHouseNumber(houseNumberOne))][city.allHousesOfTheCity.indexOf(city.findHouseWithHouseNumber(houseNumberTwo))] == 0 ){
                        city.addWeightForEdgeInUndirectedGraph(city.findHouseWithHouseNumber(houseNumberOne), city.findHouseWithHouseNumber(houseNumberTwo), weight);
                   }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Einer der Häuser existiert nicht. Bitte versuchen sie es erneut");
                    givesMoreWeightBetweenNodes = false;
                } catch (Exception e) {
                    System.out.println("Es wurden falsche Daten eingegeben. Vorgang wird abgebrochen und ausgewertet");
                }
            } else {
                givesMoreWeightBetweenNodes = false;
            }
            System.out.println("Sobald sie fertig sind mit der eingabe \"fertig\" und enter bestätigen");
        }


        //city.printGraphOut(houses, city.edge);
        System.out.println("Unten finden Sie den Plan, wie die Stadt ein Wegnetz mit den minimalen Kosten bauen kann, dabei kann die Adjazensmatrix sowohl horizontal als auch vertikal gelesen werden. Ein Beispiel zur Erklärung:\n     1" + "\n" + "14   4" + "\n das Haus mit der Hausnummer 1 sollte einen Weg zum Haus mit der Hausnummer 14 mit den Baukosten 4 bauen");
        RoadConstructionCostCalculator calculator = new RoadConstructionCostCalculator();
        city.printAllHousesWithWayBuildCostOut(calculator.calculateMinimalCostToBuildStreets(city));

        System.out.println("Möchten Sie nun noch schauen ob es in dem für Sie berechneten Wegnetz einen optimalen Weg für den Postboten gibt?");
        System.out.println("y für yes, n für no: y/n");
        if (scanner.hasNext()) {
            String nextString = scanner.next();
            if(!nextString.equals("n")) {
                ArrayList<House> resultList = null;
                if (scanner.next().equals("y")) {
                    InvitationsDistributingRouteCalculator invitationsDistributingRouteCalculator = new InvitationsDistributingRouteCalculator();
                    try {
                        resultList = invitationsDistributingRouteCalculator.calculateEulerwayOrEulertour(city);
                    } catch (Exception e) {
                        System.out.println("Wir können den Graphen zu einen Eulergraphen umwandeln, das kann notwendig sein, falls zum Beispiel jeder Weg zweimal gelaufen werden muss. Soll der Graph umgewandelt werden? \"y für yes, n für no: y/n\"");
                        if (scanner.next().equals("y")) {
                            resultList = invitationsDistributingRouteCalculator.calculateEulerwayOrEulertour(invitationsDistributingRouteCalculator.makeGraphToAnPossibleEulergraph(city));
                        } else {
                            System.out.println("Prozess beendet");
                            return;
                        }
                    }
                    int index = 0;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Das erste Haus ist: ");
                    for (House house : resultList) {
                        if(house.isNecessary()) {
                            stringBuilder.append(house.getHouseNumber());
                            stringBuilder.append("\n");
                            index++;
                            if (!(resultList.size() == index)) {
                                stringBuilder.append("von dort aus geht der Postbote weiter zum Haus:");
                            }
                        }
                    }
                    System.out.println(stringBuilder.toString());
                }
            }
        } else {
            System.out.println("Prozess beendet");
        }
    }
}