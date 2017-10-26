package dao;

public class DaoFactory {
    private static Users usersDao = null;

    public Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao();
        }

        return usersDao;
    }
}
