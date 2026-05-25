package task1;

import org.apache.poi.xssf.usermodel.*;
import java.io.*;
import java.sql.*;

public final class SaveToExcel extends ArrayPI {

    public static void save() {
        String fileName = "task1_matrix_ops.xlsx";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM matrix_ops ORDER BY id")) {

            XSSFWorkbook workbook = new XSSFWorkbook();
            System.out.println("\nДанные из таблицы matrix_ops:");

            while (rs.next()) {
                int    id   = rs.getInt("id");
                String name = rs.getString("name");
                String data = rs.getString("data");
                int[][] m   = csvToMatrix(data);

                XSSFSheet sheet = workbook.createSheet(id + "_" + name);
                sheet.createRow(0).createCell(0).setCellValue("Матрица: " + name + " (id=" + id + ")");

                System.out.println("\n--- " + name + " (id=" + id + ") ---");
                for (int i = 0; i < 7; i++) {
                    XSSFRow row = sheet.createRow(i + 1);
                    for (int j = 0; j < 7; j++) {
                        row.createCell(j).setCellValue(m[i][j]);
                        System.out.printf("%6d", m[i][j]);
                    }
                    System.out.println();
                }
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
}
