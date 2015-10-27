package com.interviewalgo.strings;

import java.io.IOException;
import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression. For example:
 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] ->
 * (4 + (13 / 5)) -> 6
 * 
 * @author ksingh
 * 
 */
public class ReversePolishNotation {
    public static void main(String[] args) throws IOException {
        String[] tokens = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(tokens));
    }

    private static float evalRPN(String[] tokens) {
        float returnValue = 0;
        String operators = "+-/*";
        Stack<String> stack = new Stack<String>();

        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                float a = Float.valueOf(stack.pop());
                float b = Float.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch (index) {
                case 0:
                    stack.push(String.valueOf(a + b));
                    break;
                case 1:
                    stack.push(String.valueOf(b - a));
                    break;
                case 2:
                    stack.push(String.valueOf(b / a));
                    break;
                case 3:
                    stack.push(String.valueOf(a * b));
                    break;
                }
            }
        }
        
        returnValue = Float.valueOf(stack.pop());

        return returnValue;
    }
}
