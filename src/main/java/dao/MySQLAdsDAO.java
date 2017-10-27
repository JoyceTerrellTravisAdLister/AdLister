package dao;

import com.mysql.cj.jdbc.Driver;
import models.Ad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDAO implements Ads {
    private Connection connection = null;

    public MySQLAdsDAO() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUser(),
                    Config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    @Override
    public List<Ad> getAllAds() {
        List<Ad> ads = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads from the database", e);
        }

        return ads;
    }

    @Override
    public List<Ad> getAdsByUser(long id) {
        List<Ad> adsByUser = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                adsByUser.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads by a user from the database", e);
        }

        return adsByUser;
    }

    @Override
    public long insertAd(Ad ad) {
        long newId = 0;

        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO ads (user_id, title, description) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            rs.next();
            newId = rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting new ad into the database", e);
        }

        return newId;
    }

    @Override
    public Ad getAdById(long id) {
        Ad ad = null;

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                ad = new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad from the database", e);
        }

        return ad;
    }
}
