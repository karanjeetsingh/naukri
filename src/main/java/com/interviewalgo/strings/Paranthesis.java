package com.interviewalgo.strings;

import java.util.ArrayList;
import java.util.List;

public class Paranthesis {
	public static void main(String[] args) {
		 System.out.print("n = 1 - ");
		 for(String s : generateParanthesis(1)){
		 System.out.print(s);
		 }
		 System.out.println();

		System.out.print("n = 2 - ");
		for (String s : generateParanthesis(2)) {
			System.out.print(s);
		}
		System.out.println();

//		System.out.print("n = 10 - ");
//		for (String s : generateParanthesis(10)) {
//			System.out.print(s);
//		}
//		System.out.println();

		System.out.print("n = 3 - ");
		for (String s : generateParanthesis(3)) {
			System.out.print(s);
		}
		System.out.println();
	}

	public static List<String> generateParanthesis(int n) {
		List<String> result = new ArrayList<String>();
		if (n == 0) {
			result.add("");
		} else {
			for (int i = n - 1; i >= 0; i--) {
				List<String> insertSub = generateParanthesis(i);
				List<String> tailSub = generateParanthesis(n - 1 - i);
				for (String insert : insertSub) {
					for (String tail : tailSub) {
						result.add("(" + insert + ")" + tail);
					}
				}
			}
		}
		return result;
	}
}
