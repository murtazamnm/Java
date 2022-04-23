class Circle {
    double radius;
    double x,y;

    double getArea() {
        return Math.PI*radius*radius;
    }

    void enlarge(double f) { //2
        radius *= f;
    }
}