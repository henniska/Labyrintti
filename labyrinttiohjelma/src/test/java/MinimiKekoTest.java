/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tira.labyrinttiohjelma.MinimiKeko;
import tira.labyrinttiohjelma.Node;

/**
 *
 * @author Henri
 */
public class MinimiKekoTest {
    
    /**
     *
     */
    public MinimiKekoTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void addTest1() {
        MinimiKeko<Node> keko = new MinimiKeko(new Node[10]);
        Node n = new Node(3, 7);
        keko.add(n);
        assertEquals(n, keko.peek());
        
    }
    
    /**
     *
     */
    @Test
    public void addTest2() {
        MinimiKeko<Node> keko = new MinimiKeko(new Node[10]);
        Node maali = new Node (0, 0);
        for (int i = 0; i < 5; i++) {
            Node a = new Node(3, i);
            a.setfScore(maali);
            keko.add(a);
        }
        
        assertEquals(new Node(3, 0), keko.peek());
        
    }
    
    /**
     *
     */
    @Test
    public void addTest3() {
        MinimiKeko<Node> keko = new MinimiKeko(new Node[150]);
        Node maali = new Node (0, 0);
        for (int i = 3; i < 15; i++) {
            for (int j = 3; j < 15; j++) {
                Node a = new Node(i, j);
                a.setfScore(maali);
                keko.add(a);
                
            }
            
        }
        
        assertEquals(new Node(3, 3), keko.peek());
        
    }
    
    /**
     *
     */
    @Test
    public void pollTest1() {
        MinimiKeko<Node> keko = new MinimiKeko(new Node[10]);
        Node n = new Node(3, 7);
        keko.add(n);
        assertEquals(n, keko.poll());
        
    }
    
    /**
     *
     */
    @Test
    public void pollTest2() {
        MinimiKeko<Node> keko = new MinimiKeko(new Node[10]);
        Node maali = new Node (0, 0);
        for (int i = 0; i < 5; i++) {
            Node a = new Node(3, i);
            a.setfScore(maali);
            keko.add(a);
        }
        
        assertEquals(new Node(3, 0), keko.poll());
        
    }
    
    /**
     *
     */
    @Test
    public void pollTest3() {
        MinimiKeko<Node> keko = new MinimiKeko(new Node[150]);
        Node maali = new Node (0, 0);
        for (int i = 3; i < 15; i++) {
            for (int j = 3; j < 15; j++) {
                Node a = new Node(i, j);
                a.setfScore(maali);
                keko.add(a);
                
            }
        }
        keko.poll();
        keko.poll();
        keko.poll();
        
        assertEquals(new Node(4, 4), keko.poll());
        
    }
    
    /**
     *
     */
    @Test
    public void pollTest4() {
        MinimiKeko<Node> keko = new MinimiKeko(new Node[10]);
        Node n = new Node(3, 7);
        keko.add(n);
        keko.poll();
        assertEquals(null, keko.poll());
        
    }
    
    /**
     *
     */
    @Test
    public void pieninTest1() {
        MinimiKeko<Node> keko = new MinimiKeko(new Node[10]);
        assertEquals(4, keko.pienin(4, 7, 5));
        
    }
    
    /**
     *
     */
    @Test
    public void pieninTest2() {
        MinimiKeko<Node> keko = new MinimiKeko(new Node[10]);
        assertEquals(0, keko.pienin(0, 0, 10000));
        
    }
}
