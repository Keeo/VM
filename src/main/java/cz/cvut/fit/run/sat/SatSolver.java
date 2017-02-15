package cz.cvut.fit.run.sat;

public class SatSolver {
    static final int AND = 1;
    static final int OR = 2;
    static final int NOT = 3;

    /**
     * Input is in postfix notation with a-z variables without gaps.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
        char[] sat = {'a', 'b', 'c', '!', 'd', '&', '|', '&'};
        Expression expression = buildTree(sat);
        expression.print();
        printChar('\n');

        boolean[] solution = solve(expression, variableCount(sat));
        if (solution != null) {
            for (int i = 0; i < solution.length; i++) {
                printChar((char) (97 + i));
            }
            printChar('\n');
            for (int i = 0; i < solution.length; i++) {
                printChar(solution[i] ? '1' : '0');
            }
        }
    }

    public static native void printChar(char string);
    //public static void printChar(char val) {
    //    System.out.print(val);
    //}

    public static boolean[] solve(Expression expression, int variableCount) {
        for (int instance = 0; instance < variableCount * variableCount; instance++) {
            boolean[] bits = new boolean[variableCount];
            for (int j = variableCount - 1; j >= 0; j--) {
                bits[j] = (instance & (1 << j)) != 0;
            }
            if (expression.evaluate(bits)) {
                return bits;
            }
        }
        return null;
    }

    public static boolean isLetter(char letter) {
        return letter >= 'a' && letter <= 'z' || letter >= 'A' && letter <= 'Z';
    }

    public static int variableCount(char[] sat) {
        boolean[] shelf = new boolean[25];
        for (int i = 0; i < sat.length; i++) {
            char letter = sat[i];
            if (isLetter(letter)) {
                shelf[letter - 97] = true;
            }
        }
        int variableCount = 0;
        for (int i = 0; i < shelf.length; i++) {
            if (shelf[i]) {
                variableCount++;
            }
        }
        return variableCount;
    }

    public static Expression buildTree(char[] sat) {
        Stack stack = new Stack();

        for (int i = 0; i < sat.length; i++) {
            char character = sat[i];
            Expression expression = new Expression();
            switch (character) {
                case '&': // 38
                case '|': // 124
                    expression.operator = character == '&' ? AND : OR;
                    expression.right = stack.pop();
                    expression.left = stack.pop();
                    break;

                case '!': // 33
                    expression.operator = NOT;
                    expression.left = stack.pop();
                    break;

                default:
                    expression.name = character;
                    break;
            }
            stack.push(expression);
        }
        return stack.pop();
    }
}
