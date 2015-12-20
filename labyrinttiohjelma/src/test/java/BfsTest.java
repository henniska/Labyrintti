
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tira.labyrinttiohjelma.BFS;
import tira.labyrinttiohjelma.Labyrintti;

/**
 *
 * @author Henri
 */
public class BfsTest {
    private BFS bf;
    private Labyrintti lb;
    
    /**
     *
     */
    public BfsTest() {
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
        lb = new Labyrintti(LabyrinttiTest.test);
        bf = new BFS(lb);
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
        assertEquals(18, bf.lyhin());
    }
    
    /**
     *
     */
    @Test
    public void reittiTest() {
        assertEquals(false, bf.reitti(0, 0, null));
    }
    
    /**
     *
     */
    @Test
    public void reitinSelvitysTest1() {
        assertEquals(false, bf.reitinSelvitys(-1, 0));
    }
    
    /**
     *
     */
    @Test
    public void reitinSelvitysTest2() {
        assertEquals(true, bf.reitinSelvitys(5, 1));
    }
    
    /**
     *
     */
    @Test
    public void reitinSelvitysTest3() {
        assertEquals(false, bf.reitinSelvitys(0, 0));
    }
    
    /**
     *
     */
    @Test
    public void reitinSelvitysTest4() {
        assertEquals(true, bf.reitinSelvitys(11, 5));
    }
    
    /**
     *
     */
    @Test
    public void teeKopioNykyisestaTest() {
        Assert.assertArrayEquals(lb.getKuva(), bf.teeKopioNykyisesta().getKuva());
    }
}

