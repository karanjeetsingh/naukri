package com.interviewalgo.strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args){
        String s1 = "karan";
        String s2 = "kawal";
        
        System.out.println("Is isomorphic? - " + isIsomorphic(s1,s2));
    }

    private static boolean isIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        if(s1==null||s1==""){
            return false;
        }
        Map<Character, Character> charMap = new HashMap<Character, Character>();
        char s1CharArray[] = s1.toCharArray();
        char s2CharArray[] = s2.toCharArray();
        
        for(int index = 0; index < s1.length();index++){
            char c1 = s1CharArray[index];
            char c2 = s2CharArray[index];
            if(charMap.containsKey(c1)){
                char c = charMap.get(c1);
                if (c!=c2){
                    return false;
                }
            }
            else {
                if(charMap.containsValue(c2)){
                    return false;
                }
                charMap.put(c1, c2);
            }
        }
        return true;
    }
}
