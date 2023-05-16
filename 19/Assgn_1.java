//Print the sum,difference and product of two complex numbers by creating a class named 'Complex' with separate methods for each operation whose real and imaginary parts are entered by the user.
public class Assgn_1 {
    public static void main(String args[]) {
        Complex c1 = new Complex(3,6);
        Complex c2 = new Complex(7,4);
        Complex c3 = Complex.sum(c1, c2);
        Complex c4 = Complex.diff(c2, c1);
        Complex c5 = Complex.prod(c1, c2);
        c3.printComplex();
        c4.printComplex();
        c5.printComplex();
    }
}

class Complex {
    int real;
    int imag;

    Complex() {
        real = 0;
        imag = 0;
    }
    Complex(int r, int i) {
        real = r;
        imag = i;
    }
    public static Complex sum(Complex obj1, Complex obj2) {
        int r = obj1.real + obj2.real;
        int i = obj1.imag + obj2.imag;
        return new Complex(r, i);
    }

    public static Complex diff(Complex obj1, Complex obj2) {
        int r = obj1.real - obj2.real;
        int i = obj1.imag - obj2.imag;
        return new Complex(r, i);
    }

    public static Complex prod(Complex o1, Complex o2) {
        int r = o1.real * o2.real + o1.imag * o2.imag*(-1);
        int i = o1.real * o2.imag + o1.imag * o2.real;
        return new Complex(r, i);
    }

    public void printComplex() {
        if(real == 0 && imag != 0) {
            System.out.println(imag + "i");
        }
        else if(real != 0 && imag ==0) {
            System.out.println(real);
        }
        else if(imag < 0) {
            System.out.println(real + " " + imag + "i");
        }
        else {
            System.out.println(real + " + " + imag + "i");
        }
    }
}