
import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tira.labyrinttiohjelma.BFS;
import tira.labyrinttiohjelma.Labyrintti;
import tira.labyrinttiohjelma.*;

/**
 *
 * @author Henri
 */
public class BfsTest {
    private BFS bf;
    private Labyrintti lb;
    private Jono q;
    
    public BfsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lb = new Labyrintti(test);
        bf = new BFS(lb);
        q = new Jono<>();
    }
    
    @After
    public void tearDown() {
    }

    
    
    @Test
    public void lyhinTest() {
        assertEquals(25, bf.lyhin());
    }
    
    @Test
    public void reittiTest() {
        assertEquals(false, bf.reitti(0, 0, null, q));
    }
    
    @Test
    public void reitinSelvitysTest() {
        assertEquals(false, bf.reitinSelvitys(-1, 0));
    }
    
    @Test
    public void teeKopioNykyisestaTest() {
        Assert.assertArrayEquals(lb.getKuva(), bf.teeKopioNykyisesta().getKuva());
    }
    
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

