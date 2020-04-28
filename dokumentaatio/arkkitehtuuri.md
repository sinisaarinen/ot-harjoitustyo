# Arkkitehtuurikuvaus

## Rakenne

Sovellus noudattaa kolmiosaista kerrosarkkitehtuuria:

![](kaavio_rakenne.png)

Pakkaus _minesweeperapp.ui_ sisältää käyttöliittymän, _minesweeperapp.logic_ sovelluslogiikan ja _minesweeperapp.model_ miinakenttää sekä yksittäistä ruutua kuvaavat luokat.

## Käyttöliittymä

Käyttöliittymä sisältää kolme erillistä näkymää:
- kirjautuminen
- tason valitseminen
- pelinäkymä

Kaikki näkymät on toteutettu omana Scene-olionaan, ja niistä on kerrallaan yksi näkyvissä eli sijoitettuna stageen.

Käyttöliittymä on rakennettu luokassa _minesweeperapp.ui.MinesweeperUi_. Käyttöliittymä on eriytetty sovelluslogiikasta, ja se kutsuu sovelluslogiikan metodeja.

## Sovelluslogiikka

Pelin toiminnollisuuden luovat luokat Minefield ja Tile, ja luokka ApplicationLogic yhdistää Minefield- ja Tile-luokkien toiminnallisuudet pelin logiikaksi.

Sovelluksen osien suhdetta kuvaava luokka/pakkauskaavio:

![](kaavio_alustava.jpg)

### Päätoiminnallisuudet

Sovelluksen toimintalogiikan päätoiminnollisuuksien sekvenssikaaviot:

#### Kirjautuminen

![](sekvenssikaavio_kirjautuminen.png)

#### Uuden pelin aloittaminen

Huom.! Uuden pelin aloittamista ei ole vielä toteutettu - uusi peli käynnistyy tällä hetkellä, kun sovellukseen kirjaudutaan sisään. Toiminto lisätään lähitulevaisuudessa.

![](sekvenssikaavio_uusipeli.png)
