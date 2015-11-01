package com.iq.wordladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class WordNode {
	String word;
	int stepcount;

	public WordNode(String word, int stepcount) {
		this.word = word;
		this.stepcount = stepcount;
	}
}

class solution {
	public int ladderlength(String wordBegin, String wordEnd, Set<String> wordDict) {
		LinkedList<WordNode> queue = new LinkedList<>();
		queue.add(new WordNode(wordBegin, 1));

		wordDict.add(wordEnd);

		while (!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;
			// System.out.println("word - " + word);
			if (word.equals(wordEnd))
				return top.stepcount;

			char[] arr = word.toCharArray();

			for (int i = 0; i < arr.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char temp = arr[i];
					if (arr[i] != c) {
						arr[i] = c;
					}

					String newword = new String(arr);
					// System.out.println(newword);
					if (wordDict.contains(newword)) {
						queue.add(new WordNode(newword, top.stepcount + 1));
						wordDict.remove(newword);
						// System.out.println(newword + " added to queue");
					}
					arr[i] = temp;
				}
			}
		}

		return 0;
	}
}

/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that only one letter
 * can be changed at a time and each intermediate word must exist in the
 * dictionary. For example, given:
 * 
 * start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * 
 * One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the
 * program should return its length 5.
 * 
 * @author kanwal
 *
 */
public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution sol = new solution();
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");

		System.out.println(sol.ladderlength("hit", "cog", dict));
	}
}
