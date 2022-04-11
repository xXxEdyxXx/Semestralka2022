package logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private String vRuce = null;
    private boolean duch = false;
    public EvidenceVeci evidenceVeci;

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
        Prostor loznice = new Prostor("Ložnice", "Místnost s velkými okny, měsíční svit krásně rozzařuje celou mistnost");
        Prostor detskyPokoj = new Prostor("Dětský_pokoj", "Mála místnost s postelí, na posteli jsou vyskládaný plyšoví medvídci u prostřed mezi nimi je mezera, jakoby tam nějaký medvídek chyběl");
        Prostor ruka = new Prostor("RUKA", "");
        
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
        Vec klic = new Vec("KLÍČ", detskyPokoj, true, "Zlatý klíč");
        Vec piano = new Vec("PIANO", obyvaciPokoj, false, "Jdou slyšet krásné noty, čím víc se přibližuji tím méně hraje. Když se k němu postavím... ztichlo");

        evidenceVeci.vlozVec(nuz);
        evidenceVeci.vlozVec(medvidek);
        evidenceVeci.vlozVec(klic);
        evidenceVeci.vlozVec(piano);


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

    public void setvRuce(String vec){
        vRuce = vec;
    }

    public String getvRuce(){
        return vRuce;
    }

    public boolean getDuch() {
        return duch;
    }

    public void setDuch(boolean duch) {
        this.duch = duch;
    }

    public EvidenceVeci getEvidenceVeci() {
        return evidenceVeci;
    }



}
