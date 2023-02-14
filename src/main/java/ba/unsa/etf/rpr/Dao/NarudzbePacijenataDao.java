package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.time.LocalDate;
import java.util.List;
/**
 * Dao interface for NarudzbePacijenata domain bean
 *
 * @author Vedran Mujic
 */
public interface NarudzbePacijenataDao extends Dao<NarudzbePacijenata>{

 public List<NarudzbePacijenata> getByDate(LocalDate date) throws SmartDentistException;

}
