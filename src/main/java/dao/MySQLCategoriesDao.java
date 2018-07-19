package dao;

import com.mysql.cj.jdbc.Driver;
import com.sun.xml.internal.ws.policy.spi.PrefixMapper;
import models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
    private Connection connection;

    public MySQLCategoriesDao() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUser(),
                    Config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the Categories table", e);
        }
    }

    @Override
    public List<Category> getAll() {
        List<Category> allCategories = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            createCategoryList(allCategories, rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all categories", e);
        }

        return allCategories;
    }

    @Override
    public List<Category> getCategoriesByAdId(long id) {
        List<Category> adsCategories = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM categories " +
                    "WHERE id IN (" +
                                "SELECT category_id " +
                                "FROM ads_categories " +
                                "WHERE ad_id = ?" +
                            ")"
            );

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            createCategoryList(adsCategories, rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving the categories associated with an ad", e);
        }

        return adsCategories;
    }

    private void createCategoryList(List<Category> adsCategories, ResultSet rs) throws SQLException {
        while(rs.next()) {
            Category category = new Category();
            category.setId(rs.getLong("id"));
            category.setName(rs.getString("name"));
            adsCategories.add(category);
        }
    }

    @Override
    public Category getCategoryById(long id) {
        Category category = new Category();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM categories WHERE id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                category.setId(rs.getLong("id"));
                category.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving the category by its ID", e);
        }

        return category;
    }

    @Override
    public long insert(Category categoryToInsert) {
        long newId = 0;

        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO categories (name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            stmt.setString(1, categoryToInsert.getName());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                newId = rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting new category", e);
        }

        return newId;
    }

    @Override
    public void assignCategoryToAd(long category_id, long ad_id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO ads_categories VALUES (?, ?)");
            stmt.setLong(1, ad_id);
            stmt.setLong(2, category_id);
            if(stmt.execute() == false) {
                throw new RuntimeException("Unknown error while assigning a category to an ad");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while assigning a category to an ad", e);
        }
    }
}
