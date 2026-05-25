package task3;

import java.sql.*;
import java.util.Scanner;

public final class GetByRowId extends GeometryBase {

    public static void run(Scanner sc) {
        System.out.print("Введите ID строки: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Неверный ID."); return;
        }

        String sql = "SELECT * FROM geom_factorial WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("\nЗапись id=" + id + ":");
                System.out.println("  Тип:        " + rs.getString("type"));
                System.out.println("  Описание:   " + rs.getString("description"));
                System.out.println("  Результат:  " + rs.getString("result"));
            } else {
                System.out.println("Запись с id=" + id + " не найдена.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка БД: " + e.getMessage());
        }
    }
}
