package Algorithmen.TrafficFlowPorblem;

import Algorithmen.RoadStops;
import Algorithmen.RoadSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainTrafficFlowProblem {
    public static void main(String[] args) {
        ArrayList<RoadStops> stopsArrayList = new ArrayList<>();
        System.out.println("Bitte geben Sie alle Vekehrssystemstops ein. Sobald sie fertig sind mit der eingabe \"fertig\" und enter bestätigen");
        Scanner scanner = new Scanner(System.in);
        boolean giveMoreStops = true;
        boolean givesMoreWeightBetweenNodes = true;
        while (giveMoreStops) {
            if (scanner.hasNext()) {
                String roadStop = scanner.next();
                if(roadStop.equals("fertig")){
                    giveMoreStops = false;
                    stopsArrayList.get(stopsArrayList.size() - 1).setTrap(true);
                    break;
                }
                if (stopsArrayList.isEmpty()) {
                    RoadStops roadStops = new RoadStops(roadStop,true,false);
                    stopsArrayList.add(roadStops);
                    System.out.println("Das nächste Verkehrssystemstop");
                } else {
                    boolean houseExist = false;
                    for (RoadStops roadstopForControlOfDuplicate : stopsArrayList) {
                        if (roadstopForControlOfDuplicate.getName() == roadStop) {
                            System.out.println("Der Verkehrssystemstop existiert bereits");
                            houseExist = true;
                        }
                    }
                    if (!houseExist) {
                        RoadStops roadStops = new RoadStops(roadStop,false,false);
                        stopsArrayList.add(roadStops);
                        System.out.println("Das nächste Verkehrssystemstop");
                    }
                }
            }else{
                stopsArrayList.get(stopsArrayList.size() - 1).setTrap(true);
                giveMoreStops = false;
            }
        }
        RoadSystem system = new RoadSystem(stopsArrayList);

        System.out.println("Als nächstes braucht die Software noch die Kapazität und die Richtung von einem Verkehrssystemstop zum anderen");

        while (givesMoreWeightBetweenNodes){
            System.out.println("Der erste Stop bitte von dem man zum anderen Stop fahren kann");
            if(scanner.hasNext()){
                String firstRoadStop = scanner.next();
                String secondeRoadStop = null;
                int weight = 0;
                if(firstRoadStop.equals("fertig")){
                    givesMoreWeightBetweenNodes = false;
                    break;
                }
                System.out.println("Der zweit Stop bitte");
                if(scanner.hasNext()){
                     secondeRoadStop = scanner.next();
                }
                System.out.println("Und noch die Kapazität wie viele Autos fahren können");
                if(scanner.hasNextInt()){
                    weight = scanner.nextInt();
                }
               system.addWeightForEdgeInDirectedGraph(system.findRoadStopWithName(firstRoadStop),system.findRoadStopWithName(secondeRoadStop), weight);
            }
        }
        int index = 0;
        for (RoadStops roadstop:stopsArrayList) {
            System.out.println("Der Verkehrssystemstop " + roadstop.getRoadStopName() + " hat den index: " + index + " im Lösungsgraphen");
            index++;
        }
        TrafficFlowCalculator calculator = new TrafficFlowCalculator();
        system.printGraphOut(system.allCarsOfRoadSystem, calculator.calculateOptimalTrafficFlow(system));
    }
}
