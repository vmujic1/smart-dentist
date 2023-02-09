package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.util.List;

/**
 * Root interface for all DAO classes
 * @author Vedran Mujic
 */
public interface Dao<T> {

    /**
     * get entity from database base on ID
     * @param id primary key of entity
     * @return Entity from database
     */
    T getById(int id) throws SmartDentistException;

    /**
     * Saves entity into database
     * @param item bean for saving to database
     * @return saved item with id field populated
     */
    T add(T item) throws SmartDentistException;

    /**
     * Updates entity in database based on id (primary) match.
     * @param item - bean to be updated. id must be populated
     * @return updated version of bean
     */
    T update(T item) throws SmartDentistException;

    /**
     * Delete of item from database with given id
     * @param id - primary key of entity
     */
    void delete(int id) throws SmartDentistException;

    /**
     * Lists all entities from database.
     * @return List of entities from database
     */
    List<T> getAll() throws SmartDentistException;


}
