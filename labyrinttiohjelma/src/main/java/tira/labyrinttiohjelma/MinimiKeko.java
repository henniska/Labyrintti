
package tira.labyrinttiohjelma;

/**
 *
 * Minimikeon toteutus;
 */
public class MinimiKeko<T> {
    private int koko;
    private T[] keko;
    private int eka;

    public MinimiKeko(int koko) {
        this.koko = koko;
        this.keko = (T[]) new Object[koko];
    } 
    
    //Jos kokoa ei mainita, se saa perusarvon 10.
    public MinimiKeko() {
        this.koko = 10;
        this.keko = (T[]) new Object[10];  
    }
    
    public int poistaPienin() {
        return 0;
    }
}
