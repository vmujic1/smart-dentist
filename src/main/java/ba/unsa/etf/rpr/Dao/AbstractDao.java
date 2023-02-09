package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.Idable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class AbstractDao<T extends Idable> implements Dao<T> {
    private  static Connection connection = null;
    private String tableName;

    public AbstractDao(String tableName){
        this.tableName = tableName;
    }

    private static void createConnection(){
        if(AbstractDao.connection == null){
            try{
                Properties p = new Properties();
                p.load(ClassLoader.getSystemResource("application.properties").openStream());

                String url = p.getProperty("db.connencion_string");
                String username = p.getProperty("db.username");
                String password = p.getProperty("db.password");

                AbstractDao.connection = DriverManager.getConnection(url,username,password);
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(){
                    @Override
                    public void run(){
                        try{
                            connection.close();
                        }catch (SQLException e){
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public static Connection getConnection(){
        return AbstractDao.connection;
    }








}
