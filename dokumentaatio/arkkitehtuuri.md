# Arkkitehtuurikuvaus

## Rakenne

Sovellus noudattaa kolmiosaista kerrosarkkitehtuuria:

![](kaavio_rakenne.png)

Pakkaus _minesweeperapp.ui_ sisältää käyttöliittymän, _minesweeperapp.logic_ sovelluslogiikan ja _minesweeperapp.model_ miinakenttää sekä yksittäistä ruutua kuvaavat luokat.

## Sovelluslogiikka

Sovelluksen osien suhdetta kuvaava luokka/pakkauskaavio:

![](kaavio_alustava.jpg)

### Päätoiminnallisuudet

Sovelluksen toimintalogiikan päätoiminnollisuuksien sekvenssikaaviot:

#### Kirjautuminen

![](sekvenssikaavio_kirjautuminen.png)

#### Uuden pelin aloittaminen

Huom.! Uuden pelin aloittamista ei ole vielä toteutettu - uusi peli käynnistyy tällä hetkellä, kun sovellukseen kirjaudutaan sisään. Toiminto lisätään lähitulevaisuudessa.

![](sekvenssikaavio_uusipeli.png)
