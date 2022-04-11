package logika;

class PrikazInterakce implements IPrikaz {

    private static final String NAZEV = "interakce";
    private HerniPlan plan;

    public PrikazInterakce(HerniPlan plan) {
        this.plan = plan;
    }


    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length == 0) {
            // pokud chybí druhé slovo
            return "S čím?";
        }

        //Podle parametru a v jake se nachazíme místnosti určíme co se stane

        String vec = parametry[0];

        String dialog = null;

        if(plan.getAktualniProstor().getNazev().equals("Kuchyň") && vec.equals("Nůž")){
            dialog = kontrolaRuka(vec);
        }else if(plan.getAktualniProstor().getNazev().equals("Obývací_pokoj") && vec.equals("Medvídek")){
            dialog = kontrolaRuka(vec);
        }else if(plan.getAktualniProstor().getNazev().equals("Dětský_pokoj") && vec.equals("Klíč")){
            dialog = kontrolaRuka(vec);
        }else{
            return "S tím nevím co mám dělat";
        }

        return dialog;

    }

    @Override
    public String getNazev() {
        return NAZEV;
    }

    private String kontrolaRuka(String vec){
        if (plan.getvRuce() != null){
            return "Neunesu už další věc";
        }
        plan.setvRuce(vec);
        return "Držím " + vec;
    }

}
