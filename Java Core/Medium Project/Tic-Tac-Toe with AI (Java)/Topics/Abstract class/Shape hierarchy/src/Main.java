abstract class Shape {

   static double getPerimeter();

    abstract double getArea();
}
class Triangle extends Shape {
    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    double getArea() {
        double s = (a + b + c)/ 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    @Override
    double getPerimeter() {
        return a + b + c;
    }
}
class Rectangle extends Shape {
    double ra;
    double rb;

    public Rectangle(double ra, double rb){
        this.ra = ra;
        this.rb = rb;
    }

    @Override
    double getArea() {
        return ra * rb;
    }

    @Override
    double getPerimeter() {
        return (ra * 2) + (rb * 2);
    }
}
class Circle extends Shape {
double r;

public Circle(double r){
    this.r = r;
}
    @Override
    double getArea() {
        return Math.PI * Math.pow(r,2);
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * r;
    }
}