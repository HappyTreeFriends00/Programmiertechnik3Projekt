package Algorithmen.FireworksExpirationProblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FireworkChoreographieCalculatorTest {

    @Test
    void calculateExpirationOfFirework() {
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
        raketeGelb.addFollowingFirecracker(raketeRot);
        raketeGelb.addFollowingFirecracker(chinaBoeller);
        wunderkerze.addFollowingFirecracker(goldenFeuerring);
        wunderkerze.addFollowingFirecracker(frosch);
        wunderkerze.addFollowingFirecracker(chinaBoeller);
        wunderkerze.addFollowingFirecracker(raketeGelb);
        goldenFeuerring.addFollowingFirecracker(vulkan);
        goldenFeuerring.addFollowingFirecracker(wunderkerze);
        vulkan.addFollowingFirecracker(raketeBlau);
        vulkan.addFollowingFirecracker(frosch);
        vulkan.addFollowingFirecracker(goldenFeuerring);
        raketeBlau.addFollowingFirecracker(frosch);
        raketeBlau.addFollowingFirecracker(vulkan);
        frosch.addFollowingFirecracker(vulkan);
        frosch.addFollowingFirecracker(raketeBlau);
        frosch.addFollowingFirecracker(wunderkerze);

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
        ArrayList<Firework> controlArray = new ArrayList<>(Arrays.asList(chinaBoeller,raketeRot,raketeGelb,wunderkerze,goldenFeuerring,frosch,vulkan,raketeBlau));

        Assertions.assertEquals(controlArray, calculator.calculateExpirationOfFirework(fireworks, chinaBoeller));
    }
}