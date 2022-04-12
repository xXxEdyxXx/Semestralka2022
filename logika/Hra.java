package logika;

/**
 *  Třída Hra - třída představující logiku adventury.
 * 
 *  Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */

public class Hra implements IHra {
    private SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů
    private HerniPlan herniPlan;
    private boolean konecHry = false;

    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    public Hra() {
        herniPlan = new HerniPlan();
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazInterakce(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazPust(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazInventar(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazMluv(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazRozhlednout(herniPlan));
    }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() {
        return  "  #####                              \n" +
                " #     #  ####    ##   #####  #   #  \n" +
                " #       #    #  #  #  #    #  # #   \n" +
                "  #####  #      #    # #    #   #    \n" +
                "       # #      ###### #####    #    \n" +
                " #     # #    # #    # #   #    #    \n" +
                "  #####   ####  #    # #    #   #    \n" +
                "                                     \n" +
                " #     #                             \n" +
                " #     #  ####  #    #  ####  ###### \n" +
                " #     # #    # #    # #      #      \n" +
                " ####### #    # #    #  ####  #####  \n" +
                " #     # #    # #    #      # #      \n" +
                " #     # #    # #    # #    # #      \n" +
                " #     #  ####   ####   ####  ###### \n" +
                "                                     \n" +
               "U nás na vsi už dlouho stojí tento strašidelný dům. Všichni se mu obloukem vyhýbají. Nikdo se neodvaži do něj vstoupit... až do těd\nStojím před domem. Sbírám veškerou moji kuráž a šahám po klice... Otačím s ní. Otvírám dveře a vstupuju do vnitř\nVcházím do veliké haly, než se vzpamatuju kde to jsem tak slyším velkou ránu. Dveře se za mnou zavřeli. Snažím  se je otevřít ale jsou zamčený\n" +
               "Napište 'nápověda', pokud si nevíte rady, jak hrát dál.\n" +
               "\n" +
               herniPlan.getAktualniProstor().dlouhyPopis();
    }
    
    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     */
    public String vratEpilog() {
        return "Dík, že jste si zahráli.  Ahoj.";
    }
    
    /** 
     * Vrací true, pokud hra skončila.
     */
     public boolean konecHry() {
        return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
     public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
        for(int i=0 ;i<parametry.length;i++){
           	parametry[i]= slova[i+1];  	
        }
        String textKVypsani=" .... ";
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.provedPrikaz(parametry);
            if(herniPlan.isStatus()){
                konecHry = true;
            }
        }
        else {
            textKVypsani="Nevím co tím myslíš? Tento příkaz neznám. ";
        }

        if(herniPlan.getAktualniProstor().toString().equals("chaloupka")){
            System.out.println("Gratuluji vyhral si!");
            setKonecHry(true);
        }

        return textKVypsani;
    }
    
    
     /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní Prikaz.
     *  
     *  @param  konecHry  hodnota false= konec hry, true = hra pokračuje
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }
    
     /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *  
     *  @return     odkaz na herní plán
     */
     public HerniPlan getHerniPlan(){
        return herniPlan;
     }


}

