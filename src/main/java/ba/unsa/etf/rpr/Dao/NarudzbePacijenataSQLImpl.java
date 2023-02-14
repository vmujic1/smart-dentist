package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.sql.ResultSet;
import java.sql.SQLException;
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
            narudzbe.setDatum(rs.getDate("datum"));
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
}
