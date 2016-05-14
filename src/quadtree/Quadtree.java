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
                if (node.getPoints().size() > 4) {
                    int w = node.getWidth() / 2;
                    int h = node.getHeight() / 2;
                    Node child1 = new Node(new Point(node.getOrigin().getX(), node.getOrigin().getY()), w, h);
                    Node child2 = new Node(new Point(node.getOrigin().getX(), node.getOrigin().getY()).translate(w, 0), w, h);
                    Node child3 = new Node(new Point(node.getOrigin().getX(), node.getOrigin().getY()).translate(0, h), w, h);
                    Node child4 = new Node(new Point(node.getOrigin().getX(), node.getOrigin().getY()).translate(w, h), w, h);
                    child1.setDeepness(node.getDeepness() + 1);
                    child2.setDeepness(node.getDeepness() + 1);
                    child3.setDeepness(node.getDeepness() + 1);
                    child4.setDeepness(node.getDeepness() + 1);
                    if (node.getDeepness() + 1 > maxdeep) {
                        maxdeep = node.getDeepness() + 1;
                    }
                    node.getNodes().add(child1);
                    node.getNodes().add(child2);
                    node.getNodes().add(child3);
                    node.getNodes().add(child4);
                    ArrayList<Point> tmp = new ArrayList<>();
                    tmp.addAll(node.getPoints());
                    node.getPoints().clear();
                    for (Point childPoint : tmp) {
                        addPoint(node, childPoint);
                    }
                }
            } else {
                int isIn = pointIsInHowMuchChildNodes(point, node);
                if (isIn < 2) {
                    for (Node childNode : node.getNodes()) {
                        addPoint(childNode, point);
                    }
                } else {
                    node.getPoints().add(point);
                }
            }
        }
    }

    private int pointIsInHowMuchChildNodes(Point point, Node node) {
        int isIn = 0;
        for (Node childNode : node.getNodes()) {
            if (childNode.contains(point)) {
                isIn++;
            }
        }
        return isIn;
    }

}
