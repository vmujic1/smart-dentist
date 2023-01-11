package ba.unsa.etf.rpr.Dao;

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
    T getById(int id);

    /**
     * Saves entity into database
     * @param item bean for saving to database
     * @return saved item with id field populated
     */
    T add(T item);

    /**
     * Updates entity in database based on id (primary) match.
     * @param item - bean to be updated. id must be populated
     * @return updated version of bean
     */
    T update(T item);

    /**
     * Delete of item from database with given id
     * @param id - primary key of entity
     */
    void delete(int id);

    /**
     * Lists all entities from database.
     * @return List of entities from database
     */
    List<T> getAll();


}
