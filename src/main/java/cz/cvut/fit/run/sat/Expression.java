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
