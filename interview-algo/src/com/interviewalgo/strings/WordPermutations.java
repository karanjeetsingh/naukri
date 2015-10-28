package com.interviewalgo.strings;

public class WordPermutations {
    public static void main(String[] args) {
        String s = "abc";
        permutations("", s);
    }

    private static void permutations(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
            }
        }
    }
}
