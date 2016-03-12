package com.foobar.dictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// write your code here
		String document = "world there hello hello where world";
		String[] searchTerms = { "hello", "world" };
		// String document = "a b c d a";
		// String[] searchTerms = {"a", "c", "d"};

		System.out.println(answer(document, searchTerms));
	}

	public static String answer(String document, String[] searchTerms) {

		// Your code goes here.

		String[] docs = document.split(" ");
		List<String> search = new ArrayList<String>();

		Collections.addAll(search, searchTerms);

		int l = 0;
		int left = -1;
		int right = 0;
		String ans = "";
		String prev = "";

		while (l < docs.length) {
			if (search.contains(docs[l])) {
				search.remove(docs[l]);
				if (left == -1)
					left = l;
			}
			if (search.isEmpty()) {
				right = l;
				for (int i = left; i <= right; i++) {
					ans += docs[i];
					if (i != right) {
						ans += " ";
					}
				}
				if (prev == "" || ans.length() < prev.length()) {
					prev = ans;
					ans = "";
				}
				Collections.addAll(search, searchTerms);
				l = left;
				left = -1;
				right = 0;
			}
			l++;
		}

		return prev;
	}

}
