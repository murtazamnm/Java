package pointm;
import point2d.Point;

class MainPoint {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();

        p1.x = 3;
        p1.y = 3;
        System.out.println(p1.x +" "+ p1.y); //3 3
        p1.move(1,1);
        System.out.println(p1.x +" "+ p1.y); // 4 4

        p1.mirror(1,3);
        System.out.println(p1.x +" "+ p1.y);

        p1.mirror(0,0);
        System.out.println(p1.x +" "+ p1.y);

        p2.x = p2.y = 4;
        p1.mirror(p2); //
        System.out.println("This is the mirrored point: "+p1.x +" "+ p1.y);
        System.out.println("This is a reflection point: "+p2.x +" "+ p2.y);

        System.out.println("The distance between p1 and p2 is: "+p1.distance(p2));
       // System.out.println("How to return a Point: "+p1.returnPoint());
    }
}