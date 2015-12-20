
package tira.labyrinttiohjelma;

/**
 * A* algoritmi
 * 
 * @author Henri
 */
public class Astar extends Ratkaisija {
    private MinimiKeko<Node> keko;

    /**
     *
     * @param laby
     */
    public Astar(Labyrintti laby) {
        super(laby);
    }
    
    /**
     * Palauttaa lyhimmän reitin pituuden
     * 
     * @return
     */
    @Override
    public int lyhin() {
        this.keko = new MinimiKeko(new Node[laby.getKuva().length*laby.getKuva().length]);
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
            
            if (reitti(x-1, y, s)) return maali.getgScore();
            if (reitti(x+1, y, s)) return maali.getgScore();
            if (reitti(x, y+1, s)) return maali.getgScore();
            if (reitti(x, y-1, s)) return maali.getgScore();
        }
        this.kopio = teeKopioNykyisesta();
        return 0;
    }

    /**
     * Tarkistaa reitin
     * 
     * @param x
     * @param y
     * @param edel
     * @return
     */
    public boolean reitti(int x, int y, Node edel) {
        if (reitinSelvitys(x, y)) {
            Node m = new Node(x, y);
            int gscore = edel.getgScore()+1;

            m.setgScore(gscore);
            m.setfScore(maali);
            m.setPrev(edel);
            keko.add(m);

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
