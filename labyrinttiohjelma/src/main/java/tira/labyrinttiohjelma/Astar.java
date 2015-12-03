
package tira.labyrinttiohjelma;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * A* algoritmi;
 */
public class Astar extends Ratkaisija {
    private PriorityQueue<Node> keko;

    public Astar(Labyrintti laby) {
        super(laby);
    }
    
    //Palauttaa lyhimmän reitin pituuden
    @Override
    public int lyhin() {
        this.keko = new PriorityQueue<>();
        maali = new Node(kopio.getLoppuX(), kopio.getLoppuY());
        int n = kopio.getAlkuX();
        int m = kopio.getAlkuY();
        Node alku = new Node(n, m);
        alku.setgScore(0);
        alku.setfScore(maali);
        keko.add(alku);
        
        while(!keko.isEmpty()) {
            Node s = keko.poll();
            int x = s.getX();
            int y = s.getY();
            
            if (reitti(x+1, y, s)) return maali.getgScore();
            if (reitti(x-1, y, s)) return maali.getgScore();
            if (reitti(x, y+1, s)) return maali.getgScore();
            if (reitti(x, y-1, s)) return maali.getgScore();
        }
            
        System.out.println("Loppua ei löytynyt");
        this.kopio = teeKopioNykyisesta();
        return -1;
    }
    
    //Tarkistaa reitin
    public boolean reitti(int x, int y, Node edel) {
        if (reitinSelvitys(x, y)) {
            Node m = new Node(x, y);
            int gscore = edel.getgScore()+1;

            if (!keko.contains(m)) {
                m.setgScore(gscore);
                m.setfScore(maali);
                m.setPrev(edel);
                keko.add(m);
                
            } else {
                //Jos naapuri (m) on jo keossa niin täytyy katsoa onko sen reitti suurempi kuin nykyinen reitti. Jos on, niin se lisätään nykyiseen, pienempään reittiin.
                Iterator ite = keko.iterator();
                while (ite.hasNext()) {
                    Node node = (Node) ite.next();
                    if (node.equals(m)) {
                        if (gscore < node.getgScore()) {
                            System.out.println(node);
                            node.setgScore(gscore);
                            node.setfScore(maali);
                            node.setPrev(edel);
                            m = node;
                        }
                    }
                }
            }

            if (kopio.getKuva()[x][y] != '!') {
                kopio.getKuva()[x][y] = '#';
            } else {
                this.kopio = teeKopioNykyisesta();
                maali = m;
                return true;
            }
        }
        return false;
    }
    
    
}
