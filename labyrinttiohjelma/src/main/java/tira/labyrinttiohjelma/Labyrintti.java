
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
    
    public Labyrintti(char[][] kuva) {
        this.kuva = kuva;
        etsiALkuLoppu();
    }
    
    public void etsiALkuLoppu() {
        boolean alkuLoyty = false;
        boolean loppuLoyty = false;
        for (int i = 0; i < kuva.length; i++) {
            for (int j = 0; j < kuva[0].length; j++) {
                char[] kuva1 = kuva[j];
                if (kuva[i][j] == '?') {
                    if (alkuLoyty) {
                        System.out.println("Monta alkua!");
                        return;
                    }
                    alkuX = i;
                    alkuY = j;
                    alkuLoyty = true;
                }
                if (kuva[i][j] == '!') {
                    if (loppuLoyty) {
                        System.out.println("Monta loppua!");
                        return;
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
        
    }

    public char[][] getKuva() {
        return kuva;
    }

    public int getAlkuX() {
        return alkuX;
    }

    public int getAlkuY() {
        return alkuY;
    }

    public int getLoppuX() {
        return loppuX;
    }

    public int getLoppuY() {
        return loppuY;
    }

}
