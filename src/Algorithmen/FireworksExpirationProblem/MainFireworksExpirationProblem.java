package Algorithmen.FireworksExpirationProblem;

import Algorithmen.Firework;
import Algorithmen.FireworkChoreography;

import java.util.ArrayList;
import java.util.Scanner;

public class MainFireworksExpirationProblem {
    public static void main(String[] args) {
        ArrayList<Firework> fireworkArrayList = new ArrayList<>();
        System.out.println("Bitte geben Sie jedes Feuerwerkskörper ein. Beginnend mit dem ersten Feuewerkskörper der entzündet wird. \nSobald sie fertig sind mit der eingabe \"1\" und enter bestätigen");
        Scanner scanner = new Scanner(System.in);
        boolean giveMoreHouses = true;
        while (giveMoreHouses) {
            if(scanner.hasNextInt()){
                int zahl = scanner.nextInt();
                giveMoreHouses = false;
            }else {
                if(scanner.hasNext()) {
                    String firecrackerName = scanner.next();
                    Firework firecracker = new Firework(firecrackerName);
                    if (fireworkArrayList.isEmpty()) {
                        fireworkArrayList.add(firecracker);
                        System.out.println("Der nächste Feuerwerkskörper bitte");
                    } else {
                        boolean fireCrackerExist = false;
                        for (Firework firework : fireworkArrayList) {
                            if (firework.getFirecrackerName().equals(firecrackerName)) {
                                System.out.println("Der Feuerwerkskörper existiert bereits");
                                fireCrackerExist = true;
                            }
                        }
                        if (!fireCrackerExist) {
                            fireworkArrayList.add(firecracker);
                            System.out.println("Das nächste Feuerwerkskörper bitte");
                        }
                    }
                }
            }
        }
        boolean givesMore = true;
        FireworkChoreography choreography = new FireworkChoreography(fireworkArrayList);
        boolean givesMoreWeightBetweenNodes = true;
        System.out.println("jetzt geben Sie bitte für jeden Feuerwerkskörper einen dranhängenden Feuerwerkskörper und die Länge der Zündschnurr als ganze Zahl an.");
        Scanner scanner1 = new Scanner(System.in);
        while (givesMoreWeightBetweenNodes) {
            System.out.println("Zunächst der erste Feuerwerkskörper");
            if (scanner1.hasNext()) {
                try {
                    String firecrackerName1 = scanner1.next();
                    if(firecrackerName1.equals("fertig")){
                        givesMoreWeightBetweenNodes = false;
                        break;
                    }
                    System.out.println("Jetzt der Zweite");
                    String firecrackername2 = scanner1.next();
                    System.out.println("Und die Länge der Zündschnur");
                    int weight = scanner1.nextInt();
                    choreography.addWeightForEdgeInUndirectedGraph(choreography.findFirecrackerWithName(firecrackerName1), choreography.findFirecrackerWithName(firecrackername2), weight);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Einer der Feuerwerkskörper existiert nicht. Bitte versuchen sie es erneut");
                    givesMoreWeightBetweenNodes = false;
                } catch (Exception e) {
                    System.out.println("Es wurden falsche Daten eingegeben. Vorgang wird abgebrochen und ausgewertet");
                }
            } else {
                givesMoreWeightBetweenNodes = false;
            }
            System.out.println("\nSobald Sie fertig sind mit der Eingabe \"fertig\" und enter bestätigen");
        }
        FireworkChoreographyCalculator calculator = new FireworkChoreographyCalculator();
        System.out.println(calculator.toStringExpirationOfFirework(choreography.allFireworksOfChoreography.get(0), choreography));
    }
}
