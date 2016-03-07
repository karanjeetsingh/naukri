package com.hackerrank.karan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SherlockAndTheBeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(getDecentNumber(n));
		}
	}

	public static String getDecentNumber(int n) {
		int x = 0, y = 0;
		if (n % 3 == 0) {
			x = n;
		} else {
			while ((x + y) != n) {
				if ((n - 5) == 0) {
					y = n;
				} else {
					y += 5;
					x = n - y;
					if (x % 3 != 0) {
						x = 0;
					}
				}
				if (x < 0 || y > n) {
					return "-1";
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x; i++) {
			sb.append("5");
		}
		for (int i = 0; i < y; i++) {
			sb.append("3");
		}
		System.out.println(x + " " + y);
		return sb.toString();
	}
}
