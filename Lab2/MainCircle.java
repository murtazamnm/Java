class MainCircle {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.radius = 3;
        System.out.println("The circle area before enlarging is =" + c.getArea());

        c.enlarge(4);
        System.out.println("The circle area after enlarging is =" + c.getArea());

        c.enlarge(0.2);
        System.out.println("The circle area after shrinking is =" + c.getArea());

    }
}