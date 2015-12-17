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
        int koonRaja = 2500;
        if (args.length > 0) {
            try {
                koonRaja = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argumentti" + args[0] + " pitää olla numero.");
                System.exit(1);
            }
        }
        
        Labyrintti lb = new Labyrintti(esim3);
        System.out.println("ESIMERKKI");
        System.out.println("Aloitus = '?");
        System.out.println("Maali = '!");
        System.out.println("Este = '#");
        for (int i = 0; i < esim3.length; i++) {
            System.out.println("");
            for (int j = 0; j < esim3[0].length; j++) {
                System.out.print(esim3[i][j] + " ");
                
            }
        }
        System.out.println("");
        System.out.println("");
        Astar as = new Astar(lb);
        as.tulosta();
        System.out.println("");
        System.out.println("Aika lyhimmän reitin löytämiseen. Koko = taulukon pituus");
        System.out.print("  KOKO      ");
        System.out.print("BFS(ms)   ");
        System.out.print("ASTAR(ms)");
        System.out.println("");
        for (int i = 2; i < koonRaja; i=i*2) {
            Labyrintti l = new Labyrintti(luoLaby(i));
            BFS b = new BFS(l);
            Astar a = new Astar(l);
            
            
            if (i < 10) {
                System.out.print("    " + i);
            } else if (i<100) {
                System.out.print("   " + i);
            } else if (i<1000){
                System.out.print("  " + i);
            } else {
                System.out.print(" " + i);
            }
            
            
            long keskiarvo = 0;
            for (int j = 0; j < 10; j++) {
                long aikaAlussa = System.currentTimeMillis();  
                b.lyhin();
                long aikaLopussa = System.currentTimeMillis();  
                keskiarvo += (aikaLopussa - aikaAlussa);
            }
            keskiarvo = keskiarvo/10;
            if (keskiarvo < 10) {
                System.out.print("        " + keskiarvo);
            } else if (keskiarvo<100) {
                System.out.print("       " + keskiarvo);
            } else if (keskiarvo<1000){
                System.out.print("      " + keskiarvo);
            } else {
                System.out.print("     " + keskiarvo);
            }
            
            
            keskiarvo = 0;
            for (int j = 0; j < 10; j++) {
                long aikaAlussa = System.currentTimeMillis();  
                a.lyhin();
                long aikaLopussa = System.currentTimeMillis();  
                keskiarvo += (aikaLopussa - aikaAlussa);
            }
            keskiarvo = keskiarvo/10;
            if (keskiarvo < 10) {
                System.out.print("          " + keskiarvo);
            } else if (keskiarvo<100) {
                System.out.print("         " + keskiarvo);
            } else if (keskiarvo<1000){
                System.out.print("        " + keskiarvo);
            } else {
                System.out.print("       " + keskiarvo);
            }
            System.out.println("");
        }
    }
    
    /**
     * Luo uuden 'tyhjän' taulukon halutulla koolla.
     * 
     * @param koko
     * @return
     */
    public static char[][] luoLaby(int koko) {
        char[][] laby = new char[koko][koko];
        if (koko == 0 || koko == 1) {
            return null;
        } else if (koko==2) {
            laby[0][0] = ' ';
            laby[0][1] = '!';
            laby[1][0] = '?';
            laby[1][1] = ' ';
        } else if (koko == 3) {
            for (int i = 0; i < laby.length; i++) {
                for (int j = 0; j < laby[0].length; j++) {
                    if (i==0 && j==1) {
                        laby[i][j] = '!';
                    } else if (i==2 && j==1) {
                        laby[i][j] = '?';
                    } else {
                        laby[i][j] = ' ';
                    }
                }
            }
        } else {
            for (int i = 0; i < laby.length; i++) {
                for (int j = 0; j < laby[0].length; j++) {
                    if (i==0 || i==koko-1 || j==0 || j==koko-1) {
                        laby[i][j] = '#';
                    } else if (i==1 && j==koko/2){
                        laby[i][j] = '!';
                    } else if (i==koko-2 && j==koko/2) {
                        laby[i][j] = '?';
                    } else {
                        laby[i][j] = ' ';
                    }
                }
            }
        }
        return laby;
    }
    
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
    
    static char[][] esim3 = new char[][] {
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', '!', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', '#', '#', '#', '#', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', '#'},
        {'#', '#', '#', '#', ' ', ' ', ' ', '#', '#', '#'},
        {'#', '#', '#', '#', ' ', '?', ' ', '#', '#', '#'}};
    
}
