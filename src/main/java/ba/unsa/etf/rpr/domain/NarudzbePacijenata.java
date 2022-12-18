package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

public class NarudzbePacijenata {

    private String ime;
    private String prezime;
    private Date datum;
    private String povod;

    public NarudzbePacijenata(String ime, String prezime, Date datum, String povod) {
        this.ime = ime;
        this.prezime = prezime;
        this.datum = datum;
        this.povod = povod;
    }

    public NarudzbePacijenata(){

    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public Date getDatum() {
        return datum;
    }

    public String getPovod() {
        return povod;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setPovod(String povod) {
        this.povod = povod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NarudzbePacijenata that = (NarudzbePacijenata) o;
        return Objects.equals(ime, that.ime) && Objects.equals(prezime, that.prezime) && Objects.equals(datum, that.datum) && Objects.equals(povod, that.povod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, prezime, datum, povod);
    }
}
