package com.foobar.minglish;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) {
		String[] words = {"c","cac","cb","bcc","ba"};
		System.out.println(answer(words));
	}
	
	public static Deque<Character> dq = null;
	public static List<Node> temp = null;

	static class Node {
		Character ch;
		List<Node> neighbours;
		boolean isVisited;

		public Node() {
			neighbours = new ArrayList<Node>();
		}

		public Node(Character ch) {
			this.ch = ch;
			this.neighbours = new ArrayList<Node>();
			this.isVisited = false;
		}

		public void addNeighbour(Node n) {
			this.neighbours.add(n);
		}
	}	

	public static String answer(String[] words) {
		// Create graph
		List<Node> nodes = new ArrayList<Node>();
		for (int index = 0; index < words.length - 1; index++) {
			char[] w1 = words[index].toCharArray();
			char[] w2 = words[index + 1].toCharArray();

			// populate vertices
			for (Character c : w1) {
				if (!isInGraph(nodes, c)) {
					nodes.add(new Node(c));
				}
			}
			for (Character c : w2) {
				if (!isInGraph(nodes, c)) {
					nodes.add(new Node(c));
				}
			}

			// Draw edges
			int length = (w1.length < w2.length) ? w1.length : w2.length;
			for (int i = 0; i < length; i++) {
				if(w1[i]!=w2[i]){
					drawEdge(nodes, w1[i], w2[i]);
					break;
				}
			}
		}
		
		// traverse
		dq = new LinkedList<Character>();
		temp = new ArrayList<Node>();
		
		for(Node n : nodes){
			if(!n.isVisited){
				visit(nodes, n);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!dq.isEmpty()){
			sb.append(dq.poll());
		}
		
		return sb.toString();
	}
	
	private static void visit(List<Node> nodes, Node n) {
		if(!n.isVisited){
			temp.add(n);
			for(Node neighbour : n.neighbours){
				visit(nodes,neighbour);
			}
			n.isVisited = true;
			temp.remove(n);
			dq.offer(n.ch);
		}	
	}

	public static void drawEdge(List<Node> nodes, Character c1, Character c2){
		Node n1 = findNode(nodes, c1);
		Node n2 = findNode(nodes, c2);
		n1.addNeighbour(n2);
	}
	
	public static Node findNode(List<Node> nodes, Character c){
		for(Node n : nodes){
			if(n.ch.equals(c)){
				return n;
			}
		}
		return null;
	}

	public static boolean isInGraph(List<Node> nodes, Character c) {
		for (Node n : nodes) {
			if (n.ch.equals(c)) {
				return true;
			}
		}
		return false;
	}

}
