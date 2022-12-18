package ba.unsa.etf.rpr.domain;

import java.util.Date;

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

}
