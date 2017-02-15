package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 15.2.2017.
 */
public class ArrayClasses {
    int number;

    public ArrayClasses(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        ArrayClasses[] classes = getArray();
        sumAndPrint(classes);
    }

    public static void sumAndPrint(ArrayClasses[] arrayClasses) {
        int sum = 0;
        for(int i = 0; i < arrayClasses.length; ++i) {
            sum += arrayClasses[i].number;
        }
        print(sum);
    }

    public static native void print(int a);

    public static ArrayClasses[] getArray() {
        ArrayClasses[] classes = new ArrayClasses[3];
        classes[0] = new ArrayClasses(1);
        classes[1] = new ArrayClasses(3);
        classes[2] = new ArrayClasses(5);
        return classes;
    }
}
