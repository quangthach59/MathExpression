package com.hcmus.oodpaa.xLib.expression;

public class DivExpression extends BinaryExpression {
    public DivExpression(Expression exp1, Expression exp2) {
        super(exp1, exp2);
        operator = "/";
    }

    @Override
    public Expression derive() {
        // (a/b)' = (a'b - ab')/b^2
        Expression a = this.exp1;
        Expression b = this.exp2;
        return new DivExpression(new AddExpression(new MulExpression(a.derive(), b),
                new MulExpression(new ConstExpression(-1), new MulExpression(a, b.derive()))),
                new MulExpression(b, b));
    }

    @Override
    protected double doEvaluate(double val1, double val2) {
        return val1 / val2;
    }

}
