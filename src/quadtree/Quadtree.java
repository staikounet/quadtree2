package quadtree;

import java.util.ArrayList;
import java.util.Random;

public class Quadtree {

    private Node grid;
    private static int maxdeep = 0;

    public int getMaxdeep() {
        return maxdeep;
    }

    public Node getGrid() {
        return grid;
    }
    
    public void setGrid(Node grid) {
        this.grid = grid;
    }
    
    public Quadtree(){
        
    }

    public Quadtree(int size, int numberOfPoints) {
        grid = new Node(new Point(0, 0), size, size);
        grid.setDeepness(0);
        Random rnd = new Random();
        for (int i = 0; i < numberOfPoints; i++) {
            addPoint(new Point(rnd.nextInt(size), rnd.nextInt(size)));
        }
    }

    public void addPoint(Point p) {
        addPoint(grid, p);
    }

    private void addPoint(Node node, Point point) {
        if (node.contains(point)) {
            if (node.getNodes().isEmpty()) {
                node.getPoints().add(point);                    
            } else {
                
            }
        }
    }
}
