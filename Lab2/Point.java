class Point {
    double x,y;

    void move(double dx,double dy) {
        x += dx;
        y += dy;
    }

    void mirror(double cx,double cy) {
        x = 2*cx - x;
        y = 2*cy - y;
    }

    void mirror(Point t) {
        x = 2*t.x - x;
        y = 2*t.y - y;
    }

    double distance(Point p) {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx*dx + dy*dy);

    }
}