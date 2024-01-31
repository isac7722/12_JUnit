package com.ohgiraffers.assertions.section01.jupiter;


import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class JupiterAssertionsTests {

    /*
     * junit jupiter 는 junit4로 부터 온 assertion 메소드와 새롭게 자바 8 람다 표현식으로 추가된 메소드를 제공한다
     * 모든 jupiter assertions의 메소드는 static 메소드 형태로 제공하고 있다
     *
     *
     * 테스트 코드의 기본 구조
     * given: 테스트 시 필요하 파라미터를 준비한다
     * when: 테스트를 할 메소드를 호출한다
     * then: 실행 결과를 검증
     * */

    @Test
    @DisplayName("더하기 기능 테스트")
    void testAssertEquals() {
        // given
        int firstNum = 10;
        int secondNum = 20;
        int expected = 39;

        // when
        Calculator calculator = new Calculator();
        int result = calculator.plusTwoNumbers(firstNum, secondNum);

        // then
        Assertions.assertEquals(expected, result);

        // 실패시 호출할 메세지
//        Assertions.assertEquals(expected, result, "실패하는 경우 이게 보임");

        // delta: 오차의 허용범위를 지정해줌
//        Assertions.assertEquals(expected,result, 10);

        // 람다표현식을 이용한 결과는 동일하지만 불필요한 경우 메세지를 만들지 않도록 지연 로딩을 이용한다
//        Assertions.assertEquals(expected, result, () -> "실패할 때 보여줄 메세지");
    }

    @Test
    @DisplayName("인스턴스 동일성 비교 테스트")
    void testAssertNotEqualsWithInstance() {

        // given & when
        Object obj1 = new Object();
        Object obj2 = new Object();

        // then
        Assertions.assertNotEquals(obj1, obj2);
    }

    // assertNull (actual) 메소드는 레퍼런스 변수가 null값을 가지는지를 판단한다.
    @Test
    @DisplayName("null 인지 테스트")
    void testAssertNull() {

        // given
        String str;

        // when
        str = null;

        // then
        Assertions.assertNull(str);
    }

    @Test
    @DisplayName("두 값이 같은지 확인")
    void testAssertTrue() {

        int num1 = 10;
        int num2 = 10;

        boolean result = num1 == num2;

        Assertions.assertTrue(result);
//        Assertions.assertEquals(result, num2 == num1);

//        Assertions.assertFalse(result);


    }

    @Test
    @DisplayName("동시에 여러 가지 값에 대한 검증을 수행하는 경우 테스트")
    void testAssertAll() {
        String firstName = "길동";
        String lastName = "홍";

        Person person = new Person(firstName, lastName);

        Assertions.assertAll(
                () -> Assertions.assertEquals(firstName, person.getFirstName(), "first name이 잘못됨"),
                () -> Assertions.assertEquals(lastName, person.getLastName(), "last Name 잘못됨")
        );
    }

    @Test
    @DisplayName("인스턴스의 타입에 대한 검증을 수행하는 경우")
    void testAssertType() {

        // given : 테스트시 필요한 파라미터를 준비한다
        String firstName = "길동";
        String lastName = "홍";

        // when : 테스트 대상을 준비해온다
        Person person = new Person(firstName, lastName);

        // then : 검증하는 로직
        Assertions.assertInstanceOf(Person.class, person);

        Assertions.assertAll(
                () -> Assertions.assertInstanceOf(Person.class, person),
                () -> Assertions.assertEquals(firstName, person.getFirstName()),
                () -> Assertions.assertEquals(lastName, person.getLastName())
        );
    }

    /*
     * assertDoesNotThrow(execution) 메소드 호출 시 아무런 예외가 발생하지 않는지 확인
     * */

    @Test
    @DisplayName("void 메소드의 경우 exception 발생이 없이 정상적으로 동작하는지 테스트")
    void testAsserDoesNotThrow() {

        // given
        int firstNum = 10;
        int secondNum = 10;

        // when & then
        PositiveNumberValidator validator = new PositiveNumberValidator();
        Assertions.assertDoesNotThrow(() -> validator.checkDividableNumbers(firstNum, secondNum));
    }

    @Test
    @DisplayName("void 메소드의 경우 exception 발생하는지 테스트")
    void testAssertThrows() {
        // given
        int firstNum = 10;
        int secondNum = 0;

        String exceptedErrorMessage = "0으로 나눌 수 없습니다";

        PositiveNumberValidator validator = new PositiveNumberValidator();

        Exception exception = Assertions.assertThrows(Exception.class,
                () -> validator.checkDividableNumbers(firstNum, secondNum)
        );

        Assertions.assertAll(
                ()-> Assertions.assertInstanceOf(PositiveNumberValidator.class, validator),
                ()-> Assertions.assertInstanceOf(IllegalAccessError.class, exception),
                ()-> Assertions.assertDoesNotThrow(()->validator.checkDividableNumbers(secondNum,firstNum))
        );
    }

    @Test
    @DisplayName("예상 목록이 실제 목록과 일치하지 않는지 확인")
    void testAssertLinesMatch(){

        // given
        List<String> expected = Arrays.asList("java", "database", "spring");

        // when
        List<String> actual = Arrays.asList("java", "database", "spring");

        // then
        Assertions.assertLinesMatch(expected, actual, ()-> "두 리스트의 값이 일치하지 않음");

    }
}





