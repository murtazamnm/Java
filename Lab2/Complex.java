class Complex {  // 4 + 6 i
    double re,im;

    //abs,add,sub,mul

    double abs() {
        return Math.sqrt(re*re + im*im);
    }

    void add(Complex c) {
        re += c.re;
        im += c.im;
    }

    void sub(Complex c) {
        re -= c.re;
        im -= c.im;
    }

    void mul(Complex c) {
        double new_re = re*c.re - im*c.im;
        double new_im = re*c.im + im*c.re;

        re = new_re;
        im = new_im;
    }
    void conjugate(Complex c){
        re = c.re;
        im = c.im * -1;
    }
    void reciprocate(Complex c){
        
    }
    
}