package task3;

public class FactorialCalc {

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    public static String evenFactorials(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i += 2) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(i).append("!=").append(factorial(i));
        }
        return sb.length() > 0 ? sb.toString() : "(нет чётных чисел)";
    }

    public static String oddFactorials(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i += 2) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(i).append("!=").append(factorial(i));
        }
        return sb.length() > 0 ? sb.toString() : "(нет нечётных чисел)";
    }
}
