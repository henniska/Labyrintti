/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.labyrinttiohjelma;

/**
 *
 * SisÃ¤ltÃ¤Ã¤ solmun x ja y koordinaatit.
 */
public class Node {
    int x;
    int y;
    //Edellinen kertoo reitin mitä pitkin on tultu.
    Node edellinen;
    
    // Jos alan käyttyämään BufferedImage Node luokan voi muuttaa tarpeen mukaan pixeleitä varten.
    public Node(int x, int y, Node edellinen) {
        this.x = x;
        this.y = y;
        this.edellinen = edellinen;
    }
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.edellinen = null;
    }
    
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
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
