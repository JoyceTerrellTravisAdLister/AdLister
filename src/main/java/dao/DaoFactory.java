package dao;

import models.Ad;
import models.Category;

public class DaoFactory {
    private static Users usersDao = null;
    private static Ads adsDao = null;
    private static Categories categoriesDao = null;

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao();
        }

        return usersDao;
    }

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDAO();
        }

        return adsDao;
    }

    public static Categories getCategoriesDao() {
        if (categoriesDao == null) {
            categoriesDao = new MySQLCategoriesDao();
        }

        return categoriesDao;
    }
}
