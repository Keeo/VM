package cz.cvut.fit.run.sat;

public class Expression {
    char name;
    Expression left;
    Expression right;
    int operator;

    public boolean evaluate(boolean[] instance) {
        if (name > 0) {
            return instance[name - 97];
        }
        if (operator == SatSolver.NOT) {
            return !left.evaluate(instance);
        }
        if (operator == SatSolver.AND) {
            return left.evaluate(instance) && right.evaluate(instance);
        }
        if (operator == SatSolver.OR) {
            return left.evaluate(instance) || right.evaluate(instance);
        }
        return false;
    }

    public void print() {
        if (name > 0) {
            SatSolver.printChar(name);
            return;
        }
        if (operator == SatSolver.NOT) {
            SatSolver.printChar('!');
            left.print();
            return;
        }

        SatSolver.printChar('(');
        left.print();
        SatSolver.printChar(' ');
        SatSolver.printChar(operator == SatSolver.AND ? '&' : '|');
        SatSolver.printChar(' ');
        right.print();
        SatSolver.printChar(')');
    }

    @Override
    public String toString() {
        if (name > 0) {
            return Character.toString(name);
        }
        if (operator == SatSolver.NOT) {
            return "!" + left.toString();
        }
        return "(" + left.toString() + (operator == SatSolver.AND ? " & " : " | ") + right.toString() + ")";
    }
}
