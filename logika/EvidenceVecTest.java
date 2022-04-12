package logika;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvidenceVecTest {

    private Hra hra;
    private Prostor prostor;
    private Vec vec1;
    private Vec vec2;
    private EvidenceVeci evidenceVeci;

    @Before
    public void setUp() {
        hra = new Hra();
        prostor = new Prostor("Hala","TEST");
        vec1 = new Vec("MEC", prostor, true,"Ostrý meč");
        vec2 = new Vec("STŮL", prostor, false, "Težky stůl");
        evidenceVeci = new EvidenceVeci();
    }

    @Test
    public void testManipulace(){
        assertEquals(true, evidenceVeci.vlozVec(vec1));
        assertEquals(true, evidenceVeci.vlozVec(vec2));
        assertEquals("[" + vec2.getNazev() + ", " + vec1.getNazev() + "]", evidenceVeci.vratSeznamVeciVMistnosti(prostor).toString());
        assertEquals(null, evidenceVeci.predmetVRuce());
        assertEquals(vec1, evidenceVeci.getUrcityPredmet("MEC"));
        evidenceVeci.getUrcityPredmet("MEC").setProstor(null);
        assertEquals(vec1, evidenceVeci.predmetVRuce());
    }

}
