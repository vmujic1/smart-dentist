package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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




    @Override
    public User row2object(ResultSet rs) throws SmartDentistException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(User object) {
        return null;
    }
}
