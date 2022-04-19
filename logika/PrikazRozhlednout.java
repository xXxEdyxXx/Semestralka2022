package logika;

/**
 *  Třída PrikazRozhlednout - Příkaz vypisující co hrdina v místnosti vidí
 *
 *@author     Adam Stupka
 */

class PrikazRozhlednout implements IPrikaz{

    private static final String NAZEV = "rozhlednout";
    private HerniPlan plan;

    public PrikazRozhlednout(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Příkaz při kterém se hráč rozhlédne po místnosti a vypíše předměty se kterémi se dá interktovat
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return
     */

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
