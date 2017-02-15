package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 15.2.2017.
 */
public class Chars {
    public static void main(String[] args) {
        char a = 'a';
        printChar(a);

        char[] chars = new char[]{'a', 'b', 'c'};
        for (int i = 0; i < chars.length; ++i) {
            printChar(chars[i]);
        }
    }

    public static native void printChar(char a);
}
