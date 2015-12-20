
package tira.labyrinttiohjelma;

/**
 *
 * Labyrintin toteutus;
 */
public class Labyrintti {
    private char[][] kuva;
    private int alkuX;
    private int alkuY;
    private int loppuX;
    private int loppuY;
    
    /**
     * Konstruktorissa etsitään labyintin alku ja loppu.
     * 
     * @param kuva
     */
    public Labyrintti(char[][] kuva) {
        this.kuva = kuva;
        etsiALkuLoppu();
    }
    
    /**
     * Etsitään alku ja loppu
     * 
     */
    public void etsiALkuLoppu() {
        // Booleanit siltä varalta jos on monta alkua ja loppua.
        boolean alkuLoyty = false;
        boolean loppuLoyty = false;
        for (int i = 0; i < kuva.length; i++) {
            for (int j = 0; j < kuva[0].length; j++) {
//                char[] kuva1 = kuva[j];
                if (kuva[i][j] == '?') {
                    if (alkuLoyty) {
                        System.out.println("Monta alkua!");
                        System.exit(1);
                    }
                    alkuX = i;
                    alkuY = j;
                    alkuLoyty = true;
                }
                if (kuva[i][j] == '!') {
                    if (loppuLoyty) {
                        System.out.println("Monta loppua!");
                        System.exit(1);
                    } 
                    loppuX = i;
                    loppuY = j;
                    loppuLoyty = true;
                }
            } 
        }
        if (alkuLoyty && loppuLoyty) {
            return;
        }
        if (alkuLoyty) {
            System.out.println("Ei loppua");
        } else {
            System.out.println("Ei alkua");
        }
        System.exit(1);
    }

    /**
     * Palauttaa taulukon toteutuksen.
     * 
     * @return
     */
    public char[][] getKuva() {
        return kuva;
    }

    /**
     * Palauttaa alun x-kooridinaatin.
     * 
     * @return
     */
    public int getAlkuX() {
        return alkuX;
    }

    /**
     * Palauttaa alun y-kooridinaatin.
     * 
     * @return
     */
    public int getAlkuY() {
        return alkuY;
    }

    /**
     * Palauttaa lopun x-kooridinaatin.
     * 
     * @return
     */
    public int getLoppuX() {
        return loppuX;
    }

    /**
     * Palauttaa lopun y-kooridinaatin.
     * 
     * @return
     */
    public int getLoppuY() {
        return loppuY;
    }

}
