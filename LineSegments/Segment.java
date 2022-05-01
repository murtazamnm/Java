class Segment{
    double x1,x2,y1,y2;
    public Segment(double x1, double x2, double y1, double y2){
        this.x1= x1;
        this.x2= x2;
        this.y1= y1;
        this.y2= y2;
    }
    public Line line(){
        //                   a            b                 c
        //Using formulla (x2 - y2)x + (y1 - x1)y =  ( y1*x2 - x1*y2)
        double a = x2 - y2;
        double b = y1 - x1;
        double c = (y1*x2 - x1*y2);
        return new Line(a,b,c);
    }
    public Boolean contains(Point p){
        //using distance formulla
        double ap = Math.sqrt(Math.pow((x1 - p.x),2) + Math.pow((x2 - p.y),2));
        double pb = Math.sqrt(Math.pow((p.x - y1),2) + Math.pow((p.y - y2),2));
        double line_dist = Math.sqrt(Math.pow((x1 - y1),2) + Math.pow((x2 - y2),2));
        return (ap + pb == line_dist);
    }
    public double orientation(Point p){
        double or = (y2 - y1)*(p.x - x1) - (p.y - y2)*(x2-x1);
        if(or == 0){
            return 0;
        }
        else if(or > 0){
            return 1;
        }
        else { return -1;}
    }
    public Boolean intersects(Segment s){
        double o1 = orientation(new Point(s.x1,s.x2));
        double o2 = orientation(new Point(s.y1,s.y2));
        double o3 = s.orientation(new Point(x1,x2));
        double o4 = s.orientation(new Point(y1,y2));
        if(o1 != o2 && o3 != o4 ){ 
            return true;
        }
        //special cases
        Segment s1 = new Segment(x1,x2,s.x1,s.x2);
        if(o1 == 0 && s1.contains(new Point(y1,y2))){
            return true;
        }
        Segment s2 = new Segment(x1,x2,s.y1,s.y2);
        if(o2 == 0 && s2.contains(new Point(y1,y2))){
            return true;
        }
        Segment s3 = new Segment(s.x1,s.x2,x1,x2);
        if(o3 == 0 && s3.contains(new Point(s.y1,s.y2))){
            return true;
        }
        if(o4 == 0 && s3.contains(new Point(s.y1,s.y2))){
            return true;
        }
        return false;

    }
}
