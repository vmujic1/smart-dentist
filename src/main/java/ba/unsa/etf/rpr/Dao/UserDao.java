package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.sql.PreparedStatement;
import java.util.StringTokenizer;

/**
 * Dao interface for User domain bean
 *
 * @author Vedran Mujic
 */
public interface UserDao extends Dao<User>{
    public User getByUsername(String username) throws SmartDentistException;

}
