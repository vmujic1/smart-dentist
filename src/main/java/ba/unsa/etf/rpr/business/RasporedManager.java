package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.time.LocalDate;
import java.util.List;

public class RasporedManager {

    public static List<NarudzbePacijenata> getAll() throws SmartDentistException{
        return DaoFactory.narudzbePacijenataDao().getAll();
    }

    public static void delete(int id) throws SmartDentistException {
        DaoFactory.narudzbePacijenataDao().delete(id);
    }

    public static NarudzbePacijenata add(NarudzbePacijenata a) throws SmartDentistException {
        return DaoFactory.narudzbePacijenataDao().add(a);
    }

    public static List<NarudzbePacijenata> getByDate(LocalDate date) throws SmartDentistException {
        return DaoFactory.narudzbePacijenataDao().getByDate(date);
    }

    public static NarudzbePacijenata getByName(String name) throws SmartDentistException{
        return DaoFactory.narudzbePacijenataDao().getByName(name);
    }

    public NarudzbePacijenata getById(int i) throws SmartDentistException {
        return DaoFactory.narudzbePacijenataDao().getById(i);
    }
}
