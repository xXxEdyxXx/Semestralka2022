package logika;

class PrikazInventar implements IPrikaz{

    private static final String NAZEV = "inventar";
    private HerniPlan plan;

    public PrikazInventar(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {

            if(plan.getvRuce() == null){
                return "V ruce nic nedržím";
            }
            return plan.getvRuce();

    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
