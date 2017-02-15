package cz.cvut.fit.run.sat;

/**
 * Created by Keo on 13.2.2017.
 */
public class Stack {
    ExpressionLink link;

    void push(Expression expression) {
        ExpressionLink expressionLink = new ExpressionLink(expression);
        if (link == null) {
            link = expressionLink;
        } else {
            expressionLink.prev = link;
            link = expressionLink;
        }
    }

    Expression pop() {
        Expression expression = link.expression;
        link = link.prev;
        return expression;
    }
}
