package task3;

public class Triangle {

    protected double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a; this.b = b; this.c = c;
    }

    public double perimeter() {
        return a + b + c;
    }

    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public void printInfo() {
        System.out.printf("Стороны: a=%.2f, b=%.2f, c=%.2f%n", a, b, c);
        System.out.printf("Периметр: %.4f%n", perimeter());
        System.out.printf("Площадь:  %.4f%n", area());
    }
}
