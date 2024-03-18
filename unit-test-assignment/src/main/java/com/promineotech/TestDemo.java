package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	public int addPositive(int a, int b) {
        if (a > 0 && b > 0) {
            return a + b;
        } else {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
    }

    public static void main(String[] args) {
        TestDemo yourObject = new TestDemo();

        try {
            int result = yourObject.addPositive(2, 3);
            System.out.println("Sum of positive numbers: " + result);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
        public int calculateFactorial(int n) {
            if (n < 0)
                throw new IllegalArgumentException("Input must be a non-negative integer");
            
            int factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
    }
        int randomNumberSquared() {
            int randomNum = getRandomInt();
            return randomNum * randomNum;
        }

        int getRandomInt() {
            Random random = new Random();
            return random.nextInt(10) + 1;
        }
}
