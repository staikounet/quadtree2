/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadtree;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CAR
 */
public class QuadtreeTest {
    
    public QuadtreeTest() {
    }

    @Test
    public void addPointToUnchildedNodeWithLessThan4Points(){
        Node node = new Node(new Point(0,0), 3, 3);
        node.getPoints().add(new Point(1,1));
        node.getPoints().add(new Point(1,2));
        node.getPoints().add(new Point(2,1));
        Quadtree tree = new Quadtree();
        tree.setGrid(node);
        tree.addPoint(new Point(2,2));
        assertTrue(node.getNodes().isEmpty());
        assertEquals(node.getPoints().size(), 4);
    }
    
    @Test
    public void addMoreThan4Points(){
        Node node = new Node(new Point(0,0), 4, 4);
        node.getPoints().add(new Point(1,1));
        node.getPoints().add(new Point(1,3));
        node.getPoints().add(new Point(3,1));
        node.getPoints().add(new Point(3,2));
        Quadtree tree = new Quadtree();
        tree.setGrid(node);
        tree.addPoint(new Point(2,3));
        assertEquals(node.getNodes().size(), 4);
        assertEquals(node.getPoints().size(), 2);
        assertEquals(node.getNodes().get(0).getPoints().size(), 1);
        assertEquals(node.getNodes().get(1).getPoints().size(), 1);
        assertEquals(node.getNodes().get(2).getPoints().size(), 1);
        assertEquals(node.getNodes().get(3).getPoints().size(), 0);
    }
}
