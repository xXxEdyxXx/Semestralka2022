package logika;

class PrikazPust implements IPrikaz {

    private static final String NAZEV = "pust";
    private HerniPlan plan;

    public PrikazPust(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if(plan.getvRuce() == null){
            return "Nemám co pustit";
        }else {
            String holder = plan.getvRuce();
            plan.setvRuce(null);
            return "Pustil jsem " + holder;
        }

    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
