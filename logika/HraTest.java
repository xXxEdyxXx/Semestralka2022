package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková, Adam Stupka
 * @version  pro školní rok 2016/2017
 */
public class HraTest {
    private Hra hra1;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * 
     */
    @Test
    public void testPrubehHry() {
        assertEquals("Hala", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi Obývací_pokoj");
        assertEquals(false, hra1.konecHry());
        assertEquals("Obývací_pokoj", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("interakce MEDVÍDEK");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("jdi Hala");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("jdi Schodiště");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("jdi Dětský_pokoj");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("pust");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("interakce KLÍČ");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("jdi Schodiště");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("jdi Hala");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("interakce DVEŘE");
        assertEquals(true, hra1.konecHry());

    }

    @Test
    public void testPrubehHry2() {
        assertEquals("Hala", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi Kuchyň");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("interakce NŮŽ");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("jdi Hala");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("jdi Garáž");
        assertEquals(true, hra1.konecHry());
    }

    @Test
    public void testPrubehHry3() {
        assertEquals("Hala", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi Schodiště");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("jdi Tajemná_místnost");
        assertEquals(true, hra1.konecHry());

    }

}
