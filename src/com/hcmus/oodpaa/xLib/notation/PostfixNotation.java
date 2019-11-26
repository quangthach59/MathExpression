package com.hcmus.oodpaa.xLib.notation;

public class PostfixNotation implements Notation{
    @Override
    public String arrange(String operator, String operand1, String operand2) {
        return String.format("%s %s %s", operand1, operand2, operator);
    }
}
