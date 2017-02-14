package cz.cvut.fit.run.demo;

public class Demo {
    public static void main(String[] args) {
        int a = 6;
        print(a);
    }

    public static native void print(int a);
}
