package Algorithmen.FireworksExpirationProblem;

import java.util.ArrayList;

public class MainFireworksExpirationProblem {
    public static void main(String[] args) {
        Firework raketeBlau = new Firework("Blaue Rakete");
        Firework raketeGelb = new Firework("Gelbe Rakete");
        Firework raketeRot = new Firework("Rote Rakete");
        Firework frosch = new Firework("Frosch");
        Firework vulkan = new Firework("Vulkan");
        Firework goldenFeuerring = new Firework("golden Feuerring");
        Firework wunderkerze = new Firework("Wunderkerze");
        Firework chinaBoeller = new Firework("China Böller");
        chinaBoeller.addFollowingFirecracker(raketeRot);
        chinaBoeller.addFollowingFirecracker(raketeGelb);
        chinaBoeller.addFollowingFirecracker(wunderkerze);
        raketeRot.addFollowingFirecracker(raketeGelb);
        raketeGelb.addFollowingFirecracker(wunderkerze);
        wunderkerze.addFollowingFirecracker(goldenFeuerring);
        wunderkerze.addFollowingFirecracker(frosch);
        goldenFeuerring.addFollowingFirecracker(vulkan);
        vulkan.addFollowingFirecracker(raketeBlau);
        vulkan.addFollowingFirecracker(frosch);
        raketeBlau.addFollowingFirecracker(frosch);
        frosch.addFollowingFirecracker(vulkan);
        frosch.addFollowingFirecracker(raketeBlau);

        ArrayList<Firework> fireworks = new ArrayList<>();
        fireworks.add(raketeBlau);
        fireworks.add(raketeGelb);
        fireworks.add(raketeRot);
        fireworks.add(frosch);
        fireworks.add(vulkan);
        fireworks.add(goldenFeuerring);
        fireworks.add(wunderkerze);
        fireworks.add(chinaBoeller);

        FireworkChoreographieCalculator calculator = new FireworkChoreographieCalculator();
        System.out.println(calculator.toStringExpirationOfFirework(fireworks,chinaBoeller));
    }
}
