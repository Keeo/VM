package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 15.2.2017.
 */
public class Conditions {
    public static void main(String[] args) {
        int a = 0;
        a += 1;

        if (a < 0) {
            printChar('A');
        } else {
            printChar('B');
        }

        if (a <= 0) {
            printChar('A');
        } else {
            printChar('B');
        }

        if (a == 0) {
            printChar('A');
        } else {
            printChar('B');
        }

        if (a >= 0) {
            printChar('A');
        } else {
            printChar('B');
        }

        if (a > 0) {
            printChar('A');
        } else {
            printChar('B');
        }
    }

    public static native void printChar(char letter);
}
