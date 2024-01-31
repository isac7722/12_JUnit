package com.ohgiraffers.assertions.section01.jupiter;

public class PositiveNumberValidator {

    public void checkDividableNumbers(int firstNUm, int secondNum) throws IllegalAccessException {
        if(secondNum == 0){
            throw new IllegalAccessException("0으로 나눌 수 없습니다.");


        }
    }
}
