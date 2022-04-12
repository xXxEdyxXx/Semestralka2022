package logika;

public class Vec {

    /**
     * Class Vec s vlastnosti: Nazev ( jak se jmenuje ), prostor ( ve kterém se právě nachází )
     * popis (Krátky popis předmetu), mohuVzit(pokud si ho hrač může dát do ruky)
     *
     */

    private String nazev;
    private Prostor prostor;
    private String popis;
    private boolean mohuVzit;

    public Vec(String nazev, Prostor prostor, boolean mohuVzit, String popis) {
        this.nazev = nazev;
        this.prostor = prostor;
        this.mohuVzit = mohuVzit;
        this.popis = popis;
    }


    public Prostor getProstor() {
        return prostor;
    }

    public String getNazev() {
        return nazev;
    }

    public void setProstor(Prostor prostor) {
        this.prostor = prostor;
    }

    public String getPopis() {
        return popis;
    }

    public boolean isMohuVzit() {
        return mohuVzit;
    }
}
