package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Class that provides test for UserManager
 * @author vmujic1
 */

public class UserManagerTest {

    UserManager userManager = new UserManager();

    /**
     * Test that checks getByUsername method
     * @throws SmartDentistException
     */
    @Test
    void getByUsernameTest() throws SmartDentistException{
        User u1 = new User();
        u1.setUsername("Vedran");
        u1.setLozinka("sifra");
        u1.setBroj_zaposlenih("1");
        u1.setEmail("ww");
        u1.setKontakt_telefon("121");
        u1.setBroj_poslovnica("1");
        u1.setImeOrdinacije("wowo");
        u1.setAdresa("grge");
        userManager.add(u1);
        User u2 = userManager.getByUsername("Vedran");
        Assertions.assertEquals(u1,u2);
        userManager.delete(u1.getId());
    }

    /**
     * Test that checks deleteUser method
     * @throws SmartDentistException
     */
    @Test

    void deleteUserTest() throws  SmartDentistException{
        User u1 = new User();
        u1.setUsername("Vedran");
        u1.setLozinka("sifra");
        u1.setBroj_zaposlenih("1a");
        u1.setEmail("waw");
        u1.setKontakt_telefon("12a1");
        u1.setBroj_poslovnica("1a");
        u1.setImeOrdinacije("wowoa");
        u1.setAdresa("grgae");

        userManager.add(u1);
        userManager.delete(u1.getId());
        boolean kontrola = true;
        List<User> lista = userManager.getAll();
        for(User u : lista){
            if(u.getId() == u1.getId()) kontrola = false;
        }

        Assertions.assertTrue(kontrola);

    }

    /**
     * Test that checks addUser method
     * @throws SmartDentistException
     */
    @Test

    void addUserTest() throws SmartDentistException{
        User u1 = new User();
        u1.setUsername("Vedran");
        u1.setLozinka("sifra");
        u1.setBroj_zaposlenih("1a");
        u1.setEmail("waw");
        u1.setKontakt_telefon("12a1");
        u1.setBroj_poslovnica("1a");
        u1.setImeOrdinacije("wowoa");
        u1.setAdresa("grgae");
        userManager.add(u1);
        List<User> lista = userManager.getAll();

        boolean kontrola = false;
        for(User u : lista){
            if(u.getId() == u1.getId()) kontrola = true;
        }
        userManager.delete(u1.getId());

    }

    /**
     * Test that checks update method
     * @throws SmartDentistException
     */

    @Test
    void userUpdateTest() throws SmartDentistException{
        User u1 = new User();
        u1.setUsername("Vedran");
        u1.setLozinka("sifra");
        u1.setBroj_zaposlenih("1a");
        u1.setEmail("waw");
        u1.setKontakt_telefon("12a1");
        u1.setBroj_poslovnica("1a");
        u1.setImeOrdinacije("wowoa");
        u1.setAdresa("grgae");
        userManager.add(u1);
        u1.setUsername("LAV");
        userManager.update(u1);
        List<User> lista = userManager.getAll();
        userManager.delete(u1.getId());
        boolean kontrola = false;
        for(User u : lista){
            if(u.getId() == u1.getId() && u.getUsername().equals(u1.getUsername())) kontrola = true;
        }

        Assertions.assertTrue(kontrola);

    }

    /**
     * Test that checks getAll method
     * @throws SmartDentistException
     */

    @Test

    void userGetAllTest() throws SmartDentistException{
        List<User> lista = userManager.getAll();
        User u1 = new User();
        u1.setUsername("Vedran");
        u1.setLozinka("sifra");
        u1.setBroj_zaposlenih("1a");
        u1.setEmail("waw");
        u1.setKontakt_telefon("12a1");
        u1.setBroj_poslovnica("1a");
        u1.setImeOrdinacije("wowoa");
        u1.setAdresa("grgae");
        userManager.add(u1);
        List<User> lista1 = userManager.getAll();
        userManager.delete(u1.getId());
        boolean kontrola = false;
        if(lista.size() + 1 == lista1.size()) kontrola = true;

        Assertions.assertTrue(kontrola);



    }






}
