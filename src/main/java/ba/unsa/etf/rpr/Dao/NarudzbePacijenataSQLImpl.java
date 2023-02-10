package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.sql.ResultSet;
import java.util.Map;

public class NarudzbePacijenataSQLImpl extends AbstractDao<NarudzbePacijenata> implements NarudzbePacijenataDao{

    private static NarudzbePacijenataDao instance = null;

    private NarudzbePacijenataSQLImpl(){
        super("narudzbe pacijenata");
    }




    @Override
    public NarudzbePacijenata row2object(ResultSet rs) throws SmartDentistException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(NarudzbePacijenata object) {
        return null;
    }
}
