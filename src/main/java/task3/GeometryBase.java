package task3;

import java.sql.*;

public class GeometryBase {

    static final String URL      = "jdbc:postgresql://localhost:5432/javalab";
    static final String USER     = "postgres";
    static final String PASSWORD = "postgres";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    protected static void saveResult(String type, String description, String result) {
        String sql = "INSERT INTO geom_factorial (type, description, result) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, type);
            ps.setString(2, description);
            ps.setString(3, result);
            ps.executeUpdate();
            System.out.println("Сохранено в базу данных.");
        } catch (SQLException e) {
            System.out.println("Ошибка БД: " + e.getMessage());
        }
    }
}
