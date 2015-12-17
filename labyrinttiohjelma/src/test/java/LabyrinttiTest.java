
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tira.labyrinttiohjelma.Labyrintti;

/**
 *
 * @author Henri
 */
public class LabyrinttiTest {
    private Labyrintti lb;
    
    /**
     *
     */
    public LabyrinttiTest() {
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
        lb.etsiALkuLoppu();
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
    public void etsiALkuLoppuTest1() {
        assertEquals(12, lb.getAlkuX());
        assertEquals(5, lb.getAlkuY());
    }
    
    /**
     *
     */
    @Test
    public void etsiALkuLoppuTest2() {
        assertEquals(0, lb.getLoppuX());
        assertEquals(1, lb.getLoppuY());
    }

    
    private static char[][] test = new char[][] {
        {'#', '!', '#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#'},
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
