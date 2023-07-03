package com.basics;

public class Operators {
    public static void main(String[] args) {
        int a = 10, b = 10;
        /*
         * Arithmetic Operations
         * Used for basic mathematical operations
         */
        int sum = a + b;
        int difference = a- b;
        int product = a * b;
        int quotient = a / b;
        int remainder = a % b;

        System.out.println("Sum: + : " + sum);
        System.out.println("Difference: - : " + difference);
        System.out.println("Product: * : " + product);
        System.out.println("Quotient: / : " + quotient);
        System.out.println("Remainder: % : " + remainder);

        /*
         * Relational Operators(Binary operators)
         * Provide boolean result based on a condition
         */
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a == b);
        System.out.println(a >= b);
        System.out.println(a <= b);

        /*
         * Unary Operators
         * Perform operations on a single operand
         */
        int c = a++;
        int d = b++;
        System.out.println("a++ : " + c);
        System.out.println("b++ : " + d);
        System.out.println(a);
        System.out.println(b);
        System.out.println(++a);
        System.out.println(++b);

        /*
         * If -else
         * Conditional statements used to evaluate statements conditionally.
         */
        if(a > b) {
            System.out.println("a is greater than b");
        }
        else if(a < b) {
            System.out.println("a is lesser than b");
        }
        else if(a == b) {
            System.out.println("a is equal to b");
        }
    }
}
