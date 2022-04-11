package logika;

class PrikazRozhlednout implements IPrikaz{

    private static final String NAZEV = "rozhlednout";
    private HerniPlan plan;

    public PrikazRozhlednout(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {

        if(plan.evidenceVeci.vratSeznamVeciVMistnosti(plan.getAktualniProstor()).isEmpty()){
            return "Nic zajímavího zde nevidím";
        }else

        return "Vidím: " + plan.getEvidenceVeci().vratSeznamVeciVMistnosti(plan.getAktualniProstor());
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
