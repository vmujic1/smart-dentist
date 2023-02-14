package ba.unsa.etf.rpr.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class NarudzbePacijenata implements Idable {

    private int id;

    private String ime;
    private String prezime;
    private LocalDate datum;
    private String povod;

    public NarudzbePacijenata(int id,String ime, String prezime, LocalDate datum, String povod) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datum = datum;
        this.povod = povod;
    }

    public NarudzbePacijenata(){

    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public LocalDate getDatum() {
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

    public void setDatum(LocalDate datum) {
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

    @Override
    public String toString() {
        return "NarudzbePacijenata{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", datum=" + datum +
                ", povod='" + povod + '\'' +
                '}';
    }
}
