package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 14.2.2017.
 */
public class NewClass {

    int number;

    NewClass() {
        this.number = 77;
        this.printHello();
    }

    public static void main(String[] args) {
        NewClass newClass = new NewClass();
        newClass.printHello();
    }

    void printHello() {
        print(this.number);
    }

    public static  native void print(int n);
}
