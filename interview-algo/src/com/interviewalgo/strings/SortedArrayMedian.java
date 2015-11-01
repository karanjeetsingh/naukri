package com.iq.sortarraymedian;

import java.util.Scanner;

class FindMedian {
	int max(int first, int second) {
		if (first > second)
			return first;
		else
			return second;
	}

	int min(int first, int second) {
		if (first < second)
			return first;
		else
			return second;
	}

	float findMed(int[] arrayA, int[] arrayB, int startA, int endA, int startB, int endB) {
		int alen = endA - startA + 1;
		int blen = endB - startB + 1;
		int medA, medB;
		if (alen == blen && blen == 0)
			return 0;

		if (alen == blen && blen == 2) {
			return (float) (max(arrayA[startA], arrayB[startA]) + min(arrayA[endA], arrayB[endB])) / 2;
		}

		if (alen % 2 == 0)
			medA = (int) ((arrayA[alen / 2] + arrayA[alen / 2 - 1]) * 0.5);
		else
			medA = arrayA[alen / 2];

		if (blen % 2 == 0)
			medB = (int) ((arrayB[blen / 2] + arrayB[blen - 1]) * 0.5);
		else
			medB = arrayB[blen / 2];

		if (arrayA[medA] == arrayB[medB])
			return arrayA[medA];

		if (medA > medB) {
			findMed(arrayA, arrayB, startA, medA, medB, endB);
		} else {
			findMed(arrayA, arrayB, medA, endA, startB, medB);
		}
		return medB;
	}

}

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 * @author kanwal
 *
 */
public class SortedArrayMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMedian medianObj = new FindMedian();
		Scanner inputStream = new Scanner(System.in);
		int Alen, Blen;
		int[] arrayA;
		int[] arrayB;
		System.out.println("Enter length of array A.");
		Alen = Integer.valueOf(inputStream.next());
		System.out.println("Enter the sorted array A.");
		arrayA = new int[Alen];
		for (int i = 0; i < Alen; i++) {
			arrayA[i] = Integer.valueOf(inputStream.next());
		}

		System.out.println("Enter length of array B.");
		Blen = Integer.valueOf(inputStream.next());
		System.out.println("Enter the sorted array B.");
		arrayB = new int[Blen];
		for (int i = 0; i < Blen; i++) {
			arrayB[i] = Integer.valueOf(inputStream.next());
		}

		System.out.println("Array A :" + arrayA);
		System.out.println("Array B :" + arrayB);
		inputStream.close();

		System.out.println(medianObj.findMed(arrayA, arrayB, 0, Alen, 0, Blen));
	}

}
