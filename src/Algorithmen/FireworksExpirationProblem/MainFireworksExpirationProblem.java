package Algorithmen.FireworksExpirationProblem;

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
                            if (firework.getFirecrackerName() == firecrackerName) {
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
        try {
            for (Firework firework : fireworkArrayList) {
                System.out.println("Bitte geben Sie für " + firework.getFirecrackerName() + " nacheinander alle dranhängenden Feuerwerkskörper ein");
                System.out.println("Der nächste Feuerwerkskörper bitte");
                givesMore = true;
                while (givesMore) {
                    if(scanner.hasNext()) {
                        String firecrackerName = scanner.next();
                        if(firecrackerName.equals("f")){
                            givesMore = false;
                            break;
                        }
                        firework.addFollowingFirecracker(firework.findFireworkWithName(firecrackerName, fireworkArrayList));
                        System.out.println("falls sie fertig sind bitte mit f bestätigen");
                        System.out.println("Der nächste Feuerwerkskörper bitte");
                    }
                }
            }
        }catch (NullPointerException e){
            System.out.println("Sie haben keine Feuerwerkskörper eingegeben");
        }
        FireworkChoreographieCalculator calculator = new FireworkChoreographieCalculator();
        System.out.println(calculator.toStringExpirationOfFirework(fireworkArrayList.get(0)));
    }
}
