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
        Labyrintti lb = new Labyrintti(esim2);
        BFS bf = new BFS(lb);
        System.out.println("Lyhin = " + bf.lyhin());
        System.out.println("");
        System.out.println("Reitti:");
        Node node = bf.getMaali();
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
        
        node = bf.getMaali();
        node = node.prev();
        while (node.prev() != null) {
            esim2[node.getX()][node.getY()] = 'X';
            node = node.prev();
        }
        for (int i = 0; i < esim2.length; i++) {
            System.out.println("");
            for (int j = 0; j < esim2[0].length; j++) {
                System.out.print(esim2[i][j] + " ");
                
            }
        }
        System.out.println("");
    }
    
    // Myöhemmin käytän BufferedImage jos aikaa
    static char[][] esim = new char[][] {
        {'#', '#', '#', '#', '#', '#', '#', '#', '!', '#'},
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
    
    static char[][] esim2 = new char[][] {
        {'#', '#', '#', '#', '#', '#', '#', '#', '!', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#'},
        {'#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#'},
        {'#', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#'},
        {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', '#', '#', ' ', '#', '#', ' ', '#'},
        {'#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', '#', ' ', '#', '#', '#', '#'},
        {'#', '#', '#', ' ', '#', ' ', '#', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#'},
        {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
        {'#', '#', '#', '#', '#', '?', '#', '#', '#', '#'}};
    
}
