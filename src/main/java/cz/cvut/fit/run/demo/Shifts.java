package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 15.2.2017.
 */
public class Shifts {
    public static void main(String[] args) {
        int a = 182;
        for (int i = 0; i < 10; ++i) {
            print(a << i);
            printChar('\n');
        }
    }

//    public static void print(int val) {
//        System.out.print(val);
//    }
//
//    public static void printChar(char val) {
//        System.out.print(val);
//    }

    public static native void print(int val);
    public static native void printChar(char val);
}
