package Algorithmen;

import Algorithmen.RoadConstructionProblem.RoadConstructionCostCalculator;

import java.util.ArrayList;
import java.util.Collections;

public class Firework implements IObjectGetName, Comparable<Firework>{
    private ArrayList<Firework> followingNodes;
    private String firecrackerName;
    private boolean visited = false;
    private int key = Integer.MAX_VALUE;

    public Firework(String firecrackerName){
        this.followingNodes = new ArrayList<>();
        this.firecrackerName = firecrackerName;
    }

    public ArrayList<Firework> getFollowingNodes() {
        return followingNodes;
    }

    public String getFirecrackerName() {
        return firecrackerName;
    }

    public Firework findFireworkWithName(String firecrackerName, ArrayList<Firework> fireworkArrayList){
        for (Firework firecracker:fireworkArrayList) {
            if(firecracker.getFirecrackerName().equals(firecrackerName)){
                return firecracker;
            }
        }
        throw new IllegalArgumentException("keine Feuerwerkskörper mit diesem Namen vorhanden");
    }

    public void addFollowingFirecracker(Firework... followingFirework){
        Collections.addAll(followingNodes, followingFirework);
    }

    public void removeFollowingFirecracker(Firework firework){
        this.followingNodes.remove(firework);
    }

    @Override
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public boolean isVisited() {
        return this.visited;
    }

    @Override
    public String getName() {
        return this.firecrackerName;
    }

    @Override
    public boolean isTrap() {
        return false;
    }

    @Override
    public boolean isSource() {
        return false;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public int compareTo(Firework firework) {
        return Integer.compare(this.key, firework.key);
    }
}
