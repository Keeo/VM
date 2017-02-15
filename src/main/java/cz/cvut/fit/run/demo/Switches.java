package cz.cvut.fit.run.demo;

/**
 * Created by Keo on 15.2.2017.
 */
public class Switches {
    public static void main(String[] args) {
        int a = 2;
        runSwitch(a);
        runSwitch(27);
    }

    public static void runSwitch(int a) {
        switch (a + 5) {
            case 4:
                printChar('N');
                break;
            case 11:
                printChar('O');
                break;
            case 899:
                printChar('P');
                break;
            case 32:
                printChar('Q');
                break;
            case 7:
                printChar('K');
                break;
            default:
                printChar('E');
                break;
        }
        printChar('D');
    }

    public static native void printChar(char a);
}
