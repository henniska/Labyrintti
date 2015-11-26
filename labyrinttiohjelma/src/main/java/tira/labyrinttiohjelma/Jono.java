
package tira.labyrinttiohjelma;

import java.lang.reflect.Array;

/**
 *
 * @author Henri
 * @param <T>
 */
public class Jono<T> {
    private int koko;
    private T[] jono;
    //Eka ja vika kertovat jonon pään ja hännän paikan.
    private int eka;
    private int vika;

    public Jono(int koko) {
        this.koko = koko;
        this.jono = (T[]) new Object[koko];
    } 
    
    //Jos kokoa ei mainita, se saa perusarvon 10.
    public Jono() {
        this.koko = 10;
        this.jono = (T[]) new Object[10];  
    }
    
    //Palauttaa ensimmäisen jonossa olevan muuttujan ja 'pienentää' jonoa.
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T poistettu = jono[eka];
        eka++;
        //Jos tullaan arrayn loppuun niin jonon pää siirtyy taas arrayn alkuun.
        if (eka == koko) {
            eka = 0;
        }
        return poistettu;
    }
    
    //Lisää muuttujan jonon perälle
    public void add(T t) {
        if (onkoTaynna()) {
            kasvataKokoa();
        }
        jono[vika] = t;
        vika++;
        if (vika == koko) {
            vika = 0;
        }

    }
    
    //Palauttaa jonon pituden eikä arrayn kokoa.
    public int jononPituus() {
        if (eka == vika) {
            return 0;
        }
        if (eka < vika) {
            return vika - eka;
        }
        return koko - eka + vika;
    }
    
    
    public boolean isEmpty() {
        return eka == vika;
    }
    
    
    public boolean onkoTaynna() {
        int seuraava = vika +1;
        if (seuraava == koko) {
            seuraava = 0;
        }
        return eka == seuraava;
            
    }

    //Array kopioidaan uuteen, kaksi kertaa suurempaan taulukkoon.
    public void kasvataKokoa() {
        if (eka == vika) {
            this.jono = (T[]) new Object[koko*2];
            koko = koko*2;
            return;
        }
        T[] uusi = (T[]) new Object[koko*2];

        int vikanPaikka = 0;
        if (eka < vika) {
            for (int i = 0; i < koko; i++){
                if ((i+eka) == koko || (i+eka) == vika) {
                    break;
                }
                uusi[i] = jono[i + eka];
                vikanPaikka++;
            }
        } else {
            for (int i = 0; i < koko; i++){
                if ((i+eka) == koko) {
                    break;
                }
                uusi[i] = jono[i + eka];
                vikanPaikka++;
            }
            for (int i = 0; i < vika; i++){
                uusi[vikanPaikka] = jono[i];
                vikanPaikka++;
            }
        }
        
        this.jono = uusi;
        koko = koko*2;
        vika = vikanPaikka;
        eka = 0;

    }
    
    public int getKoko() {
        return koko;
    }
    
    
}
