
package tira.labyrinttiohjelma;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * Breadth-First seach algoritmi;
 */
public class BFS {
    
    private Labyrintti kopio; // Teen paremmin?
    private final Labyrintti laby;
    // Merkkaaja Node kertoo kun uusi 'aalto' tai sykli alkaa jonossa, milloin voi kasvattaa matkan pituutta.
    private Node merkkaaja;
    private boolean uusiSykli = false;
    
    
    public BFS (Labyrintti laby) {
        this.laby = laby;
        this.kopio = teeKopioNykyisesta();
        
    }
    
    // Etsii lyhimmän reitin labyrintin loppuun ja palauttaa sen matkan.
    public int lyhin() {
        Queue<Node> q = new ArrayDeque<>();
        int n = kopio.getAlkuX();
        int m = kopio.getAlkuY();
        q.add(new Node(n, m));
        merkkaaja = new Node(n, m);
        kopio.getKuva()[n][m] = '#';
        int matka = 0;
        while (!q.isEmpty()) {
            Node s = q.poll();
            int x = s.getX();
            int y = s.getY();
            
            if (merkkaaja != null) {
                if (s.getX() == merkkaaja.getX() && s.getY() == merkkaaja.getY()) {
                    uusiSykli = true;
                    merkkaaja = null;
                    matka++;
                }
            }
            if (reitti(x+1, y, q)) return matka;
            if (reitti(x-1, y, q)) return matka;
            if (reitti(x, y+1, q)) return matka;
            if (reitti(x, y-1, q)) return matka;

        }
        System.out.println("Loppua ei löytynyt");
        this.kopio = teeKopioNykyisesta();
        return -1;
    }
    
    // Palauttaa true jos loppu löytyy.
    public boolean reitti(int x, int y, Queue q) {
        if (reitinSelvitys(x, y)) {
            q.add(new Node(x, y));
            if (uusiSykli) {
                merkkaaja = new Node(x, y);
                uusiSykli = false;
            }
            if (kopio.getKuva()[x][y] != '!') {
                kopio.getKuva()[x][y] = '#';
            } else {
                this.kopio = teeKopioNykyisesta();
                return true;
            }
        }
        return false;
    }
    
    // Katsoo onko reitti laillinen
    public boolean reitinSelvitys(int x, int y) {

        if (x < 0 || x >= kopio.getKuva().length || y < 0 || y >= kopio.getKuva()[0].length) {
            return false;
        }
        if (kopio.getKuva()[x][y] == '#') {
            return false;
        }

        return true;
    }
    
    
    // Koska lyhin() metodini joutuu muokkaamaan taulukkoa, tarvitaan siitä aina kopio siltä varalta, että joudutaan tekemään monta lyhin() kutsua.
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
    
}
