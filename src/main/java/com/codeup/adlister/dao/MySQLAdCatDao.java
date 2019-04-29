package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;

import java.sql.*;

public class MySQLAdCatDao implements AdCats {
        private Connection connection = null;

        public MySQLAdCatDao(Config config) {
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = DriverManager.getConnection(
                        config.getUrl(),
                        config.getUsername(),
                        config.getPassword()
                );
            } catch (SQLException e) {
                throw new RuntimeException("Error connecting to the database!", e);
            }
        }

    public String insert(long adId, long catId) {
        try {
            String insertQuery = "INSERT INTO ads_category(ad_id, category_id) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            stmt.setLong(1, adId);
            stmt.setLong(2, catId);
            stmt.executeUpdate();
            return "success";
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    public String delete(long adId){
        try {
            String deleteQuery = "DELETE FROM ads_category WHERE ad_id = ?";
            PreparedStatement stmt = connection.prepareStatement(deleteQuery);
            stmt.setLong(1, adId);
            stmt.executeUpdate();
            return "success";
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }
}
