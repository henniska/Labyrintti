
package tira.labyrinttiohjelma;

/**
 * Minimikeon toteutus
 * 
 * @param <T>
 */
public class MinimiKeko<T extends Node> {
    private int keonKoko;
    private T[] keko;

    /**
     * Konstruktori saa parametrina haluamansa taulukon.
     * 
     * @param t
     */
    public MinimiKeko(T[] t) {
        this.keonKoko = 0;
        this.keko = t;
    } 

    /**
     * Puun vanhemman indeksi
     * 
     * @param i
     * @return
     */
        public int vanhempi(int i) {
        if (i == 0) {
            return -1;
        }
        return ((i+1)/2)-1;
    }

    /**
     * Puun vasemman lapsen indeksi
     *  
     * @param i
     * @return
     */
        public int vasen(int i) {
        if ((2*(i+1)-1) >= keonKoko) {
            return -1;
        }
        return 2*(i+1)-1;
    }

    /**
     * Puun oikean lapsen indeksi
     * 
     * @param i
     * @return
     */
        public int oikea(int i) {
        if ((2*(i+1)) >= keonKoko) {
            return -1;
        }
        return (2*(i+1));
    }
    
    /**
     * Järjestää keon pienuusjärjestykseen
     * 
     * @param i
     */
    public void kekoJarjestys(int i) {
        int vasenIndeksi = vasen(i);
        int oikeaIndeksi = oikea(i);
        int pieninArvo;
        
        if (oikeaIndeksi != -1) {
            if (pienin(vasenIndeksi, oikeaIndeksi, i) == oikeaIndeksi) {
                pieninArvo = oikeaIndeksi;
            } else if (pienin(vasenIndeksi, oikeaIndeksi, i) == vasenIndeksi) {
                pieninArvo = vasenIndeksi;
            } else {
                pieninArvo = i;
            }
            if (pieninArvo == i) {
                return;
            }
            vaihdaPaikkaa(i, pieninArvo);
            kekoJarjestys(pieninArvo);
            
        } else if (vasenIndeksi != -1 && pienin(i, vasenIndeksi, i) == i){
            vaihdaPaikkaa(i, vasenIndeksi);
        }
        
        
    }
    
    /**
     * Lisää alkion kekoon
     * 
     * @param node
     */
    public void add(T node){
        if (node == null) {
            return;
        }
        keonKoko++;
        keko[keonKoko-1] = node;
        int i = keonKoko -1;
        if (i == 0) {
            return;
        }
        while (i > 0 && keko[vanhempi(i)].compareTo(keko[i]) >= 0) {
            vaihdaPaikkaa(vanhempi(i), i);
            i = vanhempi(i);
        }
    }
        
    /**
     * Poistaa ensimmäisen alkion ja palauttaa sen arvon
     * 
     * @return
     */
    public T poll() {
        
        if  (keonKoko == 0) {
            return null;
        }
        T pieninArvo = keko[0];
        keko[0] = keko[keonKoko-1];
        keko[keonKoko-1] = null;
        keonKoko--;
        kekoJarjestys(0);
        return pieninArvo;
        
    }
    
    /**
     * Palauttaa ensimmäisen alkion arvon
     * 
     * @return
     */
    public T peek() {
        return keko[0];
    }
    
    /**
     * Vaihtaa kahden alkion paikkaa keossa
     * 
     * @param x
     * @param y
     */
    public void vaihdaPaikkaa(int x, int y) {
        T a = keko[x];
        keko[x] = keko[y];
        keko[y] = a;
    }
    
    /**
     * Palauttaa pienimmän alkion annetuista
     * 
     * @param vasen
     * @param oikea
     * @param index
     * @return
     */
    public int pienin(int vasen, int oikea, int index) {
        if (keko[vasen] != null && keko[oikea] != null) {
            if (keko[vasen].compareTo(keko[oikea]) <= 0) {
                if (keko[index].compareTo(keko[vasen]) <= 0) {
                    return index;
                }
                return vasen;
            } else {
                if (keko[index].compareTo(keko[oikea]) <= 0) {
                    return index;
                }
                return oikea;
            }
        } else if (keko[vasen] != null && keko[oikea] == null) {
            if (keko[index].compareTo(keko[vasen]) <= 0) {
                return index;
            }
            return vasen;
        } else if (keko[vasen] == null && keko[oikea] != null) {
            if (keko[index].compareTo(keko[oikea]) <= 0) {
                return index;
            }
            return oikea;
        }
        return index;
    }
    
    /**
     * Palauttaa true jos alkio on keossa
     * 
     * @param node
     * @return
     */
        
    public boolean contains(T node) {
        for (int i = 0; i < keko.length; i++) {
            if (keko[i] == node) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Palauttaa true jos keko on tyhjä
     * 
     * @return
     */
    public boolean isEmpty() {
        if (keonKoko == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Tulostaa keon alkiot
     */
    public void tulostaKeko() {
        System.out.println("");
        for (int i = 0; i < keko.length; i++) {
            System.out.print(keko[i] + " ");;
            
        }
        System.out.println("");
    }
}
