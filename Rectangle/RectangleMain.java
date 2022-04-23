/*
Create a Rectangle class to represent a rectangle (it sides are parallel to the coordinate axis). 
Store one of the vertex's x and y coordinate, the rectangle weight and height (double).
Weight and height can be negative too. For example, let r instance data members x=1, y=5, width=6, height=-2, 
in this case r's lower left vertex coordinates are 1 and 3.
Define topLeft(), topRight(), and bottomLeft() methods returning the corresponding vertex of the rectangle as Point.
Write the main program, which interprets its command line arguments as a sequence of rectangles, and calculate the 
enclosing rectangle of the rectangles. The command line arguments shall be numbers (at least 4). Process these arguments 
and write to the console the enclosing rectangle other vertexes.
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
