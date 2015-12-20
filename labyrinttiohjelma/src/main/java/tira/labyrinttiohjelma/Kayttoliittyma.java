
package tira.labyrinttiohjelma;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


/**
 * Tekstikäyttöliittymä
 * 
 * @author Henri
 */
public class Kayttoliittyma {
    private Scanner lukija;
    private String tiedostonSijainti = "";
    
    /**
     *
     */
    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
        
    }
    
    /**
     * Ohjelman tekstikäyttöliittymä
     * 
     * @throws IOException
     */
    public void run() throws IOException {
        System.out.println("-LABYRINTIN RATKAISU OHJELMA-");
        System.out.println("");
        System.out.println("Labyrintin vaatimukset:");
        System.out.println("(1) TÃ¤ytyy olla char matriisi");
        System.out.println("(2) TÃ¤ytyy olla suorakumio");
        System.out.println("(3) TÃ¤ytyy sisÃ¤ltÃ¤Ã¤ yhden maalin ja yhden aloituksen");
        System.out.println("(4) Maali = '!'");
        System.out.println("(5) Aloitus = '?'");
        System.out.println("(6) Este = '#'");
        System.out.println("(7) Vapaa ruutu = ' '");
        System.out.println("");
        
        System.out.println("Haluatko suorituskykytestauksen tai labyrintin ratkaisun?");
        System.out.println("(Kirjoita 'suo' tai 'laby'): ");
        String vastaus = lukija.nextLine();
        if (vastaus.equals("suo")) {
            System.out.println("Anna koko (taulukon pituus raja): ");
            int koonRaja = 0;
            try {
                koonRaja = Integer.parseInt(lukija.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("PitÃ¤Ã¤ olla numero.");
                System.exit(1);
            }

            System.out.println("");
            System.out.println("Aika lyhimmÃ¤n reitin lÃ¶ytÃ¤miseen.");
            System.out.print("  KOKO      ");
            System.out.print("BFS(ms)   ");
            System.out.print("ASTAR(ms)");
            System.out.println("");
            for (int i = 2; i < koonRaja; i=i*2) {
                
                Labyrintti l;
                Astar a;
                while (true) {
                    l = new Labyrintti(luoLaby(i));
                    a = new Astar(l);
                    if (a.lyhin() == 0) {
                        continue;
                    }
                    break;
                }
                BFS b = new BFS(l);

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
            
            
        } else if (vastaus.equals("laby")) {
            System.out.println("Esimerkki tiedostot: (resources/esim1.txt), (resources/esim2.txt), resources/esim3.txt)");
            System.out.println("Anna tiedoston polku: ");
            tiedostonSijainti = lukija.nextLine();
            char[][] c = rakennaLabyrintti();
            System.out.println("");
            System.out.println("AlkuperÃ¤inen:");
            for (int i = 0; i < c.length; i++) {
                System.out.println("");
                for (int j = 0; j < c[0].length; j++) {
                    System.out.print(c[i][j] + " ");
                }
            }
            System.out.println("");
            Labyrintti lbt = new Labyrintti(c);
            Astar ast = new Astar(lbt);
            System.out.println("");
            System.out.println("Ratkaisu:");
            if (ast.lyhin() != 0) {
                ast.tulosta();
            } else {
                System.out.println("Loppuun ei pÃ¤Ã¤sty");
            }

        } else {
            System.out.println("Komentoa ei tunnistettu");
        }
        
        
    }
    
    /**
     * Avaa Tiedoston ja palauttaa sen sisällön
     * 
     * @return
     * @throws IOException
     */
    public String[] avaaTiedosto() throws IOException{
        FileReader fr = null;
        try {
            fr = new FileReader(tiedostonSijainti);
        
        } catch(FileNotFoundException e) {
            System.out.println("Tiedostoa " + tiedostonSijainti + " ei löytynyt.");
            System.exit(1);
        }
         
        String[] teksti;
        try (BufferedReader bf = new BufferedReader(fr)) {
            int rivienMaara = tiedostonRivienMaara();
            teksti = new String[rivienMaara];
            for (int i = 0; i < teksti.length; i++) {
                teksti[i] = bf.readLine();
                
            }
        }
        return teksti;
    }
    
    /**
     * Palauttaa ttiedoston rivien määrän
     * 
     * @return
     * @throws IOException
     */
    public int tiedostonRivienMaara() throws IOException{
        FileReader f = new FileReader(tiedostonSijainti);
        BufferedReader b = new BufferedReader(f);
        String rivi;
        int rivienMaara = 0;
        
        while ((rivi = b.readLine()) != null) {
            rivienMaara++;
        }
        b.close();
        return rivienMaara;
    }
    
    /**
     * Rakentaa String[] taulukon, char[][] taulukoksi
     * 
     * @return
     * @throws IOException
     */
    public char[][] rakennaLabyrintti() throws IOException{
        String[] tekstiRiveina = avaaTiedosto();
        int leveys = tekstiRiveina[0].length();
        char[][] laby = new char[tekstiRiveina.length][leveys];
        for (int i = 0; i < tekstiRiveina.length; i++) {
            char[] rivi = tekstiRiveina[i].toCharArray();
            if (leveys != tekstiRiveina[i].length()) {
                System.out.println("Ei ole suorakulmio");
                System.exit(1);
            }
            for (int j = 0; j < rivi.length; j++) {
                laby[i][j] = rivi[j];
                if (rivi[j] != '!' && rivi[j] != '?' && rivi[j] != '#' && rivi[j] != ' ') {
                    System.out.println("Ei ole labyrintti");
                    System.exit(1);
                }
            }
        }
        return laby;
    }
    
    /**
     * Luo uuden random taulukon halutulla koolla.
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
            //Random esteiden lisäys
            Random r = new Random();
            for (int i = 0; i < ((koko*koko)/5)-3; i++) {
                while(true) {
                    int x = r.nextInt(koko);
                    int y = r.nextInt(koko);
                    if (laby[x][y] == '#' || laby[x][y] == '!' || laby[x][y] == '?') {
                        continue;
                    }
                    laby[x][y] = '#';
                    break;
                }
            }
        }
        return laby;
    }
}
