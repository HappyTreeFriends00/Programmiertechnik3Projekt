package Algorithmen.FireworksExpirationProblem;

import Algorithmen.Firework;
import Algorithmen.FireworkChoreography;
import Algorithmen.RoadConstructionProblem.RoadConstructionCostCalculator;

import java.util.*;

public class FireworkChoreographyCalculator {

    //Dijkstra
    public FireworkChoreography calculateExpirationOfFirework(Firework startNode, FireworkChoreography fireworkChoreography){
        PriorityQueue<Firework> unvisitedNodes = new PriorityQueue<>();
        startNode.setKey(0);
        for (Firework firework : fireworkChoreography.allFireworksOfChoreography) {
            unvisitedNodes.add(firework);
        }
        Firework currentNode = unvisitedNodes.remove();
        while (!unvisitedNodes.isEmpty()) {
            for (int i = 0; i < fireworkChoreography.edge.length; i++) {
                if (fireworkChoreography.edge[fireworkChoreography.allFireworksOfChoreography.indexOf(currentNode)][i] != 0 &&
                        fireworkChoreography.edge[fireworkChoreography.allFireworksOfChoreography.indexOf(currentNode)][i] + currentNode.getKey() < fireworkChoreography.allFireworksOfChoreography.get(i).getKey()
                        && !fireworkChoreography.allFireworksOfChoreography.get(i).isVisited()) {
                    fireworkChoreography.allFireworksOfChoreography.get(i).setKey(fireworkChoreography.edge[fireworkChoreography.allFireworksOfChoreography.indexOf(currentNode)][i] + currentNode.getKey());
                }
            }
            currentNode.setVisited(true);
            //Wird gemacht damit die PriorityQueue sich selbst sortiert
            PriorityQueue<Firework> priorityQueue1 = new PriorityQueue<>();
            for(Firework node: unvisitedNodes){
                priorityQueue1.add(node);
            }
            unvisitedNodes = priorityQueue1;
            if(!unvisitedNodes.isEmpty()) {
                currentNode = unvisitedNodes.remove();
            }
        }
        return fireworkChoreography;
    }

    public String toStringExpirationOfFirework(Firework startNode, FireworkChoreography fireworkChoreography){
        ArrayList<Firework> list = calculateExpirationOfFirework(startNode, fireworkChoreography).allFireworksOfChoreography;
        Collections.sort(list);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Zuerst entzündet der Feuerwerkskörper ");
        int order = 1;
        for (Firework firework:list) {
            stringBuilder.append(order).append(": ").append(firework.getFirecrackerName()).append("\n");
            stringBuilder.append("Danach ");
            order++;
        }
        return stringBuilder.toString();
    }

    //Breitensuche nicht ausreichend
    /*public ArrayList<Firework> calculateExpirationOfFirework(Firework startNode){
        Queue<Firework> queue = new Queue<>();
        queue.enqueue(startNode);
        ArrayList<Firework> traversedNode = new ArrayList<>();
        traversedNode.add(startNode);
        while (!queue.isEmpty()){
            Firework currentNode = null;
            try {
                currentNode = queue.dequeue();
            }catch (InterruptedException e){
                System.out.println(e.toString());
            }
            if(!traversedNode.contains(currentNode) | currentNode == startNode) {
                assert currentNode != null;
                for (Firework firework : currentNode.getFollowingNodes()) {
                    queue.enqueue(firework);
                    firework.removeFollowingFirecracker(currentNode);
                }
                if (currentNode != startNode) {
                    traversedNode.add(currentNode);
                }
            }
        }
        return traversedNode;
    }*/
}
