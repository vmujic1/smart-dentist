package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.Idable;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 * Abstract class that implements basic DAO CRUD for every entity
 * @author vmujic1
 */
public abstract class AbstractDao <Type extends Idable> implements Dao<Type>{

    private Connection connection;
    private  String tableName;

    /**
     * Constructor for AbstractDao that sets connection name and calls specific method to create connection
     * @param tableName String
     */

    AbstractDao(String tableName){
        try{
            this.tableName = tableName;
            FileReader reader = new FileReader("db1.properties");
            Properties p = new Properties();
            p.load(reader);

            this.connection = DriverManager.getConnection(p.getProperty("db.url") , p.getProperty("db.username"), p.getProperty("db.password"));
        }catch (SQLException | IOException e){
            System.out.println("Unable to connect to the database!");
            e.printStackTrace();

        }
    }

    /**
     * Method that gets connection
     * @return connection
     *
     */
    public Connection getConnection(){
        return connection;
    }
    /**
     * Method for mapping ResultSet into Object
     * @param rs - result set from database
     * @return a Bean object for specific table
     * @throws SmartDentistException in case of problem with database
     */

    public abstract Type row2object(ResultSet rs) throws SmartDentistException;

    /**
     * Method for mapping Object into Map
     * @param object - a bean object for specific table
     * @return key, value sorted map of object
     */
    public abstract Map<String, Object> object2row(Type object);

    /**
     * Method that returns object with specified ID
     * @param id primary key of entity
     * @return object that has specified ID
     * @throws SmartDentistException
     */
    public Type getById(int id) throws SmartDentistException{
        String query = "SELECT * FROM " + this.tableName + " WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Type result = row2object(rs);
                rs.close();
                return result;

            } else {
                throw new RuntimeException("Object not found");
            }

        } catch (SQLException | SmartDentistException e) {
            throw new SmartDentistException(e.getMessage(), e);
        }
    }

    /**
     * Method that returns all objects from table
     * @return List of object from table
     * @throws SmartDentistException
     */
    public List<Type> getAll() throws SmartDentistException{
        String query = "SELECT * FROM " + tableName;
        List<Type> results = new LinkedList<>();

        try{
            PreparedStatement stmt = getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Type object = row2object(rs);
                results.add(object);
            }
            rs.close();
            return results;

        }catch (SQLException | SmartDentistException e){
            throw new SmartDentistException(e.getMessage(), e);
        }
    }

    /**
     * Method that deletes object from table with specified ID
     * @param id - primary key of entity
     * @throws SmartDentistException
     */
    public void delete(int id) throws SmartDentistException{
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";

        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();

        }catch (SQLException e){
            throw new SmartDentistException(e.getMessage(), e);
        }
    }

    /**
     * Method that adds given object in table
     * @param item bean for saving to database
     * @return Added object in table
     * @throws SmartDentistException
     */

    public Type add(Type item) throws SmartDentistException{
        Map<String, Object> row = object2row(item);
        Map.Entry<String, String> columns = prepareInsertParts(row);

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO ").append(tableName);
        builder.append(" (").append(columns.getKey()).append(") ");
        builder.append("VALUES (").append(columns.getValue()).append(")");

        try{
            PreparedStatement stmt = getConnection().prepareStatement(builder.toString(), Statement.RETURN_GENERATED_KEYS);

            int counter = 1;

            for (Map.Entry<String, Object> entry: row.entrySet()) {
                if (entry.getKey().equals("id")) continue;
                stmt.setObject(counter, entry.getValue());
                counter++;
            }
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            item.setId(rs.getInt(1));

            return item;

        }catch (SQLException e){
            throw new SmartDentistException(e.getMessage(), e);
        }
    }

    /**
     * Method that updates specified object in table
     * @param item - bean to be updated. id must be populated
     * @return object bean
     * @throws SmartDentistException
     */

    public Type update(Type item) throws SmartDentistException{
        Map<String, Object> row = object2row(item);
        String updateColumns = prepareUpdateParts(row);
        StringBuilder builder = new StringBuilder();

        builder.append("UPDATE ")
                .append(tableName)
                .append(" SET ")
                .append(updateColumns)
                .append(" WHERE id = ?");

        try{
            PreparedStatement stmt = getConnection().prepareStatement(builder.toString());

            int counter = 1;

            for (Map.Entry<String, Object> entry: row.entrySet()) {
                if (entry.getKey().equals("id")) continue;
                stmt.setObject(counter, entry.getValue());
                counter++;
            }
            stmt.setObject(counter, item.getId());
            stmt.executeUpdate();

            return item;

        }catch (SQLException e){
            throw new SmartDentistException(e.getMessage(), e);
        }
    }

    /**
     * Prepare sql query for insert
     * Example: (id,name) (?,?,?)
     * @param row - the row to be inserted
     * @return map in which the query for insert was created
     */
    private Map.Entry<String, String> prepareInsertParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();
        StringBuilder questions = new StringBuilder();

        int counter = 0;

        for (Map.Entry<String, Object> entry: row.entrySet()) {
            counter++;

            if (entry.getKey().equals("id")) continue;
            columns.append(entry.getKey());
            questions.append("?");

            if (row.size() != counter) {
                columns.append(",");
                questions.append(",");
            }
        }

        return new AbstractMap.SimpleEntry<String,String>(columns.toString(), questions.toString());
    }

    /**
     * Prepare columns for update statement
     * Example: id=?, name=?
     * @param row - the row to be updated
     * @return map in which the query for update was created
     */
    private String prepareUpdateParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();

        int counter = 0;

        for (Map.Entry<String, Object> entry: row.entrySet()) {
            counter++;
            if (entry.getKey().equals("id")) continue; //skip update of id due where clause
            columns.append(entry.getKey()).append("= ?");
            if (row.size() != counter) {
                columns.append(",");
            }
        }

        return columns.toString();
    }

}
