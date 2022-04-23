/*
* Java Lab Assignment - Lab 02 - Exercise 4
* Name Mortaza Ali Dar
*/
class RectangleMain {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        Point top_left, top_right, bottom_left;
        Point top = new Point(); //will store the enclosing rectangle
        Point bottom = new Point();
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
            top_left = r.topLeft();
            bottom_left = r.bottomLeft();
            //we can't calculate a diagonal vertices
            //without passing an adjacent vertices
            top_right = r.topRight(top_left);
            //using if else here because we don't
            //want to compare with top.x, top.y...bottom.y which are zero at first
            if(i != 0 ){
                top.x = Double.max(Double.max(Double.max( r.x, top_left.x), Double.max(bottom_left.x, top_right.x)), top.x);
                top.y = Double.max(Double.max(Double.max( r.y, top_left.y), Double.max(bottom_left.y, top_right.x)), top.y);
                bottom.x = Double.min(Double.min(Double.min( r.x, top_left.x), Double.min(bottom_left.x, top_right.x)), bottom.x);
                bottom.y = Double.min(Double.min(Double.min( r.y, top_left.y), Double.min(bottom_left.y, top_right.y)), bottom.y);
            }
            else{
                top.x = Double.max(Double.max( r.x, top_left.x), Double.max(bottom_left.x, top_right.x));
                top.y = Double.max(Double.max( r.y, top_left.y), Double.max(bottom_left.y, top_right.x));
                bottom.x = Double.min(Double.min( r.x, top_left.x), Double.min(bottom_left.x, top_right.x));
                bottom.y = Double.min(Double.min( r.y, top_left.y), Double.min(bottom_left.y, top_right.y));
            }
        }
        System.out.println("Bounding Rectangle: "+bottom.x+";"+bottom.y+" - "+ top.x+";"+top.y);
    }
}