class MainComplex {
    public static void main(String[] args) {
        Complex num1 = new Complex();
        num1.re = 3;
        num1.im = -1;

        Complex num2 = new Complex();
        num2.re = 3;
        num2.im = 1;

        System.out.println("abs(3-1i) =" + num1.abs());

    }
}