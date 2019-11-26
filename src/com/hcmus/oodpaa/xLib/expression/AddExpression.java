package com.hcmus.oodpaa.xLib.expression;

public class AddExpression extends BinaryExpression {
    public AddExpression(Expression exp1, Expression exp2) {
        super(exp1, exp2);
        operator = "+";
    }

    @Override
    public Expression derive() {
        // (a + b)' = a' + b'
        return new AddExpression(this.exp1.derive(), this.exp2.derive());
    }

    @Override
    protected double doEvaluate(double val1, double val2) {
        return val1 + val2;
    }
}
