/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.labyrinttiohjelma;

/**
 *
 * @author Henri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Labyrintti lb = new Labyrintti(esim);
        BFS bf = new BFS(lb);
        System.out.println("Lyhin = " + bf.lyhin());

    }
    
    // Myöhemmin käytän BufferedImage jos aikaa
    static char[][] esim = new char[][] {
        {'#', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
        {'#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#'},
        {'#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', '#', '#', '#', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', '#'},
        {'#', ' ', '#', '#', '#', ' ', '#', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', ' ', ' ', '#', '#', ' ', '#'},
        {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
        {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
        {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
        {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
        {'#', '#', '#', '#', '#', '?', '#', '#', '#', '#'}};
    
}
