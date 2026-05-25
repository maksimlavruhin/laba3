package task1;

public final class Multiply extends ArrayPI {

    public static void compute() {
        int[][] m1 = loadMatrix("matrix1");
        int[][] m2 = loadMatrix("matrix2");
        if (m1 == null || m2 == null) { System.out.println("Сначала введите матрицы (пункт 3)."); return; }

        int[][] result = new int[7][7];
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++)
                for (int k = 0; k < 7; k++)
                    result[i][j] += m1[i][k] * m2[k][j];

        printMatrix("Произведение (matrix1 × matrix2)", result);
        saveMatrix("product", result);
    }
}
