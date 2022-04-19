package logika;

class PrikazInterakce implements IPrikaz {

    private static final String NAZEV = "interakce";
    private HerniPlan plan;

    public PrikazInterakce(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Příkaz který interaktuje s předmety v místnosti. Pokud se jedná o predmet se kterým nelze hýbat tak se vypíše popis predmetu
     * Pokud se s predmetem da pohnout pokuisíme se ho sebrat a dat do ruky
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return
     */

    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length == 0) {
            // pokud chybí druhé slovo
            return "S čím?";
        }

        //Podle parametru a v jake se nachazíme místnosti určíme co se stane

        String vec = parametry[0];

        //Pokud se jedná o předmět který se dá sebrat

        Vec predmet = plan.evidenceVeci.jePredmetVMistnosti(plan.getAktualniProstor(), vec);
        if(predmet != null && predmet.isMohuVzit() == true){
            if(plan.evidenceVeci.predmetVRuce() == null){
                predmet.setProstor(null);
                return "Držim " + vec;
            }else {
                return "Neunesu už další věc";
            }
        }

        if( predmet != null && predmet.getNazev().equals("DVEŘE") && plan.evidenceVeci.predmetVRuce() != null && plan.evidenceVeci.predmetVRuce().getNazev().equals("KLÍČ")){
            plan.dohrano();
            return "Utekl jsem";
        }

        if(predmet != null && predmet.isMohuVzit() == false){
            return predmet.getPopis();
        }



        return "Tento předmět zde nevidím";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }


}
