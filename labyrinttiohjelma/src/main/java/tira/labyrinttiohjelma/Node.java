
package tira.labyrinttiohjelma;

/**
 *
 * SisÃ¤ltÃ¤Ã¤ solmun x ja y koordinaatit.
 */
public class Node implements Comparable<Node> {
    /**
     * x ja y ovat solmun koordinaatit
     */
    int x;
    int y;
    /**
     * Edellinen kertoo reitin mitä pitkin on tultu
     */
    Node edellinen;
    /**
     * gscore kertoo tämänhetkisen reitin pituuden (solmusta alkuun)
     */
    int gScore;
    /**
     * fscore kertoo kertoo pituuden maalista solmuun, johon on lisätty gscore
     */
    int fScore;

    /**
     * Luo uuden solmun jolla on edellinen.
     * 
     * @param x
     * @param y
     * @param edellinen
     */
        public Node(int x, int y, Node edellinen) {
        this.x = x;
        this.y = y;
        this.edellinen = edellinen;
        this.gScore = Integer.MAX_VALUE;
        this.fScore = Integer.MAX_VALUE;
    }
    
    /**
     * Luo uuden solmun, jolla ei ole edellistä
     * 
     * @param x
     * @param y
     */
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.edellinen = null;
        this.gScore = Integer.MAX_VALUE;
        this.fScore = Integer.MAX_VALUE;
           
    }
    
    /**
     * Asettaa edellisen arvon
     * 
     * @param n
     */
    public void setPrev(Node n) {
        this.edellinen = n;
    }

    /**
     * Palauttaa reitin edellisen solmun
     * 
     * @return
     */
        public Node prev() {
        return edellinen;
    }

    /**
     * Palauttaa solmun x-koordinaatin
     * 
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Asettaa solmun x-koordinaatin
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Palauttaa solmun y-koordinaatin
     * 
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Asettaa solmun y-koordinaatin
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Palauttaa solmun fscore
     * 
     * @return
     */
    public int getfScore() {
        return fScore;
    }

    /**
     * Asettaa solmun fscore
     * 
     * @param maali
     */
    public void setfScore(Node maali) {
        //Eli pituus maaliin + reitin pituus
        this.fScore = Math.abs((x-maali.getX())) + Math.abs(y-maali.getY()) + gScore;
    }

    /**
     * Palauttaa solmun gscore
     * 
     * @return
     */
    public int getgScore() {
        return gScore;
    }

    /**
     * Asettaa solmun gscore
     * 
     * @param gScore
     */
    public void setgScore(int gScore) {
        this.gScore = gScore;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.x;
        hash = 37 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (this.x != other.getX()) {
            return false;
        }
        if (this.y != other.getY()) {
            return false;
        }
        return true;
    }
    
    //Somuja verrataan fscore:n mukaan, koska siitä tietää kumpi on 'lähempänä' maalia.
    @Override
    public int compareTo(Node o) {
        if (this.fScore < o.getfScore()) {
            return -1;
        } else if (this.fScore > o.getfScore()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    
}
