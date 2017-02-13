package cz.cvut.fit.run.sat;

/**
 * Created by Keo on 13.2.2017.
 */
public class Stack {
    ExpressionLink link;

    void push(Expression expression) {
        if (link == null) {
            link = new ExpressionLink(expression, null);
        } else {
            link.next = new ExpressionLink(expression, link);
            link = link.next;
        }
    }

    Expression pop() {
        Expression expression = link.expression;
        link = link.prev;
        return expression;
    }
}
