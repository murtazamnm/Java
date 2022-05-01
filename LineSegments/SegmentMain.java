public class SegmentMain {
    public static void main(String[] args){
        Segment s1 = new Segment(2,4,7,4);
        Segment s2 = new Segment(2,2,6,7);
        System.out.println(s1.contains(new Point(5,4)));
        System.out.println(s1.orientation(new Point(5,3)));
        System.out.println(s1.intersects(s2));
        System.out.println(s1.contains(new Point(2,7)));
    }
}
