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
}
