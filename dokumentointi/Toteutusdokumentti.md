##Toteutusdokumentti

##Rakenne
Ohjelmaan Main luokassa käynnistetään tekstikäyttöliittymä, jossa voi halutessaan ratkaista jokin haluttu labyrintti (annettu teksti tiedostossa) tai suorittaa labyrintin ratkaisu algoritimien suorituskykytestausta. Suorituskyky testauksessa verrataan BFS ja Astar algoritmien suorituskykyä kun ne ratkaisevat random labyrinttejä, jotka kasvavat koossa. Ohjelmaan kuuluu kantaluokka Ratkaisija, josta labyrintin ratkaisu algoritmit perivät niiden kantametodit. Nämä algoritmit myös käyttävät Node (solmu) luokkaa ja jono-ja prioriteettijono tietorakennetta.
##Saavutetut aika-ja tilavaativuudet
Suorituskykytestauksessa kävi ilmi, että molempien algoritmien aikavaativuudet kasvavat lineaarisesti labyrintin ruutuihin nähden. Eli niiden aikavaativuudet ovat O(n) missä n on ruutujen määrä. A* algoritmi ei kyennyt O(nlog(n)) vaativuuteen, mikä mainittiin lähteessä. Tämä tarkoittaa, että omaa A* algoritmiani voisi vielä parantaa.
##Suorituskyky- ja O-analyysivertailu
Huomasin, että BFS:n ja A*algoritmin suorituskyvyt olivat aika samanlaiset, jos labyrinteissä oli paljon esteitä. Melkein tyhjissä labyrinteissä A*star oli selvästi nopeampi.
##Puutteet ja parannukset
Puutteina on graaffisen käyttöliittymän puuttuminen ja labyrintin yksinomaisuus. Yksinomaisuudella tarkoitan, että labyrintilla on vain yksi implementaatio, joka on ruudukko. Parannukset olisivat siis graaffinen käyttöliittymä ja lisää labyrintin implementaatioita. A*star voisi hioa, jotta aikavaativuudesta saisi O(nlog(n)).
##Lähteet
[A* algoritmi Wikipedia](https://en.wikipedia.org/wiki/A*_search_algorithm)
