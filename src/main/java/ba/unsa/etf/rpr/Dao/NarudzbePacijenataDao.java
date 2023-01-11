package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.NarudzbePacijenata;

import java.util.Date;
import java.util.List;
/**
 * Dao interface for NarudzbePacijenata domain bean
 *
 * @author Vedran Mujic
 */
public interface NarudzbePacijenataDao extends Dao<NarudzbePacijenata>{

     /**
      * Returns all patients which have appointment at given date.
      *
      * @param  datum
      *
      * @return List
      *
      */
     List<NarudzbePacijenata> searchByDate(Date datum);
     /**
      * Returns all patients which have appointment using firstname and lastname.
      *
      * @param  ime i prezime
      *
      * @return List
      *
      */
     List<NarudzbePacijenata> searchByName(String ime, String prezime);

}
