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
        int newDeep = grid.addPoint(p);
        maxdeep = Math.max(maxdeep, newDeep);
    }

    public ArrayList<Point> getClosests(int x, int y) {
        Node node = getNodeWherePointIs(x, y);
        ArrayList<Point> result = new ArrayList<>();
        Point point = new Point(x, y);
        if (node.getNodes().isEmpty()) {
            result.addAll(node.getPointsBut(point));
        } else {
            result = node.getDescendantPoints(point);
        }
        return result;
    }
    
    ArrayList<Point> getRandomPoints(int i) {
        ArrayList<Point> result = new ArrayList<>();
        ArrayList<Point> allPoints = grid.getDescendantPoints(null);
        for (int j = 0; j < i; j++) {
            result.add(allPoints.get(new Random().nextInt(allPoints.size())));
        }
        return result;
    }

    public Node getNodeWherePointIs(int x, int y) {
        return Quadtree.this.getNodeWherePointIs(new Point(x, y));
    }

    public Node getNodeWherePointIs(Point p) {
        return grid.getDescendantNodeWherePointIs(p);
    }

    public void printInConsole() {
        grid.printInConsole();
    }

    Object getDeepness(Point point2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
