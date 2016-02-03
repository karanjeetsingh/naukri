package com.puzzles;

import java.math.BigDecimal;

/**
 * Consider the following word problem: Tom goes to the auto parts store to buy
 * a spark plug that costs $ 1.10, but all he has in his wallet are two-dollar
 * bills. How much change should he get if he pays for the spark plug with a
 * two-dollar bill? Here is a program that attempts to solve the word problem.
 * What does it print? 
 * public class Change { public static void main( String
 * args[ ] ) { System.out.println( 2.00 - 1.10); } }
 * 
 * Bloch, Joshua; Gafter, Neal (2005-06-24). Java™ Puzzlers: Traps, Pitfalls,
 * and Corner Cases (p. 7). Pearson Education. Kindle Edition.
 * 
 * @author karan
 *
 */
public class Puz002_TimeForAChange {

	public static void main(String[] args) {
		change1();
		change2();
		change3();
	}

	/**
	 * This method prints 0.8999999999999999
	 * 
	 * The problem is that the number 1.1 can’t be represented exactly as a
	 * double, so it is represented by the closest double value. The program
	 * subtracts this value from 2. Unfortunately, the result of this
	 * calculation is not the closest double value to 0.9. The shortest
	 * representation of the resulting double value is the hideous number that
	 * you see printed.
	 * 
	 * Bloch, Joshua; Gafter, Neal (2005-06-24). Java™ Puzzlers: Traps,
	 * Pitfalls, and Corner Cases (p. 8). Pearson Education. Kindle Edition.
	 */
	public static void change1() {
		System.out.println(2.00 - 1.10);
	}

	/**
	 * Output - 0.899999999999999911182158029987476766109466552734375
	 * 
	 * new BigDecimal(. 1) returns a BigDecimal representing
	 * 0.1000000000000000055511151231257827021181583404541015625.
	 * 
	 * Bloch, Joshua; Gafter, Neal (2005-06-24). Java™ Puzzlers: Traps,
	 * Pitfalls, and Corner Cases (p. 9). Pearson Education. Kindle Edition.
	 */
	public static void change2() {
		System.out.println(new BigDecimal(2.00).subtract(new BigDecimal(1.10)));
	}

	/**
	 * Output - 0.90
	 * 
	 * Always use the BigDecimal( String) constructor, never BigDecimal(
	 * double). The latter constructor creates an instance with the exact value
	 * of its argument.
	 * 
	 * Bloch, Joshua; Gafter, Neal (2005-06-24). Java™ Puzzlers: Traps,
	 * Pitfalls, and Corner Cases (p. 9). Pearson Education. Kindle Edition.
	 */
	public static void change3() {
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
	}

}
