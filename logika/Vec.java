package logika;

public class Vec {

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
