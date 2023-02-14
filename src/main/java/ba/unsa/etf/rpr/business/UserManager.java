package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

public class UserManager {

    public User add(User u) throws SmartDentistException {
        return DaoFactory.userDao().add(u);
    }

    public User getByUsername(String username) throws SmartDentistException{
        return DaoFactory.userDao().getByUsername(username);
    }



}
