package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/*
    객체지향 프로그래밍
    실습
    요구사항
    간단한 사칙연산을 할 수 있다.
    양수로만 계산할 수 있다.
    나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
    MVC패턴(Model-View-Controller) 기반으로 구현한다.
 */
public class CalculatorTest {

    // 1(피연산자) +(연산자) 1(피연산자) ---> Calculator
    // 2 <--- Calculator
    @DisplayName("덧셈 연산을 정상적으로 수행한다.")
    @ParameterizedTest
    @MethodSource("fomulaAndResult")
    void calculateTest(int operand1 , String operator , int operand2 , int result) {
        int calculateResult = Calculator.calculate(operand1, operator,operand2);

        assertThat(result).isEqualTo(result);
    }
    private static Stream<Arguments> fomulaAndResult(){
        return Stream.of(
                arguments(1,"+",2,3),
                arguments(1,"-",2,-1),
                arguments(4,"*",2,8),
                arguments(4,"/",2,2)
        );
    }

    @DisplayName("나눗셈에서 0으로 나눌 경우 IllegalArgument 예외 발생")
    @Test
    void calculationExceptionTest() {
        assertThatCode(()->Calculator.calculate(10,"/",0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로는 나눌 수 없습니다.");
    }
}
