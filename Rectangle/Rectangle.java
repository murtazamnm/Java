class Rectangle{
    double x, y, width, height;
    Point topLeft(){
        Point p = new Point();
        p.x = x;
        p.y = y + height;
        return p;
    }
    Point topRight(Point tl){
        Point p1 = new Point();
        p1.y = tl.y;
        p1.x = tl.x + width;
        return p1;
    }
    Point bottomLeft(){
        Point p2 = new Point();
        p2.y = y;
        p2.x = x + width;
        return p2;
    }
}