package Algorithmen.WaterSupplyProblem;

import Algorithmen.House;
import Algorithmen.WaterSupplySystem;

import java.util.ArrayList;
import java.util.Scanner;

public class MainWaterSupplyProblem {
    public static void main(String[] args) {
        ArrayList<House> houseArrayList = new ArrayList<>();
        System.out.println("Bitte geben Sie alle Häuser der Stadt ein. Sobald sie fertig sind mit der eingabe \"fertig\" und enter bestätigen");
        Scanner scanner = new Scanner(System.in);
        boolean giveMoreStops = true;
        boolean givesMoreWeightBetweenNodes = true;
        int index = 0;
        while (giveMoreStops) {
            if (scanner.hasNext()) {
                String houseName = scanner.next();
                if (houseName.equals("fertig")) {
                    giveMoreStops = false;
                    houseArrayList.get(houseArrayList.size() - 1).setTrap(true);
                    break;
                }
                if (houseArrayList.isEmpty()) {
                    House house1 = new House(index, houseName, true, false);
                    houseArrayList.add(house1);
                    System.out.println("Das nächste House");
                    index++;
                } else {
                    boolean houseExist = false;
                    for (House houseForControlOfDuplicate : houseArrayList) {
                        if (houseForControlOfDuplicate.getName().equals(houseName)) {
                            System.out.println("Das Haus existiert bereits");
                            houseExist = true;
                        }
                    }
                    if (!houseExist) {
                        House house = new House(index, houseName, false, false);
                        houseArrayList.add(house);
                        System.out.println("Das nächste Haus");
                        index++;
                    }
                }
            } else {
                houseArrayList.get(houseArrayList.size() - 1).setTrap(true);
                giveMoreStops = false;
            }
        }
        WaterSupplySystem waterSupplySystem = new WaterSupplySystem(houseArrayList);

        System.out.println("Als nächstes braucht die Software noch die Kapazität und die Richtung von einem Haus zum andern, und wie viel Wasser fliesen kann");

        while (givesMoreWeightBetweenNodes) {
            System.out.println("Das erste Haus");
            if (scanner.hasNext()) {
                String firstHouse = scanner.next();
                String secondeHouse = null;
                int weight = 0;
                if (firstHouse.equals("fertig")) {
                    givesMoreWeightBetweenNodes = false;
                    break;
                }
                System.out.println("Das zweite Haus bitte");
                if (scanner.hasNext()) {
                    secondeHouse = scanner.next();
                }
                System.out.println("Und noch die Kapazität wie viele Wasser fliesen kann");
                if (scanner.hasNextInt()) {
                    weight = scanner.nextInt();
                }
                waterSupplySystem.addWeightForEdgeInDirectedGraph(waterSupplySystem.findHouseWithSurname(firstHouse), waterSupplySystem.findHouseWithSurname(secondeHouse), weight);
            }
        }

        WaterSupplyMaxFlowCalculator calculator = new WaterSupplyMaxFlowCalculator();

        calculator.getMaxFlowRate(waterSupplySystem);

    }

}
