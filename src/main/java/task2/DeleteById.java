package task2;

import java.sql.*;
import java.util.Scanner;

public final class DeleteById extends Student {

    public static void run(Scanner sc) {
        System.out.print("Введите ID строки для удаления: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Неверный ID."); return;
        }

        String sql = "DELETE FROM students3 WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Студент с id=" + id + " удалён.");
            else          System.out.println("Студент с id=" + id + " не найден.");
        } catch (SQLException e) {
            System.out.println("Ошибка БД: " + e.getMessage());
        }
    }
}
