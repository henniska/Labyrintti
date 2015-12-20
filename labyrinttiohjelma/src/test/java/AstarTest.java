
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tira.labyrinttiohjelma.Astar;
import tira.labyrinttiohjelma.Labyrintti;

/**
 *
 * @author Henri
 */
public class AstarTest {
    
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
    public void lyhinTest1() {
        Labyrintti lb = new Labyrintti(LabyrinttiTest.test);
        Astar ast = new Astar(lb);
        assertEquals(18, ast.lyhin());
    }
    
    /**
     *
     */
    @Test
    public void lyhinTest2() {
        Labyrintti lb = new Labyrintti(LabyrinttiTest.test1);
        Astar ast = new Astar(lb);
        assertEquals(17, ast.lyhin());
    }
    
    /**
     *
     */
    @Test
    public void lyhinTest3() {
        Labyrintti lb = new Labyrintti(LabyrinttiTest.test2);
        Astar ast = new Astar(lb);
        assertEquals(25, ast.lyhin());
    }
    
    /**
     *
     */
    @Test
    public void lyhinTest4() {
        Labyrintti lb = new Labyrintti(LabyrinttiTest.test3);
        Astar ast = new Astar(lb);
        assertEquals(15, ast.lyhin());
    }
    
    /**
     *
     */
    @Test
    public void lyhinTest5() {
        Labyrintti lb = new Labyrintti(LabyrinttiTest.test4);
        Astar ast = new Astar(lb);
        assertEquals(3, ast.lyhin());
    }
   
}
