package logika;

/**
 *  Třída PrikazInventar - Příkaz vypisující co ma hrdina v ruce (Batohu)
 *
 *@author     Adam Stupka
 */

class PrikazInventar implements IPrikaz{

    private static final String NAZEV = "inventar";
    private HerniPlan plan;

    /**
     * Prikaz který vypíše předmet v ruce
     * @param plan
     */

    public PrikazInventar(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {

        Vec predmet = plan.evidenceVeci.predmetVRuce();
        if(predmet == null){
            return "V ruce nic nedržím";
        }
            return "V ruce držím " + plan.getLedvinka().getPredmet() + "\n" + predmet.getPopis();

    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
