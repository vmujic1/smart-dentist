package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.User;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class UserDaoSQLImpl implements UserDao{
    public Connection connection;

    public UserDaoSQLImpl(){
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
    public User getById(int id) {
        return null;
    }

    @Override
    public User add(User item) {
        return null;
    }

    @Override
    public User update(User item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
