package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 15.2.2017.
 */
public class Loops {
    public static void main(String[] args) {
        forCycle();
        whileCycle();
    }

    static void whileCycle() {
        int i = 0;
        int j = 10;
        while(i < j) {
            i += i + 1;
        }
        print(i);
    }

    static void forCycle() {
        int a = 0;
        for(int i = 0; i < 10; i++) {
            a += i;
        }
        print(a);
    }

    public static native void print(int a);
}
