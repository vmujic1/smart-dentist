package ba.unsa.etf.rpr.Dao;

public class DaoFactory {

    private static final UserDao userDao = UserDaoSQLImpl.getInstance();
    private static final NarudzbePacijenataDao narudzbeDao = NarudzbePacijenataSQLImpl.getInstance();
    private  static final MaterijaliDao materijaliDao = MaterijaliSQLImpl.getInstance();

    public static UserDao userDao(){
        return userDao;
    }
    public static NarudzbePacijenataDao narudzbePacijenataDao(){
        return narudzbeDao;
    }

}
