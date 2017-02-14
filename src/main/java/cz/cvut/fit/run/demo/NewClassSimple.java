package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 14.2.2017.
 */
public class NewClassSimple {
    public static void main(String[] args) {
        NewClassSimple newClassSimple = new NewClassSimple();
        newClassSimple.callPrint();
    }

    void callPrint() {
        print(5);
    }

    public static native void print(int a);
}
