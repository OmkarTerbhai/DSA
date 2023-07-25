package com.recursion;

public class PhoneSequence {
    static String[] keys = {"","","abc","def","ghi","jkl","mno","pqr"};
    public static void main(String[] args) {
        phoneSequence("23", 0, "");
    }

    static void phoneSequence(String keypress, int idx, String output) {
        if(idx >= keypress.length()) {
            System.out.println(output);
            return;
        }

        int digitPressed = Integer.parseInt(keypress.charAt(idx) + "");

        //Loop over alphabets of current digit
        for(int i = 0; i < 3; i++) {
            phoneSequence(keypress, idx+1, output + keys[digitPressed].charAt(i));
        }

    }
}
