package logika;

class PrikazMluv implements IPrikaz{

    private static final String NAZEV = "mluv";
    private HerniPlan plan;

    /**
     * Příkaz prři kterém si promluvíme s nějakou postavou pokud se nachází v místnosti
     * @param plan
     */

    public PrikazMluv(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {

        if (plan.getDuch() == false){
            return "Není tu nikdo s kým bych mohl mluvit";
        }

        int randomNumber = getRandomNumber(1,12);

        switch (randomNumber) {
            case 1:  return "Duch: Dnes v noci jsem na autobusové zastávce uviděl vlkodlaka.\n" +
                    "No, možná to byl jen velmi chlupatý člověk.\n" +
                    "No, každopádně stříbrná kulka fungovala.";

            case 2:  return "Duch: Jaké skupiny poslouchají upíři?\n" +
                    "A, B, AB a 0.";

            case 3:  return "Duch: Může se Drákula nakulit?\n" +
                    "Proč by nemohl? Ale pak se místo v zámecké kryptě může ocitnout v policejní kobce.";

            case 4:  return "„Duch: Ten nový soused mi pije krev. Jak že se jmenuje?”\n" +
                    "„Vlad Țepeș.”";

            case 5:  return "Duch: Upírek se ptá maminky: „Můžu si pozvat na návštěvu kamaráda?”\n" +
                    "„Ano, ale nezapomeň ho potom dát do ledničky.”";

            case 6:  return "Duch: Z čeho má vyrobený nábytek upír Drákula?\n" +
                    "Z krevních destiček.";

            case 7:  return "„Duch: Tatínku, odstěhujeme se. Dnes mi služka říkala, že se v našem domě objevují přízraky.”\n" +
                    "„Vzpamatuj se, Haničko, my přece žádnou služku nemáme!”";

            case 8:  return "Duch: Pán chce koupit dům, ale jak tak vzpomíná, tak řekne: „Nestraší tam?”\n" +
                    "A majitel řekne: „Ale nééé, už tu jsem 350 let a žádné strašidlo jsem neviděl.”";

            case 9:  return "Duch: Přijde upír do krevní banky a zastaví ho sestřička a říká: „Jdete darovat?”\n" +
                    "A upír na to: „Ne, ne, já přišel jen na degustaci.”";

            case 10: return "„Duch: Víte, paní Vrabcová, že se mi vždycky o půlnoci zjevuje můj nebožtík muž?”\n" +
                    "„Nepovídejte, vždyť on chodil domů až ve tři.”";

            case 11: return "Duch: Dva duchové se baví v pekle: „Proč jsi tady?”\n" +
                    "„Neuznával jsem učení církve, tak mě upálili. A ty?”\n" +
                    "„Já jsem zase neuznal gól.”";

            case 12: return "Duch: Mladý šlechtic konejší svou dívku: „Z řečí si nic nedělejte. O mně říkají, že jsem upír, už dobrých dvě stě let!”";

        }

        return "insert a funny joke";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
