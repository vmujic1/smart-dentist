package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.util.List;

public class RasporedManager {

    public static List<NarudzbePacijenata> getAll() throws SmartDentistException{
        return DaoFactory.narudzbePacijenataDao().getAll();
    }

    public static void delete(int id) throws SmartDentistException {
        DaoFactory.narudzbePacijenataDao().delete(id);
    }

}
