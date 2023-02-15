package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.MaterijaliManager;
import ba.unsa.etf.rpr.controllers.MaterijaliDodajController;
import ba.unsa.etf.rpr.domain.Materijali;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * Class that provides tests for MaterijaliManager
 * @author vmujic1
 */


public class MaterijaliManagerTest {
    MaterijaliManager materijaliManager = new MaterijaliManager();

    /**
     * Test that checks getAll method from narudzbe_materijala
     * @throws SmartDentistException
     */
    @Test

    void materijaliGetAllTest() throws SmartDentistException {
        List<Materijali> lista = MaterijaliManager.getAll();
        Materijali m = new Materijali();
        m.setNaziv("Proba");
        m.setKoličina(Integer.parseInt("12"));
        MaterijaliManager.add(m);
        List<Materijali> lista1 = MaterijaliManager.getAll();
        MaterijaliManager.delete(m.getId());
        boolean kontrola = lista.size() + 1 == lista1.size();

        Assertions.assertTrue(kontrola);



    }

    /**
     * Test that checks add method from narudzbe_materijala
     * @throws SmartDentistException
     */
    @Test

    void addMaterijaliTest() throws SmartDentistException{
        Materijali m = new Materijali();
        m.setNaziv("Proba");
        m.setKoličina(Integer.parseInt("12"));
        MaterijaliManager.add(m);
        List<Materijali> lista = MaterijaliManager.getAll();

        boolean kontrola = false;
        for(Materijali u : lista){
            if (u.getId() == m.getId()) {
                kontrola = true;
                break;
            }
        }
        MaterijaliManager.delete(m.getId());
    }

    /**
     * Test that checks delete method from narudzbe_materijala
     * @throws SmartDentistException
     */

    @Test
    void deleteMaterijaliTest() throws  SmartDentistException{
        Materijali m = new Materijali();
        m.setNaziv("Proba");
        m.setKoličina(Integer.parseInt("12"));

        MaterijaliManager.add(m);
        MaterijaliManager.delete(m.getId());
        boolean kontrola = true;
        List<Materijali> lista = MaterijaliManager.getAll();
        for(Materijali u : lista){
            if (u.getId() == m.getId()) {
                kontrola = false;
                break;
            }
        }

        Assertions.assertTrue(kontrola);

    }

    /**
     * Test that checks update method from narudzbe_materijala
     * @throws SmartDentistException
     */
    @Test
    void materijaliUpdateTest() throws SmartDentistException{
        Materijali m = new Materijali();
        m.setNaziv("Proba");
        m.setKoličina(Integer.parseInt("12"));

        MaterijaliManager.add(m);
        m.setNaziv("LAV");
        MaterijaliManager.update(m);
        List<Materijali> lista = MaterijaliManager.getAll();
        MaterijaliManager.delete(m.getId());
        boolean kontrola = false;
        for(Materijali u : lista){
            if (u.getId() == m.getId() && u.getNaziv().equals(m.getNaziv())) {
                kontrola = true;
                break;
            }
        }

        Assertions.assertTrue(kontrola);

    }

    /**
     * Test that checks getByNaziv method from narudzbe_materijala
     * @throws SmartDentistException
     */

    @Test
    void getByNazivTest() throws SmartDentistException{
        Materijali m = new Materijali();
        m.setNaziv("Proba");
        m.setKoličina(Integer.parseInt("12"));

        MaterijaliManager.add(m);
        Materijali m2 = MaterijaliManager.getByName(m.getNaziv());
        Assertions.assertEquals(m,m2);
        MaterijaliManager.delete(m.getId());
    }
    @Test
    void kolicinaIspravnaTest() throws SmartDentistException{
        MaterijaliManager mockU = Mockito.mock(MaterijaliManager.class);
        Mockito.when(mockU.getById(0)).thenReturn(new Materijali("lol",5));
        Assertions.assertTrue(MaterijaliDodajController.daLiJeKolicinaIspravna(mockU.getById(0).getKoličina()));

    }
}
