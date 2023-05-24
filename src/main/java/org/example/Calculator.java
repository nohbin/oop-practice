package org.example;

import org.example.calculate.*;

import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(),new SubtractionOperator(), new MulticationOperator(), new DivisionOperator());
    public static int calculate(int operand1, String operator, int operand2) {
       return arithmeticOperators.stream()
               .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
               .map(arithmeticOperators -> arithmeticOperators.calculate(operand1,operand2))
               .findFirst()
               .orElseThrow(()-> new IllegalArgumentException("올바른 사친역산이 아닙니다."));
    }
}
