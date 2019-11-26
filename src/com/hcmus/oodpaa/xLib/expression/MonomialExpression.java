package com.hcmus.oodpaa.xLib.expression;

public class MonomialExpression implements Expression {
    private double a, n;

    private MonomialExpression(double a, double n) {
        this.a = a;
        this.n = n;
    }

    public static Expression create(double a, double n) {
        // 0x^n = 0
        // ax^0 = a
        if (a == 0) {
            return new ConstExpression(0);
        } else if (n == 0)
            return new ConstExpression(a);
        return new MonomialExpression(a, n);
    }

    @Override
    public double evaluate(double x) {
        return a * Math.pow(x, n);
    }

    @Override
    public Expression derive() {
        // (ax^n)' = (a*n)x^(n-1)
        return MonomialExpression.create(a * n, n - 1);
    }

    @Override
    public String toString() {
        // ax^n
        if (n == 1)
            return String.format("%sx", Double.toString(a));
        return String.format("%sx^%s", Double.toString(a), Double.toString(n));
    }
}
