package com.hcmus.oodpaa.xLib.notation;

public class PrefixNotation implements Notation{
    @Override
    public String arrange(String operator, String operand1, String operand2) {
        return String.format("%s %s %s", operator, operand1, operand2);
    }
}
