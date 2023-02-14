package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.util.List;

public class RasporedManager {

    public List<NarudzbePacijenata> getAll() throws SmartDentistException{
        return DaoFactory.narudzbePacijenataDao().getAll();
    }

}
