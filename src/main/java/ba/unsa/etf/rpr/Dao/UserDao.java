package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.User;

/**
 * Dao interface for User domain bean
 *
 * @author Vedran Mujic
 */
public interface UserDao extends Dao<User>{


    /**
     * Returns user with given username.
     *
     * @param text that represent username.
     * @return User object
     */
    User searchByUsername(String text);

    /**
     * Returns user with given Ordination name.
     *
     * @param text that represent Ordination name.
     * @return User object
     */
    User searchByOrdinationUsername(String text);
}
