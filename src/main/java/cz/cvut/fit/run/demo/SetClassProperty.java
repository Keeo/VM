package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 15.2.2017.
 */
public class SetClassProperty {
    int property = 3;

    public static void main(String[] args) {
        SetClassProperty setClassProperty = new SetClassProperty();
        setClassProperty.setProperty(6);
        setClassProperty.printProperty();
    }

    public void setProperty(int property) {
        this.property = property;
    }

    public void printProperty() {
        print(this.property);
    }

    public static native void print(int a);
}
