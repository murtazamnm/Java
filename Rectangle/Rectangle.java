class Rectangle{
    double x, y, width, height;
    Point ver1 = new Point();
    Point ver2 = new Point();
    Point ver3 = new Point();

    Point topLeft(){
        Point tl = new Point();
        //we will only compare three vertices
        //because two vertices have the same value of x or y
        tl.x = (Double.min(Double.min(ver1.x,ver2.x), ver3.x));
        tl.y = (Double.max(Double.max(ver1.y, ver2.y), ver3.y));
        return tl;
    }
    Point topRight(){
        Point tr = new Point();
        tr.x = (Double.max(Double.max(ver1.x,ver2.x), ver3.x));
        tr.y = (Double.max(Double.max(ver1.y, ver2.y), ver3.y));
        return tr;
    }
    Point bottomLeft(){
        Point bl = new Point();
        bl.x = (Double.min(Double.min(ver1.x,ver2.x), ver3.x));
        bl.y = (Double.min(Double.min(ver1.y, ver2.y), ver3.y));
        return bl;
    }

    void calculateVertex(){
        
        ver1.x = x + width;
        ver1.y = y;
        ver2.x = x;
        ver2.y = y + height;
        ver3.x = ver1.x;
        ver3.y = y + height;

    }
}