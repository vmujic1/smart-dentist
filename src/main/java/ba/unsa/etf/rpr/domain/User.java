package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class User implements Idable {

    private int id;
    private String imeOrdinacije;
    private String username;
    private String lozinka;
    private int broj_zaposlenih;
    private String adresa;
    private String email;
    private String kontakt_telefon;
    private  int broj_poslovnica;

    public User(int id, String imeOrdinacije, String username, String lozinka, int broj_zaposlenih, String adresa, String email, String kontakt_telefon, int broj_poslovnica) {
        this.id = id;
        this.imeOrdinacije = imeOrdinacije;
        this.username = username;
        this.lozinka = lozinka;
        this.broj_zaposlenih = broj_zaposlenih;
        this.adresa = adresa;
        this.email = email;
        this.kontakt_telefon = kontakt_telefon;
        this.broj_poslovnica = broj_poslovnica;
    }

    public User(){

    }

    public int getId() {
        return id;
    }

    public String getImeOrdinacije() {
        return imeOrdinacije;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImeOrdinacije(String imeOrdinacije) {
        this.imeOrdinacije = imeOrdinacije;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getUsername() {
        return username;
    }

    public int getBroj_zaposlenih() {
        return broj_zaposlenih;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getEmail() {
        return email;
    }

    public String getKontakt_telefon() {
        return kontakt_telefon;
    }

    public int getBroj_poslovnica() {
        return broj_poslovnica;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBroj_zaposlenih(int broj_zaposlenih) {
        this.broj_zaposlenih = broj_zaposlenih;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setKontakt_telefon(String kontakt_telefon) {
        this.kontakt_telefon = kontakt_telefon;
    }

    public void setBroj_poslovnica(int broj_poslovnica) {
        this.broj_poslovnica = broj_poslovnica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return id == user1.id && Objects.equals(imeOrdinacije, user1.imeOrdinacije) && Objects.equals(username, user1.username) && Objects.equals(lozinka, user1.lozinka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imeOrdinacije, username, lozinka);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", imeOrdinacije='" + imeOrdinacije + '\'' +
                ", user='" + username + '\'' +
                ", lozinka='" + lozinka + '\'' +
                '}';
    }
}
