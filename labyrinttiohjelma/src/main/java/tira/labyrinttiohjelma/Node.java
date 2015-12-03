
package tira.labyrinttiohjelma;

/**
 *
 * SisÃ¤ltÃ¤Ã¤ solmun x ja y koordinaatit.
 */
public class Node implements Comparable<Node> {
    //x ja y ovat solmun koordinaatit.
    int x;
    int y;
    //Edellinen kertoo reitin mitä pitkin on tultu.
    Node edellinen;
    //gscore kertoo tämänhetkisen reitin pituuden (solmusta alkuun).
    int gScore;
    //fscore kertoo kertoo pituuden maalista solmuun, johon on lisätty gscore.
    int fScore;

    
    // Jos alan käyttyämään BufferedImage Node luokan voi muuttaa tarpeen mukaan pixeleitä varten.
    public Node(int x, int y, Node edellinen) {
        this.x = x;
        this.y = y;
        this.edellinen = edellinen;
        this.gScore = Integer.MAX_VALUE;
        this.fScore = Integer.MAX_VALUE;
    }
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.edellinen = null;
        this.gScore = Integer.MAX_VALUE;
        this.fScore = Integer.MAX_VALUE;
           
    }
    
    public void setPrev(Node n) {
        this.edellinen = n;
    }
    
    //Palauttaa reitin edellisen solmun.
    public Node prev() {
        return edellinen;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getfScore() {
        return fScore;
    }

    public void setfScore(Node maali) {
        //Eli pituus maaliin + reitin pituus
        this.fScore = Math.abs((x-maali.getX()) + (y-maali.getY())) + gScore;
    }

    public int getgScore() {
        return gScore;
    }

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
