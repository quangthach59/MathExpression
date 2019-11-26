package com.hcmus.oodpaa.xLib.expression;

import com.hcmus.oodpaa.xLib.notation.InfixNotation;
import com.hcmus.oodpaa.xLib.notation.Notation;

public abstract class BinaryExpression implements Expression {
    protected Expression exp1, exp2;
    protected String operator;
    static protected Notation notation;

    public BinaryExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        // Use infix notation by default
        if (notation == null)
            notation = new InfixNotation();
    }

    public void setNotation(Notation notation) {
        BinaryExpression.notation = notation;
    }

    @Override
    public double evaluate(double x) {
        double v1 = this.exp1.evaluate(x);
        double v2 = this.exp2.evaluate(x);
        return doEvaluate(v1, v2);
    }

    @Override
    public abstract Expression derive();

    protected abstract double doEvaluate(double val1, double val2);

    protected String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return notation.arrange(getOperator(), this.exp1.toString(), this.exp2.toString());
    }

}
