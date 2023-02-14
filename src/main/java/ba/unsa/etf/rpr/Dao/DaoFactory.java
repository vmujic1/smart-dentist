package ba.unsa.etf.rpr.Dao;

public class DaoFactory {

    private static final UserDao userDao = new UserDaoSQLImpl();
    private static final NarudzbePacijenataDao narudzbeDao = new NarudzbePacijenataSQLImpl();
    private  static final MaterijaliDao materijaliDao = new MaterijaliSQLImpl();

    public static UserDao userDao(){
        return userDao;
    }
    public static NarudzbePacijenataDao narudzbePacijenataDao(){
        return narudzbeDao;
    }
    public static MaterijaliDao materijaliDao(){
        return materijaliDao;
    }
}
