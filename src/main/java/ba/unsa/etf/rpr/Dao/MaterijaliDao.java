package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.Materijali;

import java.util.List;

public interface MaterijaliDao {

    List<Materijali> searchByName(String ime);

    
}
