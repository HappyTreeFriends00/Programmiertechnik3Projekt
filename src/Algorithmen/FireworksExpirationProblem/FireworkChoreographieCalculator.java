package Algorithmen.FireworksExpirationProblem;

import sun.misc.Queue;

import java.util.ArrayList;

public class FireworkChoreographieCalculator {

    private ArrayList<Firework> calculateExpirationOfFirework(ArrayList<Firework> fireworkArrayList, Firework startNode){
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
                for (Firework firework : currentNode.getFollowingNodes()) {
                    queue.enqueue(firework);
                }
                if (currentNode != startNode) {
                    traversedNode.add(currentNode);
                }
            }
        }
        return traversedNode;
    }

    public String toStringExpirationOfFirework(ArrayList<Firework> fireworkArrayList, Firework startNode){
        StringBuilder stringBuilder = new StringBuilder();
        int order = 1;
        for (Firework firework:calculateExpirationOfFirework(fireworkArrayList, startNode)) {
            stringBuilder.append(order + ": " + firework.getFirecrackerName() + "\n");
            order++;
        }
        return stringBuilder.toString();
    }
}
