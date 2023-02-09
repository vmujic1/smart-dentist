package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.User;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class UserDaoSQLImpl implements UserDao{
    public Connection connection;

    public UserDaoSQLImpl(){
        try{
            FileReader reader = new FileReader("db.properties");
            Properties p = new Properties();
            p.load(reader);
            this.connection = DriverManager.getConnection(p.getProperty("db.url"),p.getProperty("db.username"),p.getProperty("db.password"));
        } catch(SQLException | IOException e){
            System.out.println("X");
            e.printStackTrace();
        }
    }

    public static UserDao getInstance() {
    }

    @Override
    public User getById(int id) {
        String query = "SELECT * FROM user WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){

                User user = new User();
                user.setId(rs.getInt("id"));
                user.setImeOrdinacije(rs.getString("ime_ordinacije"));
                user.setUsername(rs.getString("username"));
                user.setLozinka(rs.getString("lozinka"));
                user.setBroj_zaposlenih(rs.getInt("broj_zaposlenih"));
                user.setAdresa(rs.getString("adresa"));
                user.setEmail(rs.getString("email"));
                user.setKontakt_telefon(rs.getString("kontakt_telefon"));
                user.setBroj_poslovnica(rs.getInt("broj_poslovnica"));

                rs.close();
                return user;

            }else{
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User add(User item) {
        return null;
    }

    @Override
    public User update(User item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User searchByUsername(String text) {
        String query = "SELECT * FROM user WHERE username LIKE concat('%',?,'%')";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1,text);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setImeOrdinacije(rs.getString("ime_ordinacije"));
                user.setUsername(rs.getString("username"));
                user.setLozinka(rs.getString("lozinka"));
                user.setBroj_zaposlenih(rs.getInt("broj_zaposlenih"));
                user.setAdresa(rs.getString("adresa"));
                user.setEmail(rs.getString("email"));
                user.setKontakt_telefon(rs.getString("kontakt_telefon"));
                user.setBroj_poslovnica(rs.getInt("broj_poslovnica"));
                rs.close();
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public User searchByOrdinationUsername(String text) {
        String query = "SELECT * FROM user WHERE imeOrdinacije LIKE concat('%', ?, '%')";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1,text);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setImeOrdinacije(rs.getString("ime_ordinacije"));
                user.setUsername(rs.getString("username"));
                user.setLozinka(rs.getString("lozinka"));
                user.setBroj_zaposlenih(rs.getInt("broj_zaposlenih"));
                user.setAdresa(rs.getString("adresa"));
                user.setEmail(rs.getString("email"));
                user.setKontakt_telefon(rs.getString("kontakt_telefon"));
                user.setBroj_poslovnica(rs.getInt("broj_poslovnica"));
                rs.close();
                return user;

            }



            } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
