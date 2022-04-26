package logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Adam Stupka
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private boolean duch = false;
    public EvidenceVeci evidenceVeci;
    public boolean status = false;
    public boolean lampicka = false;

     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();
    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory

        Prostor hala = new Prostor("Hala", "Dlouhá tmavá hala se čtyřmi dveřmi a s velkým honosným schodištěm na konci. Ze zhora se ozývají podivné zvuky. Z jedné z místností se ozývají krásné toný piana");
        Prostor obyvaciPokoj = new Prostor("Obývací_pokoj", "Velká místnost, zatažené závěsy, stará pohovka s polštářky.Uprostřed místnosti stojí krásný naleštěný piano, které samo hraje.");
        Prostor kuchyn = new Prostor("Kuchyň", "Menší místnost, všude lítají mouchy, je tu velmi zatuhlý zvuk");
        Prostor garaz = new Prostor("Garáž", "prázdná místnost, žádné okna ani dveře, podlaha divně klouže, musím být opatrný");
        Prostor koupelna = new Prostor("Koupelna", "Malá mramorová místnost, krásně naleštěná a vypucovaná koupelna, vypadá mnohem líp než u mě doma");
        Prostor schodiste = new Prostor("Schodiště", "Podivné zvuky jsou hlasitejší, dokážu říct že se ozývaji ze tajemné místnosti na konci chodby, nemyslím si, že je dobrý nápad zkoumat co je za nimi, na levo se nachází další dvoje dveře");
        Prostor tajemnaMistnost = new Prostor("Tajemná_místnost", "Temná místnost, sotva vidím před sebe, hlasy ztichly, něco se hýbe na konci místnosti, vypadá to jako Vl...............");
        Prostor loznice = new Prostor("Ložnice", "Místnost s velkými okny, měsíční svit krásně rozzařuje celou mistnost... Na posteli stojí skřítek");
        Prostor detskyPokoj = new Prostor("Dětský_pokoj", "Mála místnost s postelí, na posteli jsou vyskládaný plyšoví medvídci u prostřed mezi nimi je mezera, jakoby tam nějaký medvídek chyběl");
        Prostor spawner = new Prostor("Spawner", " ");
        
        // přiřazují se průchody mezi prostory (sousedící prostory)

        hala.setVychod(obyvaciPokoj);
        hala.setVychod(kuchyn);
        hala.setVychod(schodiste);
        hala.setVychod(koupelna);
        hala.setVychod(garaz);

        obyvaciPokoj.setVychod(hala);
        kuchyn.setVychod(hala);
        schodiste.setVychod(hala);
        koupelna.setVychod(hala);
        garaz.setVychod(hala);

        schodiste.setVychod(tajemnaMistnost);
        schodiste.setVychod(detskyPokoj);
        schodiste.setVychod(loznice);

        loznice.setVychod(schodiste);

        detskyPokoj.setVychod(schodiste);

        aktualniProstor = hala;  // hra začíná v hale

        //Spawnovani věcí
        evidenceVeci = new EvidenceVeci();
        Vec nuz = new Vec("NŮŽ", kuchyn, true, "Velmi ostrý nůž");
        Vec medvidek = new Vec("MEDVÍDEK", obyvaciPokoj,true, "Chlupatý plyšový medvídek");
        Vec klic = new Vec("KLÍČ", spawner, true, "Zlatý klíč");
        Vec piano = new Vec("PIANO", obyvaciPokoj, false, "Jdou slyšet krásné noty, čím víc se přibližuji tím méně hraje. Když se k němu postavím... ztichlo");
        Vec dvere = new Vec("DVEŘE", hala, false, "Zamčené dveře");
        Vec okno = new Vec("OKNO", kuchyn, false, "Velké okno... Sotva z něho jde vidět ven jak je zamrzlé");
        Vec okno1 = new Vec("OKNO", obyvaciPokoj, false, "Velké okno... Sotva z něho jde vidět ven jak je zamrzlé");
        Vec skrin = new Vec("SKŘÍN", kuchyn, false, "Malá skřín na potraviny... Je prázdná");
        Vec pohovka = new Vec("POHOVKA", obyvaciPokoj, false, "Velmi pohodlná pohovka... Ale teď nemám čas na to odpočívat");
        Vec postel = new Vec("POSTEL", loznice, false, "Stará postel... Dost vrže");
        Vec postylka = new Vec("POSTÝLKA", detskyPokoj,false,"Stará dětská postýlka");
        Vec hodiny = new Vec("HODINY", hala, false, "Staré hodiny... vypadá to, že se zasekly");
        Vec auto = new Vec("AUTO", garaz, false, "Staré auto... pochybuju, že bych ho dokázal nastartovat");
        Vec krb = new Vec("KRB", obyvaciPokoj, false, "Starý krb... je v něm dost prachu");
        Vec sklenice = new Vec("SKLENICE", obyvaciPokoj, true, "prázdná sklenice na vodu");
        Vec svicka = new Vec("SVÍČKA", loznice, true, "Hezká nová svíčka");
        Vec svicen = new Vec("SVÍCEN", obyvaciPokoj, true, "Zlatý svícen, svíčky na něm jsou zapálený");
        Vec hrnecek = new Vec("HRNEČEK", obyvaciPokoj, true, "Starý hrneček... je v něm nějaká kapalina... to pít nebudu");
        Vec obraz = new Vec("OBRAZ", obyvaciPokoj, false, "Portrét nějakého pána... přísahám že mě jeho oči sledují");
        Vec chlupy = new Vec("CHLUPY", obyvaciPokoj, true, "Hromádka chlupů... Divný... nevypada to že by tady bylo nějaké zvíře");
        Vec lampicka = new Vec("LAMPIČKA", spawner, true, "Skřítkova kouzelná lampička");
        Vec bonbon = new Vec("BONBÓN", kuchyn, true, "Jahodový bonbón");

        //Vkladání věci do evidence
        evidenceVeci.vlozVec(nuz);
        evidenceVeci.vlozVec(medvidek);
        evidenceVeci.vlozVec(klic);
        evidenceVeci.vlozVec(piano);
        evidenceVeci.vlozVec(dvere);
        evidenceVeci.vlozVec(okno);
        evidenceVeci.vlozVec(okno1);
        evidenceVeci.vlozVec(skrin);
        evidenceVeci.vlozVec(pohovka);
        evidenceVeci.vlozVec(postel);
        evidenceVeci.vlozVec(postylka);
        evidenceVeci.vlozVec(hodiny);
        evidenceVeci.vlozVec(auto);
        evidenceVeci.vlozVec(krb);
        evidenceVeci.vlozVec(sklenice);
        evidenceVeci.vlozVec(svicka);
        evidenceVeci.vlozVec(svicen);
        evidenceVeci.vlozVec(hrnecek);
        evidenceVeci.vlozVec(obraz);
        evidenceVeci.vlozVec(chlupy);
        evidenceVeci.vlozVec(lampicka);
        evidenceVeci.vlozVec(bonbon);


    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }

    /**
     * Metoda vracící zde je v mistonosti duch
     * @return duch
     */

    public boolean getDuch() {
        return duch;
    }

    /**
     * Metoda nastavující ducha v mistnosti
     * @param duch
     */

    public void setDuch(boolean duch) {
        this.duch = duch;
    }

    /**
     * Metoda vracíci evidenciVeci
     * @return evidenceVeci
     */

    public EvidenceVeci getEvidenceVeci() {
        return evidenceVeci;
    }

    /**
     * Metody přirazující zda hráč dohr8l
     */

    public void dohrano(){
        status = true;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean isLampicka() {
        return lampicka;
    }

    public void setLampicka(boolean lampicka) {
        this.lampicka = lampicka;
    }
}
