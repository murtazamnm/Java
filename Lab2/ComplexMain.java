public class ComplexMain {
    public static void main(String[] args) {
        Complex c = new Complex();
        c.re = 3;
        c.im = 5;
        System.out.println("The conjugate of (3, 5i) = "+c.re+" "+c.im+"i");
    }
}
