package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

class TestDemoJUnitTest {

	private TestDemo testDemo;

    @BeforeEach
    public void setUp() {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
    public void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() ->
                testDemo.addPositive(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    public static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
        		Arguments.arguments(2, 4, 6, false), 
                Arguments.arguments(-3, 5, 0, false), 
                Arguments.arguments(0, 0, 0, false), 
                Arguments.arguments(2, -4, 0, true)	
        );
    }
    	@Test
        void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
            testDemo = new TestDemo();
            assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
            assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
    }
    	 @Test
    	    void testCalculateFactorial() {
    	        testDemo = new TestDemo();
    	        // Testing factorial of 5
    	        assertEquals(120, testDemo.calculateFactorial(5));
    	    }
    	 @Test
    	    void assertThatNumberSquaredIsCorrect() {
    	        TestDemo testDemo = Mockito.spy(new TestDemo());
    	        
    	        doReturn(5).when(testDemo).getRandomInt();
    	        
    	        int fiveSquared = testDemo.randomNumberSquared();
    	        
    	        assertThat(fiveSquared).isEqualTo(25);
    	    }
}

