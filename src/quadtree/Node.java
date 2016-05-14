package quadtree;

import java.util.ArrayList;

public class Node {

    private final Point origin;
    private final int width;
    private final int height;
    private final ArrayList<Point> points;
    private final ArrayList<Node> nodes;
    private int deepness;

    public int getDeepness() {
        return deepness;
    }

    public void setDeepness(int deepness) {
        this.deepness = deepness;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public Point getOrigin() {
        return origin;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Node(Point o, int w, int h) {
        this.origin = o;
        this.width = w;
        this.height = h;
        nodes = new ArrayList<>();
        points = new ArrayList<>();
    }

    public boolean contains(Point p) {
        int px = p.getX();
        int py = p.getY();
        return px >= origin.getX() && py >= origin.getY() && px <= origin.getX() + width && py <= origin.getY() + height;
    }
}
