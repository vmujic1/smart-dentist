package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.Materijali;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    public List<Materijali> searchByName(String ime) {
        return null;
    }

    @Override
    public List<Materijali> searchByKolicina(int kolicina) {
        return null;
    }
}
