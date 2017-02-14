package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 14.2.2017.
 */
public class Function {
    public static void main(String[] args) {
        int a = 9;
        int b = 4;
        preprint();
        printNumber(a);
        int c = returnNumber();
        int d = combineNumber(a, b);
        print(c + d);
    }

    public static void preprint() {
        print(0);
    }

    public static void printNumber(int a) {
        print(a);
    }

    public static int returnNumber() {
        return 6;
    }

    public static int combineNumber(int a, int b) {
        return a + b;
    }

    public static native void print(int a);
}
