package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 14.2.2017.
 */
public class SimpleIO {
    public static void main(String[] args) {
        int a = read();
        int b = a + 1;
        print(b);
    }

    public static native int read();

    public static native void print(int a);
}
