package com.interviewalgo.strings;

public class PatterMatching {
    public static void main(String[] args) {
        String s1 = "abcdddddeffft";
        String rx = "a*d*t";

        System.out.println("s1 - " + s1);
        System.out.println("rx - " + rx);
        System.out.println("Is pattern matced? - " + isPatterMatch(s1, rx));
    }

    private static boolean isPatterMatch(String s1, String rx) {
        char[] s1Array = s1.toCharArray();
        char[] rxArray = rx.toCharArray();
        int index = 0;
        for (int i = 0; i < rx.length(); i++) {
            char s = s1Array[index];
            char r = rxArray[i];
            System.out.println("index - " + index + "\ts - " + s + "\ti - " + i + "\tr - " + r);
            if (r != '*' && r != '?') {
                if (s != r) {
                    return false;
                }
                index++;
                continue;
            }
            if (r == '?') {
                index++;
                continue;
            }
            if (i + 1 == rx.length()) {
                return true;
            }
            char next = rxArray[i + 1];
            while (s != next && index < (s1.length() - 1)) {
                s = s1Array[++index];
                System.out.println("index - " + index + "\ts - " + s + "\ti - " + i + "\tr - " + r + "\tnext - " + next);
            }
        }
        if(index != s1.length()){
            return false;
        }
        return true;
    }
}
