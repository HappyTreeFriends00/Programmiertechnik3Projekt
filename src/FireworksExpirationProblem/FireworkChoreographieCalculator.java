package FireworksExpirationProblem;

import com.intellij.util.containers.Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FireworkChoreographieCalculator {

    private ArrayList<Firework> calculateExpirationOfFirework(ArrayList<Firework> fireworkArrayList, Firework startNode){
        Queue<Firework> queue = new Queue<>(fireworkArrayList.size());
        queue.addLast(startNode);
        ArrayList<Firework> traversedNode = new ArrayList<>();
        traversedNode.add(startNode);
        while (!queue.isEmpty()){
            Firework currentNode = queue.pullFirst();
            if(!traversedNode.contains(currentNode) | currentNode == startNode) {
                for (Firework firework : currentNode.getFollowingNodes()) {
                    queue.addLast(firework);
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
