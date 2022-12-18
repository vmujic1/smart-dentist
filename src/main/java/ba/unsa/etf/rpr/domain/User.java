package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class User {

    private int idUser;
    private String imeOrdinacije;
    private String user;
    private String lozinka;

    public User(int idUser, String imeOrdinacije, String user, String lozinka) {
        this.idUser = idUser;
        this.imeOrdinacije = imeOrdinacije;
        this.user = user;
        this.lozinka = lozinka;
    }
    private User(){

    }

    public int getIdUser() {
        return idUser;
    }

    public String getImeOrdinacije() {
        return imeOrdinacije;
    }

    public String getUser() {
        return user;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setImeOrdinacije(String imeOrdinacije) {
        this.imeOrdinacije = imeOrdinacije;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return idUser == user1.idUser && Objects.equals(imeOrdinacije, user1.imeOrdinacije) && Objects.equals(user, user1.user) && Objects.equals(lozinka, user1.lozinka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, imeOrdinacije, user, lozinka);
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", imeOrdinacije='" + imeOrdinacije + '\'' +
                ", user='" + user + '\'' +
                ", lozinka='" + lozinka + '\'' +
                '}';
    }
}
