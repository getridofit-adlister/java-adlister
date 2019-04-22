import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                Config.getUrl(),
                Config.getUsername(),
                Config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error", e);

        }
    }

    @Override
    public List<Ad> all() {
        Statement stmt;

        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            return createAdsFromResult(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error", e);
        }
    }

    @Override
    public Long insert(Ad ad) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error", e);
        }
    }

    private String createInsertQuery(Ad ad) {
        return "INSERT INTO ads(user_id, title, description) VALUES" +
                "(" + ad.getUserId() + ", " +
                "'" + ad.getTitle() + "', " +
                "'" + ad.getDescription() + "')";
    }

    private Ad showAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResult(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while(rs.next()) {
            ads.add(showAd(rs));
        }
        return ads;
    }
}
