/*
* Java Lab Assignment - Lab 02 - Exercise 4
* Name Mortaza Ali Dar
* Neptun: YLEU5X
*/
class RectangleMain {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        Point top_left = new Point();
        Point bottom_left = new Point();
        Point top_right = new Point();
        //we will store the enclosing rectangle
        //in bottom and top
        Point bottom = new Point();
        Point top = new Point();
        if(args.length < 4 ){
            System.err.println("Please enter at least 4 arguments!");
            System.exit(0);
        }
        //we don't need an else statement because the
        //program will stop when it enters if
        for(int i = 0; i < args.length - 3 ;i += 4){
            r.x = Double.parseDouble(args[i]);
            r.y = Double.parseDouble(args[i+1]);
            r.width = Double.parseDouble(args[i+2]);
            r.height = Double.parseDouble(args[i+3]);
            r.calculateVertex();
            top_left = r.topLeft();
            top_right = r.topRight();
            bottom_left = r.bottomLeft();
            //using if else because we don't want to
            //compare if we only have one rectangle
            if(i!=0){
                top.x = Double.max(top.x, top_right.x);
                top.y = Double.max(top.y, top_right.y);
                bottom.x = Double.min(bottom.x, bottom_left.x);
                bottom.y = Double.min(bottom.y, bottom_left.y);
            }
            else{
                bottom = bottom_left;
                top = top_right;
            }
        }
        System.out.println("Bounding Rectangle: "+bottom.x+";"+bottom.y+" - "+ top.x+";"+top.y);
    }
}