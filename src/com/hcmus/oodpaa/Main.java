package com.hcmus.oodpaa;

import com.hcmus.oodpaa.xLib.expression.*;
import com.hcmus.oodpaa.xLib.notation.InfixNotation;
import com.hcmus.oodpaa.xLib.notation.PostfixNotation;
import com.hcmus.oodpaa.xLib.notation.PrefixNotation;

public class Main {
    public static void main(String[] args) {
        // 2 * ( ( 3 + 4 ) / 5 )
//        ConstExpression three = new ConstExpression(3);     // 3
//        ConstExpression four = new ConstExpression(4);      // 4
//        AddExpression add = new AddExpression(three, four);     // 3 + 4
//        ConstExpression five = new ConstExpression(5);      // 5
//        DivExpression div = new DivExpression(add, five);       // (3 + 4) / 5
//        ConstExpression two = new ConstExpression(2);       // 2
//        MulExpression mul = new MulExpression(two, div);            // 2 * ((3 + 4) / 5)
//        mul.setNotation(new PostfixNotation());
//        System.out.println("Postfix: " + mul.toString());
//        mul.setNotation(new InfixNotation());
//        System.out.println("Infix: " + mul.toString());
//        mul.setNotation(new PrefixNotation());
//        System.out.println("Prefix: " + mul.toString());

        // 5
        Expression constExp = new ConstExpression(5);
        printResult(constExp);
        // 2x^4
        Expression monomialExp = MonomialExpression.create(2, 4);
        printResult(monomialExp);
        // 5 + 2x^4
        Expression addExp = new AddExpression(constExp, monomialExp);
        printResult(addExp);
        // Evaluate 5 + 2x^4 for x = 5
        System.out.println(String.format("Evaluation of %s for x = %f is %f", addExp.toString(), 5.0, addExp.evaluate(5)));
        // 10
        Expression constExp2 = new ConstExpression(10);
        // (5 + 2x^4) * 10
        MulExpression mulExp = new MulExpression(addExp, constExp2);
        printResult(mulExp);
        // ((5 + 2x^4) * 10) / 5
        DivExpression divExp = new DivExpression(mulExp, constExp);
        printResult(divExp);
        // Postfix traversal
        mulExp.setNotation(new PostfixNotation());
        System.out.println("Postfix: " + mulExp.toString());
        // Infix traversal (by default)
        mulExp.setNotation(new InfixNotation());
        System.out.println("Infix: " + mulExp.toString());
        // Prefix traversal
        mulExp.setNotation(new PrefixNotation());
        System.out.println("Prefix: " + mulExp.toString());
    }

    private static void printResult(Expression exp) {
        System.out.println(String.format("Expression: %s", exp.toString()));
        System.out.println(String.format("\tDerivation: %s", exp.derive().toString()));
    }
}
