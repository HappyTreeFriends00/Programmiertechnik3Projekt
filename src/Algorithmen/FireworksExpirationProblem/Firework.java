package Algorithmen.FireworksExpirationProblem;

import java.util.ArrayList;
import java.util.Collections;

public class Firework {
    private ArrayList<Firework> followingNodes;
    private String firecrackerName;

    public Firework( String firecrackerName){
        this.followingNodes = new ArrayList<>();
        this.firecrackerName = firecrackerName;
    }

    public ArrayList<Firework> getFollowingNodes() {
        return followingNodes;
    }

    public String getFirecrackerName() {
        return firecrackerName;
    }

    public void addFollowingFirecracker(Firework... followingFirework){
        Collections.addAll(followingNodes, followingFirework);
    }
}
