package com.strings;

public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels(".,"));
    }
    public static String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] str = s.toCharArray();
        while(i < j) {

            if(isVowel(str[i]) && isVowel(str[j])) {
                char ch = str[i];
                str[i] = str[j];
                str[j] = ch;
                i++;j--;
            }
            while(i < j && !isVowel(str[i])) {
                i++;
            }
            while(i < j && !isVowel(str[j])) {
                j--;
            }
        }

        return new String(str);
    }

    private static boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'
                || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O'
                || ch == 'U') {
            return true;
        }
        return false;
    }
}
