package task3;

import java.util.Scanner;

public final class SolveTask extends GeometryBase {

    public static void run(Scanner sc) {
        solveTriangle(sc);
        solveFactorial(sc);
    }

    private static void solveTriangle(Scanner sc) {
        System.out.println("\n--- Подзадача 1: Треугольник ---");
        System.out.println("Выберите тип треугольника:");
        System.out.println("  1 - Обычный (три стороны)");
        System.out.println("  2 - Прямоугольный (два катета)");
        System.out.print("Ваш выбор: ");
        String type = sc.nextLine().trim();

        if ("2".equals(type)) {
            System.out.print("Введите катет a: ");
            double a = readDouble(sc);
            System.out.print("Введите катет b: ");
            double b = readDouble(sc);

            RightTriangle rt = new RightTriangle(a, b);
            rt.printInfo();

            String desc = String.format("Прямоугольный треугольник: катеты a=%.2f, b=%.2f", a, b);
            String res  = String.format("Гипотенуза=%.4f, Периметр=%.4f, Площадь=%.4f",
                    rt.hypotenuse(), rt.perimeter(), rt.area());
            saveResult("RightTriangle", desc, res);

        } else {
            System.out.print("Введите сторону a: ");
            double a = readDouble(sc);
            System.out.print("Введите сторону b: ");
            double b = readDouble(sc);
            System.out.print("Введите сторону c: ");
            double c = readDouble(sc);

            if (a + b <= c || a + c <= b || b + c <= a) {
                System.out.println("Ошибка: такой треугольник не существует.");
                return;
            }

            Triangle t = new Triangle(a, b, c);
            t.printInfo();

            String desc = String.format("Треугольник: a=%.2f, b=%.2f, c=%.2f", a, b, c);
            String res  = String.format("Периметр=%.4f, Площадь=%.4f", t.perimeter(), t.area());
            saveResult("Triangle", desc, res);
        }
    }

    private static void solveFactorial(Scanner sc) {
        System.out.println("\n--- Подзадача 2: Чётные и нечётные факториалы ---");
        System.out.print("Введите число n (факториалы чисел от 1 до n): ");
        int n;
        try {
            n = Integer.parseInt(sc.nextLine().trim());
            if (n < 1) { System.out.println("n должно быть >= 1."); return; }
            if (n > 12) { System.out.println("n > 12 может переполнить long. Устанавливаю 12."); n = 12; }
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод."); return;
        }

        String evenRes = FactorialCalc.evenFactorials(n);
        String oddRes  = FactorialCalc.oddFactorials(n);

        System.out.println("Чётные факториалы: " + evenRes);
        System.out.println("Нечётные факториалы: " + oddRes);

        saveResult("EvenFactorials", "Чётные факториалы до n=" + n, evenRes);
        saveResult("OddFactorials",  "Нечётные факториалы до n=" + n, oddRes);
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Неверный ввод, повторите: ");
            }
        }
    }
}
