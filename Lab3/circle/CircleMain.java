package Lab3.circle;
import Lab3.circle.utils.Point;
public class CircleMain {
    public static void main(String[] args) {
        Circle cc = new Circle(0, 0, 10);
        Point p = new Point();
        p = cc.getCenter();
    }
}
