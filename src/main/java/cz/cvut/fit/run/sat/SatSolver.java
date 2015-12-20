package cz.cvut.fit.run.sat;

import java.util.Stack;

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
    public static void main(String[] args) throws Exception {
        String sat = "abc!d&|&";
        Expression expression = buildTree(sat);
        System.out.println(expression);
        boolean[] solution = solve(expression, variableCount(sat));
        if (solution != null) {
            for (int i = 0; i < solution.length; i++) {
                System.out.print((char) (97 + i));
            }
            System.out.println();
            for (int i = 0; i < solution.length; i++) {
                System.out.print(solution[i] ? '1' : '0');
            }
        }
    }

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

    public static int variableCount(String sat) {
        boolean[] shelf = new boolean[25];
        for (int i = 0; i < sat.length(); i++) {
            char letter = sat.charAt(i);
            if (Character.isLetter(letter)) {
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

    public static Expression buildTree(String sat) {
        Stack<Expression> stack = new Stack<>();

        for (int i = 0; i < sat.length(); i++) {
            char character = sat.charAt(i);
            if (character == ' ') {
                continue;
            }

            Expression expression = new Expression();
            switch (character) {
                case '&':
                case '|':
                    expression.operator = character == '&' ? AND : OR;
                    expression.right = stack.pop();
                    expression.left = stack.pop();
                    break;

                case '!':
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
