package Algorithmen;

import java.util.ArrayList;

public class FireworkChoreography extends AbstractGraph<Firework> {
    public ArrayList<Firework> allFireworksOfChoreography = vertexList;
    public int[][] fuse = edge;

    public FireworkChoreography(ArrayList<Firework> objects) {
        super(objects);
    }

    @Override
    public IObjectGetName getSource() {
        for (Firework firework: allFireworksOfChoreography) {
            if(firework.isSource()){
                return firework;
            }
        }
        return null;
    }

    @Override
    public Firework getTrap() {
        for (Firework firework: allFireworksOfChoreography) {
            if(firework.isTrap()){
                return firework;
            }
        }
        return null;
    }

    public Firework findFirecrackerWithName(String name){
        for (Firework firework: vertexList) {
            if(firework.getFirecrackerName().equals(name)){
                return firework;
            }
        }
        throw new IllegalArgumentException("Es scheint kein haus mit dieser hausnummer zu existieren");
    }
}
