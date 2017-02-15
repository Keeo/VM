package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 15.2.2017.
 */
public class ComplexNumber {

    int real;
    int complex;

    ComplexNumber(int real, int complex) {
        this.real = real;
        this.complex = complex;
    }

    void add(ComplexNumber complexNumber) {
        this.real += complexNumber.real;
        this.complex += complexNumber.complex;
    }

    void printNumber() {
        print(real);
        print(complex);
    }

    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = new ComplexNumber(3, 4);
        a.add(b);
        a.printNumber();
    }

    public static native void print(int a);
}
