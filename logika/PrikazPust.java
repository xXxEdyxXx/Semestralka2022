package logika;

class PrikazPust implements IPrikaz {

    private static final String NAZEV = "pust";
    private HerniPlan plan;

    public PrikazPust(HerniPlan plan) {
        this.plan = plan;
    }

    //Metoda která pustí předmět z ruky a vrátí dialog

    @Override
    public String provedPrikaz(String... parametry) {

        Vec pustenaVec = plan.evidenceVeci.predmetVRuce();

        if(pustenaVec == null){

            return "Nemám co pustit";

        }else {
            String dialog = "Pustil jsem " + plan.evidenceVeci.predmetVRuce().getNazev();
            plan.evidenceVeci.predmetVRuce().setProstor(plan.getAktualniProstor());
            return dialog;
        }

    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
