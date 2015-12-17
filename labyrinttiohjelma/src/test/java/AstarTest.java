
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tira.labyrinttiohjelma.Astar;
import tira.labyrinttiohjelma.Labyrintti;
import tira.labyrinttiohjelma.Node;

/**
 *
 * @author Henri
 */
public class AstarTest {
    private Astar as;
    private Labyrintti lb;
    
    /**
     *
     */
    public AstarTest() {
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
        lb = new Labyrintti(test);
        as = new Astar(lb);
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
    public void lyhinTest() {
        assertEquals(25, as.lyhin());
    
    }
    
//    @Test
//    public void reittiTest() {
//        Node n = new Node(0, 8);
//        n.setgScore(0);
//        assertEquals(true, as.reitti(0, 8, new Node(0, 8)));
//    }
    
    
    
    
    private static char[][] test = new char[][] {
        {'#', '#', '#', '#', '#', '#', '#', '#', '!', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#'},
        {'#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#'},
        {'#', ' ', '#', ' ', '#', '#', ' ', ' ', '#', '#'},
        {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', '#', '#', ' ', '#', '#', ' ', '#'},
        {'#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#'},
        {'#', '#', '#', ' ', '#', ' ', '#', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#'},
        {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
        {'#', '#', '#', '#', '#', '?', '#', '#', '#', '#'}};
}
