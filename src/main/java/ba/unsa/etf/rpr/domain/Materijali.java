package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * Contains all information about Materijali in SmartDentist app
 * Bean for Materijali
 * @author vmujic1
 */
public class Materijali implements Idable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materijali that = (Materijali) o;
        return id == that.id && količina == that.količina && Objects.equals(naziv, that.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, količina);
    }

    @Override
    public String toString() {
        return "Materijali{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", količina=" + količina +
                '}';
    }
}
