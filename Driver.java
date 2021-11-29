import java.util.Scanner;

abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /** Construct a default geometric object */
    protected GeometricObject() {
    }

    /** Construct a geometric object with color and filled value */
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /** Return color */
    public String getColor() {
        return color;
    }

    /** Set a new color */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled. Since filled is boolean,
     * the get method is named isFilled
     */
    public boolean isFilled() {
        return filled;
    }

    /** Set a new filled */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /** Get dateCreated */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }
}

class Triangle extends GeometricObject {
    double side1;
    double side2;
    double side3;

    Triangle() {
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    Triangle(double a, double b, double c) {
        this.side1 = a;
        this.side2 = b;
        this.side3 = c;
    }

    public void setSide1(double a) {
        this.side1 = a;
    }

    public void setSide2(double a) {
        this.side2 = a;
    }

    public void setSide3(double a) {
        this.side3 = a;
    }

    public double getArea() {
        double p = (this.side1 + this.side2 + this.side3) / 2;
        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public String toString() {
        return "Triangle: side1 = " + this.side1 + " side2 = " + this.side2 + " side3 = " + this.side3;
    }

}

public class Driver {
    public static void main(String[] args) {
        Triangle x = new Triangle();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side 1 of triangle:");
        x.setSide1(sc.nextInt());
        System.out.print("Enter side 2 of triangle:");
        x.setSide2(sc.nextInt());
        System.out.print("Enter side 3 of triangle:");
        x.setSide3(sc.nextInt());
        System.out.print("Enter color of triangle:");
        x.setColor(sc.next());
        System.out.print("Enter whether triangle is filled (yes/no):");
        String ans = sc.next();
        if (ans.equals("yes")) {
            x.setFilled(true);
        } else if (ans.equals("no")) {
            x.setFilled(false);
        }

        System.out.println("Area: " + x.getArea());
        System.out.println("Perimeter: " + x.getPerimeter());
        System.out.println("Color: " + x.getColor());
        System.out.println("Filled?: " + x.isFilled());

    }
}
