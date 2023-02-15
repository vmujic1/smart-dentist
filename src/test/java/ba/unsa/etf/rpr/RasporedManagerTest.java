package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.RasporedManager;
import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that provides test for RasporedManager
 * @author vmujic1
 */

public class RasporedManagerTest {

    RasporedManager rasporedManager = new RasporedManager();

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




}
