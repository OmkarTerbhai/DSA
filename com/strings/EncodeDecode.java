package com.strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String ele : strs) {
            sb.append(ele.length()).append("#").append(ele);
        }

        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> ansList = new ArrayList<>();

        int i = 0;
        while(i < str.length()) {
            int hashIdx = str.indexOf('#', i);
            if(hashIdx == -1) break;

            int len = Integer.parseInt(str.substring(i, hashIdx));

            int actualStrBegin = hashIdx+1;
            int actualStrEnd = hashIdx+len+1;

            ansList.add(str.substring(actualStrBegin, actualStrEnd));
            i = actualStrEnd;
        }

        return ansList;
    }

    public static void main(String[] args) {
        List<String> li = List.of("neet", "code");
        System.out.println(encode(li));
        String s1 = encode(li);
        System.out.println(decode(s1));
    }
}
