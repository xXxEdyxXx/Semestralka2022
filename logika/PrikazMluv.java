package logika;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  Třída PrikazMluv - Slouží hlavně k pobavení duchem který vypráví vtipy nebo k zahrání si se skřítkem
 *
 *@author     Adam Stupka
 */

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

        /**
         * Test pokud jde s nekým mluvit
         */

        if (plan.getDuch() == false && plan.getAktualniProstor().getNazev() != "Ložnice"){
            return "Není tu nikdo s kým bych mohl mluvit";
        }

        /**
         * Hraní hry se skřítkem
         */

        if (plan.getDuch() == false){
            Scanner sc=new Scanner(System.in);
            int randomNumber = getRandomNumber(1, 100);
            System.out.println("Skřítek: Pojd si hrát pojd si hrát. Myslím si číslo... Hadej jaký.");
            int hadaneCislo = 0;
            try {
                hadaneCislo = sc.nextInt();
            } catch (InputMismatchException e) {
                return "To není číslo ale... s tebou nehraju";
            }

            /**
             * Tajný kod
             */

            if(hadaneCislo == 4586){
                tajnyKod();
                return "";
            }

            /**
             * While cyklus hry
             */

            while (hadaneCislo != randomNumber){
                System.out.print("Haha... špatně. Číslo které si mýslím je ");

                if (hadaneCislo > randomNumber){
                    System.out.println("menší");
                }else if(hadaneCislo < randomNumber){
                    System.out.println("větší");
                }
                try {
                    hadaneCislo = sc.nextInt();
                } catch (InputMismatchException e) {
                    return "Ale to není číslo ale... s tebou nehraju";
                }
                if(hadaneCislo == 4586){
                    tajnyKod();
                    return "";
                }
            }

            System.out.println("Správně, bylo to " + randomNumber + "\nDěkuji, že si si zahrál se mnou");

            /**
             * Splnění hry
             */

            if (plan.isLampicka() == false){
                System.out.println("Mohl by si prosím odnést tuto lampičku do kuchyně? Já mám malý nožičky a běhá se mi špatně po schodech");
                plan.evidenceVeci.getUrcityPredmet("LAMPIČKA").setProstor(plan.getAktualniProstor());
            }

            return "";
        }

        /**
         * Interakce s duchem
         */

        if(plan.getDuch() == true) {

            int randomNumber = getRandomNumber(1, 12);
            plan.setDuch(false);
            System.out.println("Duch letí skrz stěnu a řiká");
            switch (randomNumber) {
                case 1:
                    return "Duch: Dnes v noci jsem na autobusové zastávce uviděl vlkodlaka.\n" +
                            "No, možná to byl jen velmi chlupatý člověk.\n" +
                            "No, každopádně stříbrná kulka fungovala.";

                case 2:
                    return "Duch: Jaké skupiny poslouchají upíři?\n" +
                            "A, B, AB a 0.";

                case 3:
                    return "Duch: Může se Drákula nakulit?\n" +
                            "Proč by nemohl? Ale pak se místo v zámecké kryptě může ocitnout v policejní kobce.";

                case 4:
                    return "„Duch: Ten nový soused mi pije krev. Jak že se jmenuje?”\n" +
                            "„Vlad Țepeș.”";

                case 5:
                    return "Duch: Upírek se ptá maminky: „Můžu si pozvat na návštěvu kamaráda?”\n" +
                            "„Ano, ale nezapomeň ho potom dát do ledničky.”";

                case 6:
                    return "Duch: Z čeho má vyrobený nábytek upír Drákula?\n" +
                            "Z krevních destiček.";

                case 7:
                    return "„Duch: Tatínku, odstěhujeme se. Dnes mi služka říkala, že se v našem domě objevují přízraky.”\n" +
                            "„Vzpamatuj se, Haničko, my přece žádnou služku nemáme!”";

                case 8:
                    return "Duch: Pán chce koupit dům, ale jak tak vzpomíná, tak řekne: „Nestraší tam?”\n" +
                            "A majitel řekne: „Ale nééé, už tu jsem 350 let a žádné strašidlo jsem neviděl.”";

                case 9:
                    return "Duch: Přijde upír do krevní banky a zastaví ho sestřička a říká: „Jdete darovat?”\n" +
                            "A upír na to: „Ne, ne, já přišel jen na degustaci.”";

                case 10:
                    return "„Duch: Víte, paní Vrabcová, že se mi vždycky o půlnoci zjevuje můj nebožtík muž?”\n" +
                            "„Nepovídejte, vždyť on chodil domů až ve tři.”";

                case 11:
                    return "Duch: Dva duchové se baví v pekle: „Proč jsi tady?”\n" +
                            "„Neuznával jsem učení církve, tak mě upálili. A ty?”\n" +
                            "„Já jsem zase neuznal gól.”";

                case 12:
                    return "Duch: Mladý šlechtic konejší svou dívku: „Z řečí si nic nedělejte. O mně říkají, že jsem upír, už dobrých dvě stě let!”";

            }

        }
        return "insert a funny joke";
    }

    /**
     * Metoda která vyhraje hru
     */

    private void tajnyKod(){
        System.out.println("Vy znáte moje tajné heslo... Ja vám musím něco dát a pustit vás ven... Pojdte za mnou prosím.\n Skřítek mi podal truhlici se zlatem a pustil mě ven\n Utekl jsem se zlatým pokladem");
        plan.dohrano();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }


    /**
     * Metoda generování náhodných čisel
     * @param min
     * @param max
     * @return nahodné číslo
     */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
