package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.NarudzbePacijenata;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
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

    public static NarudzbePacijenataDao getInstance() {
    }


    @Override
    public NarudzbePacijenata getById(int id) {
        String query = "SELECT * FROM narudzbe_pacijenata WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                NarudzbePacijenata nr = new NarudzbePacijenata();
                nr.setId(rs.getInt("id"));
                nr.setIme(rs.getString("ime"));
                nr.setPrezime(rs.getString("prezime"));
                nr.setDatum(rs.getDate("datum"));

                rs.close();
                return nr;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
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
    public List<NarudzbePacijenata> searchByDate(Date datum1) {
        String query = "SELECT * FROM narudzbe_pacijenata WHERE datum = ?";
        List<NarudzbePacijenata> narudzbe = new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setDate(1, (java.sql.Date) datum1);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                NarudzbePacijenata nr = new NarudzbePacijenata();
                nr.setId(rs.getInt("id"));
                nr.setIme(rs.getString("ime"));
                nr.setPrezime(rs.getString("prezime"));
                nr.setDatum(rs.getDate("datum"));
                narudzbe.add(nr);

            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        
    return  narudzbe;
    }

    @Override
    public List<NarudzbePacijenata> searchByName(String ime1, String prezime1) {
        String query = "SELECT * FROM narudzbe_pacijenata WHERE ime LIKE concat('%',?,'%') AND prezime LIKE concat('%',?,'%')";
        List<NarudzbePacijenata> narudzbe = new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1,ime1);
            stmt.setString(2,prezime1);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                NarudzbePacijenata nr = new NarudzbePacijenata();
                nr.setId(rs.getInt("id"));
                nr.setIme(rs.getString("ime"));
                nr.setPrezime(rs.getString("prezime"));
                nr.setDatum(rs.getDate("datum"));
                narudzbe.add(nr);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return narudzbe;
    }
}
