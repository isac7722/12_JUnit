package com.ohgiraffers.section01.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TestAnnotationTests {
    /*
    *  junit platform
    *   - jvm에서 테스트 프레임위크를 실행하기 위한 테스트 엔진을 제공한다
    * 2. JUnit Jupiter
    *   - Junit5에서 테스트를 작성하고 실행하기 위한 엔진을 제공한다
    * 3. Junit Vintage
    *   - Junit3, 4를 기반으로 돌아가는 테스트 엔지을 제공한다
    * 
    * 
    * 테스트 클래스는 적어도 한 개 이상의 @Test 어노테이션이 달린 메소드를 가진 클래스이다
    * 테스트 클래스는 abstract이면 안되고, 한 개의 생성자를 가지고 있어야 한다
    * (두 개 이상 작성하면 런타임 시 PreconditionViolationException이 발생한다.
    * 아무런 생성자도 작성하지 않우면 생성자는 컴파일러가 자동으로 추가한다
    * */
    
    public TestAnnotationTests(){}
    
    /*
    * 
    * */
    @Test
    @DisplayName("테스트 메소드1")
    public void testMethod(){
        
    }
    
    @Test
    @DisplayName("displayName 우선순위 테스트")
    public void 테스트_메소드2(){
        /*
        *   클래스 레벨 @DisplayNameGenerator를 붙이게 되면 언더바를 공백으로 처리하여 테스트 이름을 부여해준다
        *   단, @DisplayName과 중복 작성시에넌 @DisplayName에 부여한 테스트 이름이 우선권을 가진다
        * */
    }
}
