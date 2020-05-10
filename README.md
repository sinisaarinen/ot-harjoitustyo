# Miinaharava

Sovellus on yhdelle pelaajalle tarkoitettu miinaharavapeli, jossa tarkoitus on päästä peli läpi klikkaamatta miinoja. Sovellukseen kirjaudutaan sisään salasanan avulla, jonka jälkeen pelaaja pääsee valitsemaan vaikeustason ja aloittamaan pelin.

Sovellus toimii Helsingin yliopiston kevään 2020 ohjelmistotekniikan kurssin harjoitustyönä.

HUOM! Miinaharavapeliin pääsee kirjautumaan salasanalla "password".

## Dokumentaatio

[Määrittelydokumentti](dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](dokumentaatio/kayttoohje.md)

[Testausdokumentti](dokumentaatio/testing.md)

[Tuntikirjanpito](dokumentaatio/tuntikirjanpito.md)

## Releaset

[Viikko 5](https://github.com/sinisaarinen/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/sinisaarinen/ot-harjoitustyo/releases/tag/viikko6)

[Loppupalautus](https://github.com/sinisaarinen/ot-harjoitustyo/releases/tag/loppupalautus1)

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
### JavaDoc

JavaDoc luodaan komennolla
```
mvn javadoc:javadoc
```
JavaDocia voi tarkastella avaamalla selaimella tiedoston _target/site/apidocs/index.html_


### Checkstyle

Tiedoston [checkstyle.xml](Miinaharava/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
Virheilmoituksia voi tarkastella avaamalla selaimella tiedoston _target/site/checkstyle.html_
