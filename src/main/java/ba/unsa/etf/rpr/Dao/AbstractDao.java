package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.Idable;

import java.sql.Connection;

public abstract class AbstractDao<T extends Idable> implements Dao<T> {
    private  static Connection connection = null;
    private String tableName;

    public AbstractDao(String tableName){
        this.tableName = tableName;
    }
}
