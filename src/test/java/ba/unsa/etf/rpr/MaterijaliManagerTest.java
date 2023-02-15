package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.MaterijaliManager;
import ba.unsa.etf.rpr.domain.Materijali;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Class that provides tests for MaterijaliManager
 * @author vmujic1
 */


public class MaterijaliManagerTest {
    MaterijaliManager materijaliManager = new MaterijaliManager();
    @Test

    void materijaliGetAllTest() throws SmartDentistException {
        List<Materijali> lista = MaterijaliManager.getAll();
        Materijali m = new Materijali();
        m.setNaziv("Proba");
        m.setKoličina(Integer.parseInt("12"));
        materijaliManager.add(m);
        List<Materijali> lista1 = MaterijaliManager.getAll();
        materijaliManager.delete(m.getId());
        boolean kontrola = false;
        if(lista.size() + 1 == lista1.size()) kontrola = true;

        Assertions.assertTrue(kontrola);



    }





}
