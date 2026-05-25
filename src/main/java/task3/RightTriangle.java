package task3;

public class RightTriangle extends Triangle {

    public RightTriangle(double legA, double legB) {
        super(legA, legB, Math.sqrt(legA * legA + legB * legB));
    }

    public double hypotenuse() {
        return c;
    }

    @Override
    public void printInfo() {
        System.out.printf("Катеты: a=%.2f, b=%.2f%n", a, b);
        System.out.printf("Гипотенуза: c=%.4f%n", hypotenuse());
        System.out.printf("Периметр: %.4f%n", perimeter());
        System.out.printf("Площадь:  %.4f%n", area());
        System.out.println("Прямоугольный треугольник: да");
    }
}
