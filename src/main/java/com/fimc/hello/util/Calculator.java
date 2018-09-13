package com.fimc.hello.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

import com.fimc.hello.exception.DivisionOfZeroException;
import com.fimc.hello.exception.InvalidOperatorException;

public class Calculator {

    private static final String[] operators = new String[] { "+", "-", "*", "/" };

    public static BigDecimal calculate(String operator, BigDecimal number1, BigDecimal number2) {

        BigDecimal result = null;

        if (!checkOperatorIfValid(operator))
            throw new InvalidOperatorException("Invalid Operator.");
        if (operator.equals(operators[0])) {
            // do addition
            result = number1.add(number2);
        }
        if (operator.equals(operators[1])) {
            // do subtraction
            result = number1.subtract(number2);
        }
        if (operator.equals(operators[2])) {
            // do multiplication
            result = number1.multiply(number2);
        }
        if (operator.equals(operators[3])) {
            // do division
            if (number1.intValue() == 0)
                throw new DivisionOfZeroException("Divisor is zero.");
            DecimalFormat decimalFormat = new DecimalFormat(".#####");
            BigDecimal divisionResult = new BigDecimal(decimalFormat.format(number1.doubleValue() / number2.doubleValue()));
            result = divisionResult;
        }
        return result;
    }

    private static boolean checkOperatorIfValid(String operator) {
        boolean operatorIsValid = false;
        if (Arrays.asList(operators).contains(operator))
            operatorIsValid = true;
        return operatorIsValid;
    }

    public static String translateOperator(String operator) {
        String op = null;
        if (operator.equals(operators[0]))
            op = "addition";
        if (operator.equals(operators[1]))
            op = "subtraction";
        if (operator.equals(operators[2]))
            op = "multiplication";
        if (operator.equals(operators[3]))
            op = "division";
        return op;
    }
}
