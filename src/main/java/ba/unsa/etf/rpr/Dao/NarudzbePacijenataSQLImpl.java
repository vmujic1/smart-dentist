package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.NarudzbePacijenata;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class NarudzbePacijenataSQLImpl implements NarudzbePacijenataDao{

    public Connection connection;

    public NarudzbePacijenataSQLImpl(){
        try{
            FileReader reader = new FileReader("db.properties");
            Properties p = new Properties();
            p.load(reader);
            this.connection = DriverManager.getConnection(p.getProperty("db.url"),p.getProperty("db.username"), p.getProperty("db.password"));
        }catch (SQLException | IOException e){
            System.out.println("X");
            e.printStackTrace();
        }
    }


    @Override
    public NarudzbePacijenata getById(int id) {
        return null;
    }

    @Override
    public NarudzbePacijenata add(NarudzbePacijenata item) {
        return null;
    }

    @Override
    public NarudzbePacijenata update(NarudzbePacijenata item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<NarudzbePacijenata> getAll() {
        return null;
    }

    @Override
    public List<NarudzbePacijenata> searchByDate(Date datum) {
        return null;
    }

    @Override
    public List<NarudzbePacijenata> searchByName(String ime, String prezime) {
        return null;
    }
}
