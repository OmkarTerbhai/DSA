package com.basics;

public class FunctionsDemo {
    static String env = "Java";
    public static void main(String[] args) {
        System.out.println("Understanding functions in Java...");

        System.out.println(add(4, 5));
        demo("Here");

        System.out.println(sayHello("Omkar"));
        System.out.println(sayHello("Manas", 22));
    }

    private static int add(int no1, int no2) {
        return no1 + no2;
    }

    private static void demo(String s, int ...var) {
        System.out.println(s);
        System.out.println(var.length);
    }

    private static int add(float no1, float no2) {
        return (int) ((int)no1 + no2);
    }

    private static String sayHello(String name) {
        return "Hello " + name + " from " + env;
    }

    private static String sayHello(String name, int age) {
        String env = "Javascript";

        return "Hello " + name + " you are " + age + " years old " + " from " + env;

    }
}
