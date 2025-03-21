package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    private static final String URL = "jdbc:mysql://mysql-db:3306/mydatabase";

    private static final String USER = "appuser";
    private static final String PASSWORD = "apppassword";

    public static List<Double> getAverageValues() {
        List<Double> averages = new ArrayList<>();
        String query = "SELECT average FROM my_table";

        // Test connection first
        try (Connection testConn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Successfully connected to MySQL!");
        } catch (SQLException e) {
            System.out.println("Connection failed!"+ e.getMessage());
            e.printStackTrace();
            return averages;
        }

        // Original query logic
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                averages.add(rs.getDouble("average"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return averages;
    }
}
