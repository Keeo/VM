package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 15.2.2017.
 */
public class NullPointer {
    NullPointer nullPointer;

    public static void main(String[] args) {
        NullPointer a = new NullPointer();
        a.nullPointer = a;
        a.nullPointer = null;
        a = null;
        if (a != null) {
            printChar('0');
        } else {
            printChar('1');
        }
    }

    public static native void printChar(char a);
}
