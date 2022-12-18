package ba.unsa.etf.rpr.domain;

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
}
