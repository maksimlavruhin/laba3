package task1;

import java.sql.*;

public class ArrayPI {

    static final String URL      = "jdbc:postgresql://localhost:5432/javalab";
    static final String USER     = "postgres";
    static final String PASSWORD = "postgres";

    protected static int[][] matrix1 = new int[7][7];
    protected static int[][] matrix2 = new int[7][7];

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    protected static String matrixToCsv(int[][] m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++) {
                if (sb.length() > 0) sb.append(",");
                sb.append(m[i][j]);
            }
        return sb.toString();
    }

    protected static int[][] csvToMatrix(String csv) {
        String[] parts = csv.split(",");
        int[][] m = new int[7][7];
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++)
                m[i][j] = Integer.parseInt(parts[i * 7 + j]);
        return m;
    }

    protected static void printMatrix(String title, int[][] m) {
        System.out.println(title + ":");
        for (int[] row : m) {
            for (int v : row) System.out.printf("%6d", v);
            System.out.println();
        }
    }

    protected static void saveMatrix(String name, int[][] m) {
        String sql = "INSERT INTO matrix_ops (name, data) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, matrixToCsv(m));
            ps.executeUpdate();
            System.out.println("Матрица '" + name + "' сохранена в БД.");
        } catch (SQLException e) {
            System.out.println("Ошибка БД: " + e.getMessage());
        }
    }

    protected static int[][] loadMatrix(String name) {
        String sql = "SELECT data FROM matrix_ops WHERE name = ? ORDER BY id DESC LIMIT 1";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return csvToMatrix(rs.getString("data"));
        } catch (SQLException e) {
            System.out.println("Ошибка БД: " + e.getMessage());
        }
        return null;
    }
}
