/*
* Java Lab Assignment - Lab 05 - Exercise 2
* Name Mortaza Ali Dar
* Neptun: YLEU5X
*/
import basics.Matrix;
public class MainMatrix {
    public static void main(String[] args) {
        double[] arr = {5,6,9,3,0,4};
        double[] brr = {3,4,8,3,7,2};
        Matrix a = new Matrix(2,3,arr);
        
        System.out.println(a);

        Matrix b = new Matrix(2,3,brr);

        a.identityMatrix(3);

        System.out.println(a.transpose());

        //System.out.println(a.addMatrix(b));
       
        //System.out.println(a.diffMatrix(b));

    }
}
