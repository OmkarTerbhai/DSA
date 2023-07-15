package com.recursion;

public class BasicRecursion {
    public static void main(String[] args) {
        System.out.println("------Normal Recursion-------");
        sayHello("Omkar", 5);

        System.out.println("-----Backtracking-------");
        sayHello2("Omkar", 5);
    }

    private static void sayHello(String name, int n) {
        if(n == 0) {
            return;
        }
        System.out.println("Hello: " + name + n);
        sayHello(name, n-1);
    }

    private static void sayHello2(String name, int n) {
        if(n == 0) {
            return;
        }
        sayHello2(name, n-1);
        System.out.println("Hello: " + name + n);
    }
}

