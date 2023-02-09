package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.Materijali;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MaterijaliSQLImpl implements MaterijaliDao{

    public Connection connection;

    public MaterijaliSQLImpl() {
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


    @Override
    public Materijali getById(int id) {
        String query = "SELECT * FROM materijali WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                Materijali m = new Materijali();
                m.setId(rs.getInt(1));
                m.setNaziv(rs.getString(2));
                m.setKoličina(rs.getInt(3));
                return m;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Materijali add(Materijali item) {
        return null;
    }

    @Override
    public Materijali update(Materijali item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Materijali> getAll() {
        return null;
    }

    @Override
    public Materijali searchByName(String ime) {
        String query = "SELECT * FROM materijali WHERE naziv = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1,ime);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Materijali m = new Materijali();
                m.setId(rs.getInt(1));
                m.setNaziv(rs.getString(2));
                m.setKoličina(rs.getInt(3));
                return m;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Materijali> searchByKolicina(int kolicina1) {
        String query = "SELECT * FROM materijali WHERE kolicina = ?";
        List<Materijali> materijali = new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1,kolicina1);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Materijali m = new Materijali();
                m.setId(rs.getInt(1));
                m.setNaziv(rs.getString(2));
                m.setKoličina(rs.getInt(3));
                materijali.add(m);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return materijali;
    }
}
