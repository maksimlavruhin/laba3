package task1;

import java.util.Scanner;

public final class PowerMatrix extends ArrayPI {

    public static void compute(Scanner sc) {
        int[][] m1 = loadMatrix("matrix1");
        if (m1 == null) { System.out.println("Сначала введите матрицы (пункт 3)."); return; }

        System.out.print("Введите степень (целое число >= 1): ");
        int n;
        try {
            n = Integer.parseInt(sc.nextLine().trim());
            if (n < 1) { System.out.println("Степень должна быть >= 1."); return; }
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод."); return;
        }

        int[][] result = matrixPow(m1, n);
        printMatrix("matrix1 в степени " + n, result);
        saveMatrix("power_" + n, result);
    }

    private static int[][] matrixPow(int[][] m, int n) {
        int[][] result = identity();
        for (int p = 0; p < n; p++)
            result = multiplyMatrices(result, m);
        return result;
    }

    private static int[][] identity() {
        int[][] id = new int[7][7];
        for (int i = 0; i < 7; i++) id[i][i] = 1;
        return id;
    }

    private static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int[][] c = new int[7][7];
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++)
                for (int k = 0; k < 7; k++)
                    c[i][j] += a[i][k] * b[k][j];
        return c;
    }
}
