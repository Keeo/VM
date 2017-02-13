package cz.cvut.fit.run.sat;

/**
 * Created by Keo on 13.2.2017.
 */
public class ExpressionLink {
    public ExpressionLink prev;
    public ExpressionLink next;
    public Expression expression;

    public ExpressionLink(Expression expression, ExpressionLink prev) {
        this.expression = expression;
        this.prev = prev;
    }
}
