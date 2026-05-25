package task3;

import java.sql.*;

public final class CreateTable extends GeometryBase {

    public static void create() {
        String sql = "CREATE TABLE IF NOT EXISTS geom_factorial (" +
                "id          SERIAL PRIMARY KEY, " +
                "type        VARCHAR(50), " +
                "description TEXT, " +
                "result      TEXT" +
                ")";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Таблица 'geom_factorial' создана (или уже существует).");
        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
