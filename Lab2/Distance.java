class Distance {
    public static void main(String[] args) {
        double distance = 0;
        for (int i = 0; i < args.length-2; i = i +2) {
            Point p1 = new Point();
            Point p2 = new Point();

            p1.x = Integer.parseInt(args[i]);
            p1.y = Integer.parseInt(args[i+1]);

            p2.x = Integer.parseInt(args[i+2]);
            p2.y = Integer.parseInt(args[i+3]);

            distance += p1.distance(p2);
        }

        System.out.println(distance);
    }
}