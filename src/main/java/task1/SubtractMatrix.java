package task1;

public final class SubtractMatrix extends ArrayPI {

    public static void compute() {
        int[][] m1 = loadMatrix("matrix1");
        int[][] m2 = loadMatrix("matrix2");
        if (m1 == null || m2 == null) { System.out.println("Сначала введите матрицы (пункт 3)."); return; }

        int[][] result = new int[7][7];
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++)
                result[i][j] = m1[i][j] - m2[i][j];

        printMatrix("Разность (matrix1 - matrix2)", result);
        saveMatrix("difference", result);
    }
}
