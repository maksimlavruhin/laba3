package task3;

import org.apache.poi.xssf.usermodel.*;
import java.io.*;
import java.sql.*;

public final class SaveToExcel extends GeometryBase {

    public static void save() {
        String fileName = "task3_geom_factorial.xlsx";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM geom_factorial ORDER BY id")) {

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Результаты");

            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Тип");
            header.createCell(2).setCellValue("Описание");
            header.createCell(3).setCellValue("Результат");

            System.out.println("\nДанные из таблицы geom_factorial:");
            System.out.printf("%-5s %-18s %-40s %-50s%n", "ID", "Тип", "Описание", "Результат");
            System.out.println("-".repeat(115));

            int rowNum = 1;
            while (rs.next()) {
                int    id   = rs.getInt("id");
                String type = rs.getString("type");
                String desc = rs.getString("description");
                String res  = rs.getString("result");

                XSSFRow row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(id);
                row.createCell(1).setCellValue(type);
                row.createCell(2).setCellValue(desc);
                row.createCell(3).setCellValue(res);

                System.out.printf("%-5d %-18s %-40s %-50s%n",
                        id, cut(type, 16), cut(desc, 38), cut(res, 48));
            }

            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                workbook.write(fos);
            }
            workbook.close();
            System.out.println("\nФайл сохранён: " + fileName);

        } catch (SQLException e) {
            System.out.println("Ошибка БД: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка файла: " + e.getMessage());
        }
    }

    private static String cut(String s, int max) {
        if (s == null) return "";
        return s.length() > max ? s.substring(0, max - 1) + "…" : s;
    }
}
