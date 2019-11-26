package com.hcmus.oodpaa.xLib.expression;

public class ConstExpression implements Expression {
    private double value;

    public ConstExpression(double value){
        this.value = value;
    }

    @Override
    public double evaluate(double x) {
        return value;
    }

    @Override
    public Expression derive() {
        return new ConstExpression(0);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
