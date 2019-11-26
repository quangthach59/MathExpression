package com.hcmus.oodpaa.xLib.expression;

public interface Expression {
    double evaluate(double x);
    Expression derive();
    String toString();
}
