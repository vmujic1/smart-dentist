package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.Materijali;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MaterijaliSQLImpl extends AbstractDao<Materijali> implements MaterijaliDao{

    private static MaterijaliSQLImpl instance = null;
    private MaterijaliSQLImpl() {
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
        return null;
    }
}
