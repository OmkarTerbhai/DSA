package com.basics;

public class DataTypes {
    public static void main(String[] args) {

        /*
         * Boolean datatype:
         * Can store only one of two values 'true' or 'false'
         * Size 1 bit
         */
        boolean res = false;
        System.out.println("Boolean: " + res);

        /*
         * Byte datatype:
         * Can store integer values
         * Range:- -128 to 127
         * Size:- 1 byte
         */
        byte b = 120;
        System.out.println("Byte: " + b);

        /*
         * Short datatype:
         * Can store more integer values
         * Range:- -32768 to 32767
         * Size:- 2 bytes
         */
        short s = 1240;
        System.out.println("Short: " + s);

        /*
         * Int datatype:
         * Can store all integer values
         * Range:- -2^31 to 2^31 - 1
         * Size:- 4 bytes
         */
        int val = 234;
        System.out.println("Int: " + val);

        /*
         * Char datatype:
         * Can store single characters
         * Range:- 0 to '\uffff'
         * Size:- 2 bytes
         */
        char ch = 'A';
        System.out.println("Char: " + ch);

        /*
         * Float datatype:
         * Can store floating point(decimal numbers)
         * Size: 4 bytes
         */
        float f = 32.89F;
        System.out.println("Float: " + f);

        /*
         * Long datatype:
         * Can store large integer values
         * Range:- -2^63 to 2^63 - 1
         * Size:- 8 bytes
         */
        long l = 21245678L;
        System.out.println("Long: " + l);

        /*
         * Double datatype:
         * Can store floating point values with more precision values
         * Size:- 8 bytes
         */
        double d = 3267.89234D;
        System.out.println("Double: " + d);

        /*
         * String datatype:
         * Can store sequence of characters
         * Non - Primitive
         * Size:- Depends on value
         */
        String s1 = "Omkar";
        System.out.println("String: " + s1);
    }
}
