package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 15.2.2017.
 */
public class Array {
    public static void main(String[] args) {
        int[] integers = new int[3];
        integers[0] = 0;
        integers[1] = 1;
        integers[2] = 2;
        print(integers[0]);
        print(integers[1]);
        print(integers[2]);
    }

    public static native void print(int a);
}
