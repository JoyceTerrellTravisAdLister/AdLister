package dao;

public class DaoFactory {
    private static Users usersDao = null;

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao();
        }

        return usersDao;
    }
}
