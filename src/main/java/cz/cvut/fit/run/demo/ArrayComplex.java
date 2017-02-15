package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 15.2.2017.
 */
public class ArrayComplex {

    public static void main(String[] args) {
        int[] ints = new int[99];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }

        int sum = 0;
        for (int i = ints.length - 1; i >= 0; i--) {
            sum += ints[i];
        }
        print(sum);
    }

    public static native void print(int a);
}
