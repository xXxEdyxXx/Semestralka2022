package logika;

class PrikazPust implements IPrikaz {

    private static final String NAZEV = "pust";
    private HerniPlan plan;

    public PrikazPust(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Příkaz který položí předmět v ruce a položí ho do místnosti ve kterém se nachází hráč
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return
     */

    @Override
    public String provedPrikaz(String... parametry) {

        Vec pustenaVec = plan.evidenceVeci.predmetVRuce();

        if(pustenaVec == null){

            return "Nemám co pustit";

        }else {
            String dialog = "Pustil jsem " + plan.evidenceVeci.predmetVRuce().getNazev();


            //Podmínky pokud necháme nějaký předmet v nějaké místnosti
            if(plan.getAktualniProstor().getNazev().equals("Dětský_pokoj") && plan.evidenceVeci.predmetVRuce().getNazev().equals("MEDVÍDEK")){
                dialog += ", Když jsem ho položil viděl jsem záblesk něčeho zlatého";
                plan.evidenceVeci.getUrcityPredmet("KLÍČ").setProstor(plan.getAktualniProstor());
            }


            plan.evidenceVeci.predmetVRuce().setProstor(plan.getAktualniProstor());
            return dialog;
        }

    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
