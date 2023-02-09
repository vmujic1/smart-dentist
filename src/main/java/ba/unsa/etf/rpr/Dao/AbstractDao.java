package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.Idable;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.sql.*;
import java.util.List;
import java.util.Map;
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

    /**
     * Method for mapping ResultSet into Object
     * @param rs - result set from database
     * @return a Bean object for specific table
     * @throws SmartDentistException in case of error with db
     */
    public abstract T row2object(ResultSet rs) throws SmartDentistException;

    /**
     * Method for mapping Object into Map
     * @param object - a bean object for specific table
     * @return key, value sorted map of object
     */
    public abstract Map<String, Object> object2row(T object);

    public  T getById(int id) throws SmartDentistException {
        return executeQueryUnique("SELECT * FROM " + this.tableName + " WHERE id = ?", new Object[]{id});
    }

    public List<T> getAll() throws SmartDentistException{
        return executeQuerry("SELECT * FROM " + tableName, null);
    }

    public void delete(int id) throws SmartDentistException{
        String query = "DELETE FROM " + tableName + " WHERE id = ?";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1,id);
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new SmartDentistException(e.getMessage(),e);
        }
        
    }



}
