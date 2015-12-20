
package tira.labyrinttiohjelma;

/**
 *
 * Kantaluokka ratkaisijoille;
 */

public class Ratkaisija {
    Labyrintti kopio; 
    final Labyrintti laby;
    Node maali;
    
    /**
     * Luo uuden ratkaisijan
     * 
     * @param laby
     */
    public Ratkaisija(Labyrintti laby) {
        this.laby = laby;
        this.kopio = teeKopioNykyisesta();
    }

    /**
     * Etsii lyhimmÃ¤n reitin labyrintin loppuun ja palauttaa sen matkan.
     * 
     * @return
     */
    public int lyhin() {
        return -1;
    }
    

    /**
     * Katsoo onko reitti laillinen
     * 
     * @param x
     * @param y
     * @return
     */
    public boolean reitinSelvitys(int x, int y) {

        if (x < 0 || x >= kopio.getKuva().length || y < 0 || y >= kopio.getKuva()[0].length) {
            return false;
        }
        if (kopio.getKuva()[x][y] == '#' || kopio.getKuva()[x][y] == '?') {
            return false;
        }

        return true;
    }

    /**
     * Koska lyhin()-metodini joutuu muokkaamaan taulukkoa, 
     * tarvitaan siitÃ¤ aina kopio siltÃ¤ varalta, ettÃ¤ 
     * joudutaan tekemÃ¤Ã¤n monta lyhin() kutsua.
     * 
     * @return
     */
    public Labyrintti teeKopioNykyisesta() {
        int a = laby.getKuva().length;
        int b = laby.getKuva()[0].length;
        char[][] lb = laby.getKuva();
        char[][] matriisiKopio = new char[a][b];
        
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                matriisiKopio[i][j] = lb[i][j];
            }
        }
        return new Labyrintti(matriisiKopio);
    }
    
    /**
     * Palauttaa maalin solmun
     * 
     * @return
     */
    public Node getMaali() {
        return maali;
    }
    

    /**
     * Tulostaa reitin pituuden, reitin ja ruudukon
     */
    public void tulosta() {
        String nimi = this.getClass().getSimpleName();
        System.out.println(nimi);
        System.out.println("Lyhin = " + lyhin());
        System.out.println("");
        System.out.println("Reitti (x, y):");
        Node node = getMaali();
        boolean temp = true;
        while (node != null) {
            System.out.println("");
            System.out.print(node.getX() + ", " + node.getY());
            if (temp) {
                System.out.print(" loppu");
                temp = false;
            }
            node = node.prev();
        }
        System.out.print(" alku");
        System.out.println("");
        
        node = getMaali();
        node = node.prev();
        while (node.prev() != null) {
            kopio.getKuva()[node.getX()][node.getY()] = 'X';
            node = node.prev();
        }
        System.out.println("");
        for (int i = 0; i < kopio.getKuva().length; i++) {
            System.out.println("");
            for (int j = 0; j < kopio.getKuva()[0].length; j++) {
                System.out.print(kopio.getKuva()[i][j] + " ");
                
            }
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");   
        kopio = teeKopioNykyisesta();
    }

}
