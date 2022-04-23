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
}

public class CircleMain {
    public static void main(String[] args) {
        //Circle c = new Circle();//parameterless constructor
        Circle c = new Circle(5,2,10);
        System.out.println("The arae of the circle is: "+c.getArea());
    }
}