package logika;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Třída sloužící k otestování evidence věcí a batohu
 * @author Adam Stupka
 */

public class BatohTest {

    private Hra hra;
    private Prostor prostor;
    private Vec vec1;
    private Vec vec2;
    private EvidenceVeci evidenceVeci;

    @Before
    public void setUp() {
        hra = new Hra();
        vec1 = new Vec("MEC", prostor, true,"Ostrý meč");
        vec2 = new Vec("STŮL", prostor, false, "Težky stůl");
        evidenceVeci = new EvidenceVeci();
    }

    //Test batohu a předmětů

    @Test
    public void testPrubehHry() {
        assertEquals("Hala", hra.getHerniPlan().getAktualniProstor().getNazev());

        hra.zpracujPrikaz("jdi Obývací_pokoj");
        assertEquals(false, hra.konecHry());
        assertEquals("Obývací_pokoj", hra.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals("Držim MEDVÍDEK", hra.zpracujPrikaz("interakce MEDVÍDEK"));
        assertEquals("V ruce držím MEDVÍDEK\nChlupatý plyšový medvídek", hra.zpracujPrikaz("inventar"));
        assertEquals("Neunesu už další věc", hra.zpracujPrikaz("interakce SKLENICE"));
        assertEquals("Pustil jsem MEDVÍDEK", hra.zpracujPrikaz("pust"));
        assertEquals("V ruce nic nedržím", hra.zpracujPrikaz("inventar"));

        //Nelze sebrat velké předměty
        assertEquals("Jdou slyšet krásné noty, čím víc se přibližuji tím méně hraje. Když se k němu postavím... ztichlo", hra.zpracujPrikaz("interakce PIANO"));

    }


}
