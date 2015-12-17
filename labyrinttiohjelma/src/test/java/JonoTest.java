
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tira.labyrinttiohjelma.Jono;
import tira.labyrinttiohjelma.Node;

/**
 *
 * @author Henri
 */
public class JonoTest {
    
    /**
     *
     */
    public JonoTest() {
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
    public void nodeTest() {
        Node a = new Node(3, 5);
        Jono<Node> q = new Jono<>();
        q.add(a);
        Node b = q.poll();
        assertEquals("(3, 5)", b.toString());
    }
    
    /**
     *
     */
    @Test
    public void isEmptyTest() {
        Jono<Integer> q = new Jono<>();
        q.add(5);
        q.poll();
        assertEquals(true, q.isEmpty());
    }
    
    /**
     *
     */
    @Test
    public void onkoTaynnaTest1() {
        Jono<Integer> q = new Jono<>(3);
        q.add(5);
        q.add(5);
        assertEquals(true, q.onkoTaynna());
    }
    
    /**
     *
     */
    @Test
    public void onkoTaynnaTest2() {
        Jono<Integer> q = new Jono<>(3);
        q.add(5);
        q.add(5);
        q.poll();
        q.add(5);
        assertEquals(true, q.onkoTaynna());
    }
    
    /**
     *
     */
    @Test
    public void pollTest() {
        Jono<Integer> q = new Jono<>();
        q.add(5);
        assertEquals((Integer)5, q.poll());
    }
    
    /**
     *
     */
    @Test
    public void addTest1() {
        Jono<Integer> q = new Jono<>();
        q.add(5);
        q.add(7);
        q.add(5);
        q.add(3);
        assertEquals(4, q.jononPituus());
    }
    
    /**
     *
     */
    @Test
    public void addTest2() {
        Jono<Integer> q = new Jono<>(3);
        q.add(5);
        q.add(7);
        q.poll();
        q.add(3);
        q.add(4);
        q.poll();
        assertEquals(2, q.jononPituus());
    }
    
    /**
     *
     */
    @Test
    public void kasvatakokoaTest() {
        Jono<Integer> q = new Jono<>(7);
        q.kasvataKokoa();
        assertEquals(14, q.getKoko());
    }
}
