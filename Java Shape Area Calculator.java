// Base Class
abstract class Shape {
    public abstract double calculateArea();
    public abstract void displayDetails();
}

// Circle Subclass
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void displayDetails() {
        System.out.println("Circle:");
        System.out.println("Radius = " + radius);
        System.out.println("Area of Circle = " + calculateArea());
    }
}

// Rectangle Subclass
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public void displayDetails() {
        System.out.println("Rectangle:");
        System.out.println("Length = " + length + ", Width = " + width);
        System.out.println("Area of Rectangle = " + calculateArea());
    }
}

// Triangle Subclass
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public void displayDetails() {
        System.out.println("Triangle:");
        System.out.println("Base = " + base + ", Height = " + height);
        System.out.println("Area of Triangle = " + calculateArea());
    }
}

// Main Execution Class
public class Main {
    public static void main(String[] args) {
        System.out.println("----- Shape Area Calculator -----");

        Shape circle = new Circle(5.0);
        circle.displayDetails();
        System.out.println(); // Prints a clean blank line

        Shape rectangle = new Rectangle(4.0, 6.0);
        rectangle.displayDetails();
        System.out.println(); // Prints a clean blank line

        Shape triangle = new Triangle(3.0, 8.0);
        triangle.displayDetails();
    }
}
