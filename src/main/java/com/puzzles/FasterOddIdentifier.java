package com.puzzles;

import java.util.Date;

public class FasterOddIdentifier {

	public static void main(String[] args) {
		Date dt = new Date();
		long start = dt.getTime();
		System.out.println(isOddArithmetic(56598791));
		dt = new Date();
		long end = dt.getTime();
		long time_a = end - start;
		System.out.println("Time taken to calculate odd using Arithmetic operation - " + time_a + " ticks");
		dt = new Date();
		start = dt.getTime();
		System.out.println(isOddLogical(56665491));
		dt = new Date();
		end = dt.getTime();
		long time_l = end - start;
		System.out.println("Time taken to calculate odd using Logic operation - " + time_l + " ticks");

		if (time_a < time_l)
			System.out.println("Arithmetic is faster");
		else
			System.out.println("Logic is faster");
	}

	/**
	 * Method to check if the number is odd by doing an arithmetic operation of
	 * calculating the remainder and then comparing it to 0.
	 * 
	 * @param a
	 * @return boolean
	 */
	public static boolean isOddArithmetic(int a) {
		return a % 2 != 0;
	}

	public static boolean isOddLogical(int a) {
		return (a & 1) != 0;
	}

}
