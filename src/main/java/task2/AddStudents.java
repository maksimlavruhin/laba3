package task2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class AddStudents extends Student {

    public static void run(Scanner sc) {
        System.out.print("Сколько студентов ввести (минимум 5)? ");
        int count;
        try {
            count = Integer.parseInt(sc.nextLine().trim());
            if (count < 5) { System.out.println("Минимум 5. Устанавливаю 5."); count = 5; }
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод. Устанавливаю 5."); count = 5;
        }

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("\nСтудент " + (i + 1) + ":");
            Student s = (i % 2 == 0) ? new StudentFull() : new StudentShort();
            s.inputData(sc);
            students.add(s);

            String sql = "INSERT INTO students3 (student_id, direction, full_name, grp) VALUES (?, ?, ?, ?)";
            try (Connection conn = getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, s.getStudentId());
                ps.setString(2, s.getDirection());
                ps.setString(3, s.getFullName());
                ps.setString(4, s.getGroup());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Ошибка БД: " + e.getMessage());
            }
        }

        System.out.println("\n--- Полиморфный вывод (StudentFull/StudentShort) ---");
        System.out.printf("%-10s %-30s %-40s %-10s%n", "ID", "Направление", "ФИО", "Группа");
        System.out.println("-".repeat(95));
        for (Student s : students) s.showInfo();
        System.out.println("\nВсе студенты сохранены в базу данных.");
    }
}
