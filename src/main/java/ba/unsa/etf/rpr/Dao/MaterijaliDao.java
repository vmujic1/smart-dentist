package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.Materijali;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

/**
 * Dao interface for Materijali domain bean
 *
 * @author Vedran Mujić
 */

public interface MaterijaliDao extends Dao<Materijali>{

    public Materijali getByName(String name) throws SmartDentistException;


}
