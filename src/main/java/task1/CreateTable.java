package task1;

import java.sql.*;

public final class CreateTable extends ArrayPI {

    public static void create() {
        String sql = "CREATE TABLE IF NOT EXISTS matrix_ops (" +
                "id   SERIAL PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "data TEXT" +
                ")";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Таблица 'matrix_ops' создана (или уже существует).");
        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
