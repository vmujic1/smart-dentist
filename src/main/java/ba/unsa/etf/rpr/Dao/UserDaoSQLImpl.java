package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{

    private static UserDaoSQLImpl instance = null;

    private UserDaoSQLImpl(){
        super("users");
    }

    public static UserDaoSQLImpl getInstance(){
        if(instance == null)
            instance = new UserDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance != null) instance=null;
    }




    @Override
    public User row2object(ResultSet rs) throws SmartDentistException {
        try{
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
            return user;
        } catch (SQLException e){
            throw new SmartDentistException(e.getMessage(),e);
        }
    }

    @Override
    public Map<String, Object> object2row(User object) {
        Map<String,Object> row = new TreeMap<>();
        row.put("id",object.getId());
        row.put("ime_ordinacije",object.getImeOrdinacije());
        row.put("username",object.getUsername());
        row.put("lozinka",object.getLozinka());
        row.put("broj_zaposlenih",object.getBroj_zaposlenih());
        row.put("adresa",object.getAdresa());
        row.put("email",object.getEmail());
        row.put("kontakt_telefon",object.getKontakt_telefon());
        row.put("broj_poslovnica",object.getBroj_poslovnica());
        return row;
    }


}
