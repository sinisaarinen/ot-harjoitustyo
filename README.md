# Miinaharava

Sovellus on yhdelle pelaajalle tarkoitettu miinaharavapeli, jossa tarkoitus on päästä peli läpi klikkaamatta miinoja. Sovellus on vielä alkutekijöissään ja sitä tullaan päivittämään viikoittain. Tutustustumalla tarkemmin sovelluksen dokumentaatioon voi seurata, mitä ominaisuuksia sovellukseen tullaan tulevaisuudessa lisäämään. 

Sovellus toimii Helsingin yliopiston kevään 2020 ohjelmistotekniikan kurssin harjoitustyönä.

HUOM! Miinaharavapeliin pääsee kirjautumaan salasanalla "password".

## Dokumentaatio

[Määrittelydokumentti](dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](dokumentaatio/arkkitehtuuri.md)

[Tuntikirjanpito](dokumentaatio/tuntikirjanpito.md)

## Komentorivitoiminnot

Projektin koodin voi suorittaa komennolla
```
mvn compile exec:java -Dexec.mainClass=minesweeperapp.main.Main
```

### Testaus

Testit suoritetaan komennolla 

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn test jacoco:report
```
Kattavuusraporttia voi tarkastella avaamalla selaimella tiedoston _target/site/jacoco/index.html_

### Jar-tiedoston generointi

Jar-tiedosto generoidaan komennolla
```
mvn package
```
Suoritettava tiedosto _Miinaharava-1.0-SNAPSHOT.jar_ löytyy tämän jälkeen hakemistosta _target_, ja sen voi suorittaa komennolla
```
java -jar Miinaharava-1.0-SNAPSHOT.jar
```

### Checkstyle

Tiedoston [checkstyle.xml](Miinaharava/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
Virheilmoituksia voi tarkastella avaamalla selaimella tiedoston _target/site/checkstyle.html_
