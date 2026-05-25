package task1;

import java.util.Scanner;

public final class InputMatrices extends ArrayPI {

    public static void run(Scanner sc) {
        System.out.println("Введите матрицу 1 (7 строк по 7 чисел через пробел):");
        matrix1 = readMatrix(sc, "Матрица 1");

        System.out.println("Введите матрицу 2 (7 строк по 7 чисел через пробел):");
        matrix2 = readMatrix(sc, "Матрица 2");

        printMatrix("Матрица 1", matrix1);
        saveMatrix("matrix1", matrix1);

        printMatrix("Матрица 2", matrix2);
        saveMatrix("matrix2", matrix2);
    }

    private static int[][] readMatrix(Scanner sc, String label) {
        int[][] m = new int[7][7];
        for (int i = 0; i < 7; i++) {
            System.out.print("  " + label + ", строка " + (i + 1) + ": ");
            String[] parts = sc.nextLine().trim().split("\\s+");
            for (int j = 0; j < Math.min(parts.length, 7); j++) {
                try { m[i][j] = Integer.parseInt(parts[j]); }
                catch (NumberFormatException e) { m[i][j] = 0; }
            }
        }
        return m;
    }
}
