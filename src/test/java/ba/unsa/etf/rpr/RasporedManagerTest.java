package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.RasporedManager;
import ba.unsa.etf.rpr.controllers.RasporedDodajController;
import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that provides test for RasporedManager
 * @author vmujic1
 */

public class RasporedManagerTest {

    RasporedManager rasporedManager = new RasporedManager();

    /**
     * Test that checks add in narudzbe_materijala method
     * @throws SmartDentistException
     */

    @Test
    void addRasporedTest() throws SmartDentistException{
        NarudzbePacijenata n = new NarudzbePacijenata();
        n.setIme("PotrebeTesta");
        n.setPrezime("Test");
        n.setPovod("Kontrola");
        n.setDatum(LocalDate.now());
        RasporedManager.add(n);
        List<NarudzbePacijenata> lista = RasporedManager.getAll();
        RasporedManager.delete(n.getId());
        boolean kontrola = false;
        for(NarudzbePacijenata n1 : lista ){
            if(n.getId() == n.getId()) kontrola = true;
        }
        Assertions.assertTrue(kontrola);
    }

    /**
     * Test that checks getByDate from narudzbe_materijala method
     * @throws SmartDentistException
     */

    @Test

    void getByDateRasporedTest() throws SmartDentistException{
        List<NarudzbePacijenata> nlista = new ArrayList<>();
        NarudzbePacijenata n = new NarudzbePacijenata();
        n.setIme("PotrebeTesta");
        n.setPrezime("Test");
        n.setPovod("Kontrola");
        n.setDatum(LocalDate.now());
        nlista.add(n);
        RasporedManager.add(n);
        List<NarudzbePacijenata> n1 = RasporedManager.getByDate(n.getDatum());
        RasporedManager.delete(n.getId());
        boolean kontrola = false;
        if(nlista.size() == n1.size()) kontrola = true;
        Assertions.assertTrue(kontrola);

    }

    /**
     * Test that checks getByName from narudzbe_materijala method
     * @throws SmartDentistException
     */

    @Test

    void getByNameRasporedTest() throws SmartDentistException{
        NarudzbePacijenata n = new NarudzbePacijenata();
        n.setIme("PotrebeTesta");
        n.setPrezime("Test");
        n.setPovod("Kontrola");
        n.setDatum(LocalDate.now());
        RasporedManager.add(n);
        NarudzbePacijenata n1 = RasporedManager.getByName(n.getIme());
        RasporedManager.delete(n.getId());
        Assertions.assertEquals(n,n1);


    }

    /**
     * Test that checks  getAll from narudzbe_materijala  method
     * @throws SmartDentistException
     */

    @Test

    void rasporedGetAllTest() throws SmartDentistException{
        List<NarudzbePacijenata> lista = RasporedManager.getAll();
        NarudzbePacijenata n = new NarudzbePacijenata();
        n.setIme("PotrebeTesta");
        n.setPrezime("Test");
        n.setPovod("Kontrola");
        n.setDatum(LocalDate.now());
        RasporedManager.add(n);
        List<NarudzbePacijenata> lista1 = RasporedManager.getAll();
        RasporedManager.delete(n.getId());
        boolean kontrola = false;
        if(lista.size() + 1 == lista1.size()) kontrola = true;

        Assertions.assertTrue(kontrola);



    }

    /**
     * Test that checks delete from narudzbe_materijala method
     * @throws SmartDentistException
     */
    @Test

    void deleteRasporedTest() throws  SmartDentistException{
        NarudzbePacijenata n = new NarudzbePacijenata();
        n.setIme("PotrebeTesta");
        n.setPrezime("Test");
        n.setPovod("Kontrola");
        n.setDatum(LocalDate.now());
        RasporedManager.add(n);
        RasporedManager.delete(n.getId());
        boolean kontrola = true;
        List<NarudzbePacijenata> lista = RasporedManager.getAll();
        for(NarudzbePacijenata u : lista){
            if(u.getId() == n.getId()) kontrola = false;
        }

        Assertions.assertTrue(kontrola);

    }

    /**
     * Mocking test that checks jeLiDatumPrijeDanasnjeg method from RasporedDodajController
     * @throws SmartDentistException
     */
    @Test

    void jeLiDatumPrijeDanasnjegTest() throws SmartDentistException{
        RasporedManager mockU = Mockito.mock(RasporedManager.class);
        Mockito.when(mockU.getById(0)).thenReturn(new NarudzbePacijenata("TestnoIme","TestnoPrezime", LocalDate.of(2022,01,01),"br"));
        Assertions.assertTrue(RasporedDodajController.jeLiDatumPrijeDanasnjeg(mockU.getById(0).getDatum()));

    }





}
