package com.foobar.spysnippet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
//		String document = "many google employees can program can google employees because google is a technology company that writes programs";
//		String[] searchTerms = { "google", "program", "can" };
		String document = "a b d a c a c c d a";
		String[] searchTerms = { "a", "c", "d"};
		
		System.out.println(answer(document, searchTerms));

	}

	public static String answer(String document, String[] searchTerms) {
		Map<String, Integer> indexMap = new HashMap<String, Integer>();
		List<List<Integer>> indexList = new ArrayList<List<Integer>>();

		int index = 0;
		for (String s : searchTerms) {
			List<Integer> indexL = new ArrayList<Integer>();
			indexList.add(indexL);
			indexMap.put(s, index++);
		}

		index = 0;
		String[] doc = document.split(" ");
		for (String s : doc) {
			if (indexMap.containsKey(s)) {
				indexList.get(indexMap.get(s)).add(index);
			}
			index++;
		}

		int minScore = Integer.MAX_VALUE;
		String result = "";

		for (List<Integer> list : indexList) {
			for (Integer position : list) {
				List<Integer> positions = new ArrayList<Integer>();
				positions.add(position);
				for (List<Integer> otherList : indexList) {
					List<Integer> distances = new ArrayList<Integer>();
					for (Integer x : otherList) {
						distances.add(Math.abs(position - x));
					}
					positions.add(otherList.get(distances.indexOf(Collections.min(distances))));
				}

				int max = (int) Collections.max(positions);
				int min = (int) Collections.min(positions);
				int score = max - min + 1;
				if (score < minScore) {
					int i = min;
					StringBuilder sb = new StringBuilder();
					while (i <= max) {
						sb.append(doc[i++]);
						sb.append(" ");
					}
					result = sb.toString();
					minScore = score;
				}
			}
		}

		return result;
	}

}
