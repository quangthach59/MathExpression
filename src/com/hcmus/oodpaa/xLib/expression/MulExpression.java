package com.hcmus.oodpaa.xLib.expression;

public class MulExpression extends BinaryExpression {
    public MulExpression(Expression exp1, Expression exp2) {
        super(exp1, exp2);
        operator = "*";
    }

    @Override
    public Expression derive() {
        // (ab)' = a'b + ab'
        return new AddExpression(new MulExpression(this.exp1.derive(), this.exp2),
                new MulExpression(this.exp1, this.exp2.derive()));
    }

    @Override
    protected double doEvaluate(double val1, double val2) {
        return val1 * val2;
    }
}
