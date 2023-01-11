package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.NarudzbePacijenata;

import java.util.Date;
import java.util.List;

public interface NarudzbePacijenataDao extends Dao<NarudzbePacijenata>{

     List<NarudzbePacijenata> searchByDate(Date datum);
     List<NarudzbePacijenata> searchByName(String ime, String prezime);

}
