
package tira.labyrinttiohjelma;

/**
 *
 * @author Henri
 * @param <T>
 */
public class Jono<T extends Node> {
    private int koko;
    private T[] jono;

    public Jono(T[] t) {
        koko = 0;
        this.jono = t;
    }
    
    
}
