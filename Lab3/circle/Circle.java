package Lab3.circle;
import Lab3.circle.utils.Point;
class Circle {
    private double x = 0;
    private double y = 0;
    private double radius = 1;

    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; } //read

    public Circle(double x,double y,double radius) { //parameterized constructor
        this.x = x;
        this.y = y;
        if (radius <= 0) {
            throw new IllegalArgumentException("Invalid value for radius!");
        }
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI*radius*radius;
    }
    public Point getCenter(){
        Point p = new Point();
        p.setX(x);
        p.setY(y);
        return p;
    }

}

