package logika;

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
            return "V ruce držím " + predmet.getNazev() + "\n" + predmet.getPopis();

    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
