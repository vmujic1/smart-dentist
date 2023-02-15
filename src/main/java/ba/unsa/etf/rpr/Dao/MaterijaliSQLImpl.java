package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.Materijali;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class MaterijaliSQLImpl extends AbstractDao<Materijali> implements MaterijaliDao{

    private static MaterijaliSQLImpl instance = null;
    MaterijaliSQLImpl() {
        super("materijali");
    }

    public static MaterijaliSQLImpl getInstance(){
        if(instance == null)
            instance = new MaterijaliSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance != null)
            instance = null;
    }


    @Override
    public Materijali row2object(ResultSet rs) throws SmartDentistException {
        try {
            Materijali materijali = new Materijali();
            materijali.setId(rs.getInt("id"));
            materijali.setNaziv(rs.getString("naziv"));
            materijali.setKoličina(rs.getInt("kolicina"));
            return materijali;
        } catch (SQLException e){
            throw new SmartDentistException(e.getMessage(),e);
        }
    }

    @Override
    public Map<String, Object> object2row(Materijali object) {

        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("naziv", object.getNaziv());
        row.put("kolicina", object.getKoličina());
        return row;
    }

    @Override
    public Materijali getByName(String name) throws SmartDentistException {
        Materijali m = new Materijali();
        try{
            PreparedStatement stmt = this.getConnection().prepareStatement("Select * FROM materijali WHERE naziv = ? ");
            stmt.setString(1,name);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                m = row2object(rs);
                rs.close();
            }
        } catch (SQLException e) {
            throw new SmartDentistException(e.getMessage(),e);
        }
        return m;
    }
}
