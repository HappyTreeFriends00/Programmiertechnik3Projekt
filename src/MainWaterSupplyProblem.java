import java.util.ArrayList;

public class MainWaterSupplyProblem {
    public static void main(String[] args) {
        House wasserwerk = new House(1,"wasserwerk",true, false);
        House thoma = new House(2,"thoma",false, false);
        House dogan = new House(3,"dogan",false, false);
        House adler = new House(4,"adler",false, false);
        House ilona = new House(5,"ilona",false, false);
        House club = new House(6,"club",false, false);
        House bogart = new House(7,"bogar",false, false);
        House supermarkt = new House(8,"supermarkt",false,false);
        House holler = new House(9,"holler",false, true);
        House[] houseArray = {wasserwerk, thoma, dogan, adler, ilona, club, holler,supermarkt, bogart};
        ArrayList<House> houses = new ArrayList<>();
        for (int i = 0; i < houseArray.length; i++) {
            houses.add(houseArray[i]);
        }
        WaterSupplySystem waterSupplySystem = new WaterSupplySystem(houses);
        waterSupplySystem.addWeightForEdgeInDirectedGraph(wasserwerk,thoma,15);
        waterSupplySystem.addWeightForEdgeInDirectedGraph(wasserwerk,ilona,6);
        waterSupplySystem.addWeightForEdgeInDirectedGraph(wasserwerk,club,12);
        waterSupplySystem.addWeightForEdgeInDirectedGraph(dogan,adler,5);
        waterSupplySystem.addWeightForEdgeInDirectedGraph(dogan,bogart,6);
        waterSupplySystem.addWeightForEdgeInDirectedGraph(ilona,bogart,3);
        waterSupplySystem.addWeightForEdgeInDirectedGraph(ilona,holler,1);
        waterSupplySystem.addWeightForEdgeInDirectedGraph(club,adler,5);
        waterSupplySystem.addWeightForEdgeInDirectedGraph(club,holler,5);
        waterSupplySystem.addWeightForEdgeInDirectedGraph(adler,supermarkt,10);
        waterSupplySystem.addWeightForEdgeInDirectedGraph(bogart,supermarkt,10);
        waterSupplySystem.addWeightForEdgeInDirectedGraph(holler,supermarkt,7);
        waterSupplySystem.addWeightForEdgeInDirectedGraph(thoma,dogan,8);

        waterSupplySystem.printGraphOut(houses, waterSupplySystem.edge);
        System.out.println(waterSupplySystem.getListOfAllHousesWithTheirSurnames());
        WaterSupplyMaxFlowCalculator calculator = new WaterSupplyMaxFlowCalculator();
        waterSupplySystem.printGraphOut(houses,calculator.calculateMaxFlowForWaterSupplySystem(waterSupplySystem));

    }
}
