package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.Idable;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public abstract class AbstractDao <Type extends Idable> implements Dao<Type>{

    private Connection connection;
    private  String tableName;

    AbstractDao(String tableName){
        try{
            this.tableName = tableName;
            FileReader reader = new FileReader("db.properties");
            Properties p = new Properties();
            p.load(reader);

            this.connection = DriverManager.getConnection(p.getProperty("db.url") , p.getProperty("db.username"), p.getProperty("db.password"));
        }catch (SQLException | IOException e){
            System.out.println("Unable to connect to the database!");
            e.printStackTrace();

        }
    }

    public Connection getConnection(){
        return connection;
    }

    public abstract Type row2object(ResultSet rs) throws SmartDentistException;

    public abstract Map<String, Object> object2row(Type object);

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
