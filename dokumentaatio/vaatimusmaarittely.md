# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovellus on yhdelle pelaajalle suunniteltu miinaharavapeli, jonka tarkoituksena on tarjota käyttäjälleen haastavaa viihdykettä. Pelin tarkoitus on läpäistä kenttä klikkaamatta miinoja.

## Toteutetut toiminnallisuudet (perusversio)

- käyttäjän tulee kirjautua sovellukseen salasanan avulla
- käyttäjä voi valita eri vaikeustasoista (helppo/normaali/vaikea)
  - helpolla tasolla miinakenttä on pieni (10x10 ruutua) ja miinoja on noin 10 prosentissa ruuduista
  - normaalilla tasolla miinakenttä on keskikokoinen (18x18 ruutua) ja miinoja on noin 20 prosentissa ruuduista
  - vaikealla tasolla miinakenttä on suuri (26x26 ruutua) ja miinoja on noin 30 prosentissa ruuduista
- käyttäjälle näytetään, kuinka monta kertaa hän on pelannut peliä, ja pelatut pelit tallennetaan tietokantaan
- käyttäjä voi koska tahansa aloittaa uuden pelin
- käyttäjä voi klikkailla ruutuja, joista paljastuu joko miina tai klikatun ruudun ympärillä olevien miinojen lukumäärä (0-8)
- jos ensimmäisessä klikatussa ruudussa on miina, se poistetaan, ettei peli pääty ensimmäiseen klikkaukseen
- jos klikatun ruudun ympärillä on 0 miinaa, sen ympärillä olevat miinattomat ruudut aukeavat
- jos käyttäjä klikkaa miinaa, kaikki loputkin miinat paljastuvat ja peli loppuu
- käyttäjä voi merkitä miinoja hiiren oikealla painikkeella
- käyttäjä voi poistaa merkityn miinan klikkaamalla merkitä ruutua uudelleen hiiren oikealla painikkeella
- käyttäjä voi lopettaa pelin sulkemalla ikkunan

## Jatkokehitysideoita

- peliin kirjautuessa syötetään käyttäjänimi, ja peli tallentaa tietokantaan käyttäjän pelitulokset
- peliin voi toteuttaa kaksinpelimahdollisuuden
- pelissä mitataan aikaa
- ranking-lista haastavuustason ja ajan perusteella
