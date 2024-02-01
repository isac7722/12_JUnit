package com.ohgiraffers.section03.additional;

import jdk.jfr.Percentage;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdditionalAnnotationTests {
    /*
    *  해당 테스트를 무시할 때 사용하는 어노테이션이다
    *
    * JUnit4에서 @Ignore와 동일한 기능을 제공한다
    * */

    @Disabled
    @Test
    public void testIgnore(){

    }

    /*
    * 주어진 시간ㅇ 안에 테스트가 끝나지 않으면
    * */

    @Test
    @Timeout(value=1000, unit = TimeUnit.MILLISECONDS)
    public void testTimeout() throws InterruptedException{
        Thread.sleep(900);
    }

//    @Tag를 사용하기 위한 규칙
    /*
    *   1. 태그는 공백이나 null이 있으면 안됨
    *   2. 다음 글자를 포함하면 안된다. : , () &
    * */
    @Test
    @Tag("development")
    public  void testTag1(){

    }

    @Test
    @Tag("production")
    public void testTag2(){

    }

    /*
    * 여러개 실행하는 경우 | 또는 &를 첨부한다
    *
    * */
    @Test
    @Tags(value = {@Tag("development"), @Tag("performance")})
    public void testTag3(){

    }

    /*
    * 테스트 메소드는 실행 순서가 보장되지 않지만 경우에 따라서는 (통합테스트 환경 등)
    * 테스트의 순서가 중요한 경우도 있다
    * 클래스 레벨에서 @TestMethodOrde(MethodOrderer.OrderAnnotation.class) 어노테이션을 추가하고
    * 각 테스트 메소드 @Order 어노테이션으로 순서를 지정하면 테스트 순서를 설정할 수 있다
    * 클래스에 작성한 테스트 메소드의 순서는 MethodOrderer에 DisplayName, MethodName, OrderAnnotation, RanDom 등이 있다
    * */

    @Test
    @Order(1)
    public void testFirst(){}

    @Test
    @Order(2)
    public void testSecond(){}

    @Test
    @Order(3)
    public void testThird(){}

    /*
    * RepeatTest는 명시된 숫자로 얼마나 테스트를 반복할 것인지를 지정해서 사용한다.
    * 반복된 테스트 메소드의 호출은 보통의 @Test 메소드들이랑 똑같이 동작한다.
    * */

    @RepeatedTest(10)
    public void testRepeat(){}
}
