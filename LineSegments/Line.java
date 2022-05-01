class Line {
    double a, b, c;
    public Line(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Boolean contains(Point p){
        if(a*p.x + b*p.y == c){ return true;}
        return false;
    }
    public Boolean isParalleWith(Line l){
        // using slope formulla
        // two lines are parallel if their slopes -(A/B) are equal.
        if((-(a/b)) == (-(l.a/l.b))){ return true;}
        return false;
    }
    public Boolean isOrthogonalTo(Line l){
        // using formulla -(A/B) * -(A/B) = -1
        // two lines are perpendicular if the
        //product of their slopes is -1
        if((-(a/b))*(-(l.a/l.b)) == -1){ return true;} 
        return false;
    }
}
