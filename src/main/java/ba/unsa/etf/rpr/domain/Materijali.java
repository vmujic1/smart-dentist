package ba.unsa.etf.rpr.domain;

public class Materijali {

    private int id;
    private String naziv;
    private int količina;

    public Materijali(int id, String naziv, int količina) {
        this.id = id;
        this.naziv = naziv;
        this.količina = količina;
    }

    public Materijali() {
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getKoličina() {
        return količina;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setKoličina(int količina) {
        this.količina = količina;
    }
}
