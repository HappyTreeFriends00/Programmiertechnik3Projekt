package Algorithmen.FireworksExpirationProblem;

import Algorithmen.Firework;
import Algorithmen.FireworkChoreography;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class FireworkChoreographyCalculatorTest {

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

        ArrayList<Firework> fireworkArrayList = new ArrayList<Firework>(Arrays.asList(raketeBlau,raketeGelb,raketeRot,frosch,vulkan,goldenFeuerring,wunderkerze,chinaBoeller));
        FireworkChoreography fireworkChoreography = new FireworkChoreography(fireworkArrayList);

        fireworkChoreography.addWeightForEdgeInUndirectedGraph(chinaBoeller,raketeGelb,4);
        fireworkChoreography.addWeightForEdgeInUndirectedGraph(chinaBoeller,raketeRot,2);
        fireworkChoreography.addWeightForEdgeInUndirectedGraph(chinaBoeller,wunderkerze,7);
        fireworkChoreography.addWeightForEdgeInUndirectedGraph(raketeRot,raketeGelb,1);
        fireworkChoreography.addWeightForEdgeInUndirectedGraph(raketeGelb,wunderkerze,1);
        fireworkChoreography.addWeightForEdgeInUndirectedGraph(wunderkerze,frosch,2);
        fireworkChoreography.addWeightForEdgeInUndirectedGraph(wunderkerze,goldenFeuerring,3);
        fireworkChoreography.addWeightForEdgeInUndirectedGraph(goldenFeuerring,vulkan,1);
        fireworkChoreography.addWeightForEdgeInUndirectedGraph(vulkan,raketeBlau,4);
        fireworkChoreography.addWeightForEdgeInUndirectedGraph(frosch,vulkan,3);
        fireworkChoreography.addWeightForEdgeInUndirectedGraph(frosch,raketeBlau,8);


        FireworkChoreographyCalculator fireworkChoreographyCalculator = new FireworkChoreographyCalculator();
        System.out.println(fireworkChoreographyCalculator.toStringExpirationOfFirework(chinaBoeller, fireworkChoreography));
        ArrayList<Firework> fireworkControlList = new ArrayList<>(Arrays.asList(chinaBoeller,raketeRot,raketeGelb,wunderkerze,frosch,goldenFeuerring,vulkan,raketeBlau));
        ArrayList<Firework> resultList = fireworkChoreographyCalculator.calculateExpirationOfFirework(chinaBoeller,fireworkChoreography).allFireworksOfChoreography;
        Assertions.assertEquals(fireworkControlList,resultList);

    }
}