package DAO;

public class DaoFactory {
    private static Users usersDao;

    public static Users getUserDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao();
        }

        return usersDao;
    }
}
