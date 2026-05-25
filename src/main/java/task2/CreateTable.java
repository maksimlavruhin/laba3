package task2;

import java.sql.*;

public final class CreateTable extends Student {

    public static void create() {
        String sql = "CREATE TABLE IF NOT EXISTS students3 (" +
                "id         SERIAL PRIMARY KEY, " +
                "student_id VARCHAR(20), " +
                "direction  VARCHAR(100), " +
                "full_name  VARCHAR(100), " +
                "grp        VARCHAR(50)" +
                ")";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Таблица 'students3' создана (или уже существует).");
        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
