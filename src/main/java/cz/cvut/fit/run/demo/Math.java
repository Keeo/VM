package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 14.2.2017.
 */
public class Math {
    public static void main(String[] args) {
        int a = 6;
        int b = 7;
        int c = a + b;
        a = c - a;
        c = a * b;
        print(c);
    }

    public static native void print(int a);
}
