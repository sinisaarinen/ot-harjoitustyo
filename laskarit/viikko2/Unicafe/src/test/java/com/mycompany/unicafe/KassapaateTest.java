/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author saasini
 */
public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(500);
    }
    
    @Test
    public void rahamaaraOnOikea() {
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void alussaEiMyytyjaLounaita() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty()+kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullinenOstoNostaaKassanRahamaaraa() {
        kassa.syoEdullisesti(240);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void edullisenOstonVaihtorahanSuuruusOikea() {
        assertEquals(60, kassa.syoEdullisesti(300));
    }
    
    @Test
    public void edullinenOstoKasvattaaMyytyjenMaaraa() {
        kassa.syoEdullisesti(240);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void riittamatonEdullinenOstoEiNostaKassanRahamaaraa() {
        kassa.syoEdullisesti(220);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void riittamattomanEdullisenOstonVaihtorahanSuuruusOikea() {
        assertEquals(220, kassa.syoEdullisesti(220));
    }
    
    @Test
    public void riittamatonEdullinenOstoEiKasvattaMyytyjenMaaraa() {
        kassa.syoEdullisesti(220);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukasOstoNostaaKassanRahamaaraa() {
        kassa.syoMaukkaasti(400);
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void emaukkaanOstonVaihtorahanSuuruusOikea() {
        assertEquals(60, kassa.syoMaukkaasti(460));
    }
    
    @Test
    public void maukasOstoKasvattaaMyytyjenMaaraa() {
        kassa.syoMaukkaasti(400);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void riittamatonMaukasOstoEiNostaKassanRahamaaraa() {
        kassa.syoMaukkaasti(220);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void riittamattomanMaukkaanOstonVaihtorahanSuuruusOikea() {
        assertEquals(220, kassa.syoMaukkaasti(220));
    }
    
    @Test
    public void riittamatonMaukasOstoEiKasvattaMyytyjenMaaraa() {
        kassa.syoMaukkaasti(220);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenOstoVeloitetaanKortilta() {
        kassa.syoEdullisesti(kortti);
        assertEquals(260, kortti.saldo());
    }
    
    @Test
    public void edullinenOstoMetodiPalauttaaTrue() {
        assertTrue(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void edullinenOstoKasvattaaMyytyjaLounaita() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void riittamatontaEdullistaOstoaEiVeloiteta() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(20, kortti.saldo());
    }
    
    @Test
    public void riittamatonEdullinenOstoMetodiPalauttaaFalse() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertFalse(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void riittamatonEdullinenOstoEiKasvataMyytyjaLounaita() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(2, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukasOstoVeloitetaanKortilta() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void maukasOstoMetodiPalauttaaTrue() {
        assertTrue(kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void maukasOstoKasvattaaMyytyjaLounaita() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void riittamatontaMaukastaOstoaEiVeloiteta() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void riittamatonMaukasOstoMetodiPalauttaaFalse() {
        kassa.syoMaukkaasti(kortti);
        assertFalse(kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void riittamatonMaukasOstoEiKasvataMyytyjaLounaita() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukasKorttiostoEiVaikutaKassanSaldoon() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void edullinenKorttiostoEiVaikutaKassanSaldoon() {
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void rahanLatausKortilleMuuttaaKortinSaldoa() {
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(600, kortti.saldo());
    }
    
    @Test
    public void rahanLatausKortilleMuuttaaKassanSaldoa() {
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(100100, kassa.kassassaRahaa());
    }
    
    @Test
    public void negatiivinenLatausKortilleEiVaikutaSaldoihin() {
        kassa.lataaRahaaKortille(kortti, -10);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(500, kortti.saldo());
    }
}
