package logika;

public class Vec {

    private String nazev;
    private Prostor prostor;

    public Vec(String nazev, Prostor prostor) {
        this.nazev = nazev;
        this.prostor = prostor;
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

}
