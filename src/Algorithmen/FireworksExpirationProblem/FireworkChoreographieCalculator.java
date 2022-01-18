package Algorithmen.FireworksExpirationProblem;

import sun.misc.Queue;

import java.util.ArrayList;

public class FireworkChoreographieCalculator {

    public ArrayList<Firework> calculateExpirationOfFirework(Firework startNode){
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
    }

    public String toStringExpirationOfFirework(Firework startNode){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Zuerst entzündet der Feuerwerkskörper ");
        int order = 1;
        for (Firework firework:calculateExpirationOfFirework(startNode)) {
            stringBuilder.append(order).append(": ").append(firework.getFirecrackerName()).append("\n");
            stringBuilder.append("Danach ");
            order++;
        }
        return stringBuilder.toString();
    }
}
