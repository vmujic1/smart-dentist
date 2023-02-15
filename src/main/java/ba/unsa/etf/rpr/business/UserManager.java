package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;

import java.util.List;

public class UserManager {

    public User add(User u) throws SmartDentistException {
        return DaoFactory.userDao().add(u);
    }

    public User getByUsername(String username) throws SmartDentistException{
        return DaoFactory.userDao().getByUsername(username);
    }

    public List<User> getAll() throws SmartDentistException{
        return DaoFactory.userDao().getAll();

    }

    public void delete(int id) throws SmartDentistException{
        DaoFactory.userDao().delete(id);
    }



}
