package logika;

/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček, Adam Stupka
 *@version    pro školní rok 2016/2017
 */
class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private HerniPlan plan;
    
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
    */    
    public PrikazJdi(HerniPlan plan) {
        this.plan = plan;
    }



    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam mám jít? Musíš zadat jméno východu";
        }

        String smer = parametry[0];
        plan.setDuch(false);

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        if (sousedniProstor == null) {
            return "Tam se odsud jít nedá!";
        }
        else {
            String dialog = sousedniProstor.dlouhyPopis();
            plan.setAktualniProstor(sousedniProstor);
            if ( getRandomNumber(0,100) > 25){
                plan.setDuch(true);
                dialog += "\nV rohu mistnosti stojí duch";
            }
            //Dohrání hry
            if(sousedniProstor.getNazev().equals("Tajemná_místnost")){
                dialog += "\nSnědl tě vlk";
                plan.dohrano();
            }
            if(sousedniProstor.getNazev().equals("Garáž") && plan.evidenceVeci.predmetVRuce() != null && plan.evidenceVeci.predmetVRuce().getNazev().equals("NŮŽ")){
                dialog += "\nUklouzl jsem a napíchnul se na nůž co jsem držel v ruce";
                plan.dohrano();
            }
            if(sousedniProstor.getNazev().equals("Ložnice") && plan.evidenceVeci.predmetVRuce() != null && plan.evidenceVeci.predmetVRuce().getNazev().equals("BONBÓN")){
                dialog += "\nSkřítek: TY MÁŠ BONBÓN.\nSkřítek po mě skočil, já spadl, uhodil se do hlavy a omdlel jsem";
                plan.dohrano();
            }
            return dialog;
        }



    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


}
