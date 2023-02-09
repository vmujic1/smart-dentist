package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.domain.Materijali;

import java.util.List;

public interface MaterijaliDao extends Dao<Materijali>{
    /**
     * Returns all materials by namre.
     *
     * @param  ime
     *
     * @return List
     *
     */
    Materijali searchByName(String ime);

    List<Materijali> searchByKolicina(int kolicina1);

    
}
