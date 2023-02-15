package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NarudzbePacijenataSQLImpl extends AbstractDao<NarudzbePacijenata> implements NarudzbePacijenataDao{

    private static NarudzbePacijenataSQLImpl instance = null;

    NarudzbePacijenataSQLImpl(){
        super("narudzbe_pacijenata");
    }

    public static NarudzbePacijenataSQLImpl getInstance(){
        if(instance == null)
            instance = new NarudzbePacijenataSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance != null)
            instance = null;
    }




    @Override
    public NarudzbePacijenata row2object(ResultSet rs) throws SmartDentistException {
        try {
            NarudzbePacijenata narudzbe = new NarudzbePacijenata();
            narudzbe.setId(rs.getInt("id"));
            narudzbe.setIme(rs.getString("ime"));
            narudzbe.setPrezime(rs.getString("prezime"));
            narudzbe.setDatum(rs.getDate("datum").toLocalDate());
            narudzbe.setPovod(rs.getString("povod"));
            return narudzbe;
        } catch (SQLException e){
            throw new SmartDentistException(e.getMessage(),e);
        }
    }

    @Override
    public Map<String, Object> object2row(NarudzbePacijenata object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id",object.getId());
        row.put("ime",object.getIme());
        row.put("prezime",object.getPrezime());
        row.put("datum",object.getDatum());
        row.put("povod",object.getPovod());
        return row;
    }

    @Override
    public List<NarudzbePacijenata> getByDate(LocalDate date) throws SmartDentistException {
        List<NarudzbePacijenata> listaDnevna = new ArrayList<>();
        NarudzbePacijenata n = new NarudzbePacijenata();
        try{
            PreparedStatement stmt = this.getConnection().prepareStatement("Select * FROM narudzbe_pacijenata WHERE datum = ? ");
            stmt.setString(1, String.valueOf(date));
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                n = row2object(rs);
                listaDnevna.add(n);
                rs.close();
            }
        } catch (SQLException e) {
            throw new SmartDentistException(e.getMessage(),e);
        }
        return listaDnevna;
    }

    @Override
    public NarudzbePacijenata getByName(String name) throws SmartDentistException {

        NarudzbePacijenata pacijent = new NarudzbePacijenata();
        try{
            PreparedStatement stmt = this.getConnection().prepareStatement("Select * FROM narudzbe_pacijenata WHERE ime = ? ");
            stmt.setString(1,name);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                pacijent = row2object(rs);
                rs.close();
            }
        } catch (SQLException e) {
            throw new SmartDentistException(e.getMessage(),e);
        }
        return pacijent;
    }


}

