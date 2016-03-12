package com.jpmorganchase.binaryaddition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		String regex = "[01]+";
		while ((s = in.readLine()) != null) {
			// System.out.println(s);
			String[] binary = s.split(" ");
			if (!(binary[0].matches(regex) && binary[1].matches(regex)))
				continue;

			int length1 = binary[0].length();
			int length2 = binary[1].length();

			if (length1 < length2) {
				binary[0] = addZeroes(binary[0], length2 - length1);
			} else {
				binary[1] = addZeroes(binary[1], length1 - length2);
			}

			int i = (length1 > length2) ? length1 - 1 : length2 - 1;
			int carry = 0;
			Deque<Integer> result = new LinkedList<Integer>();

			while (i >= 0) {
				int res = Character.getNumericValue(binary[0].charAt(i))
						+ Character.getNumericValue(binary[1].charAt(i)) + carry;

				if (res > 1) {
					carry = 1;
					res -= 2;
				} else {
					carry = 0;
				}
				result.push(res);
				i--;
			}
			result.push(carry);

			StringBuilder sb = new StringBuilder();
			while (!result.isEmpty()) {
				sb.append(result.pop());
			}

			Long r = new Long(sb.toString());

			System.out.println(r.toString());
		}
	}

	private static String addZeroes(String string, int i) {
		StringBuilder sb = new StringBuilder();
		for (int index = 0; index < i; index++) {
			sb.append("0");
		}
		sb.append(string);
		return sb.toString();
	}
}
