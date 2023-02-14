package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Materijali;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.util.List;

public class MaterijaliManager {
    public static List<Materijali> getAll() throws SmartDentistException {
        return DaoFactory.materijaliDao().getAll();
    }

    public static Materijali add(Materijali a) throws SmartDentistException{
        return DaoFactory.materijaliDao().add(a);
    }
}
