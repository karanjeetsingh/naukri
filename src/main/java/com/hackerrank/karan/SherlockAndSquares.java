package com.hackerrank.karan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SherlockAndSquares {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int i = (int) Math.sqrt(a);
			if (i*i<a){
				i++;
			}
			int count = 0;
			while (i*i <= b) {
				i++;
				count++;
			}
			System.out.println(count);
		}
	}
}
