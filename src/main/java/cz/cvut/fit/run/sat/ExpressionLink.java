package cz.cvut.fit.run.sat;

/**
 * Created by Keo on 13.2.2017.
 */
public class ExpressionLink {
    public ExpressionLink prev;
    public Expression expression;

    public ExpressionLink(Expression expression) {
        this.expression = expression;
    }
}
