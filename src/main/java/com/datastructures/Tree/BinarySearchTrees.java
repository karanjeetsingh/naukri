package com.datastructures.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTrees {

	public static Node root;

	public static void insert(int value) {
		Node node = new Node(value);

		if (root == null) {
			root = node;
			return;
		}

		insertRec(root, node);
	}

	public static void insertRec(Node latestRoot, Node node) {
		if (latestRoot.value > node.value) {
			if (latestRoot.left == null) {
				latestRoot.left = node;
				return;
			} else {
				insertRec(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
				return;
			} else {
				insertRec(latestRoot.right, node);
			}
		}
	}

	public static int findMinimum() {
		if (root == null) {
			return 0;
		}
		Node currNode = root;
		while (currNode.left != null) {
			currNode = currNode.left;
		}
		return currNode.value;
	}
	
	public static int findMaximum(){
		if(root == null){
			return 0;
		}
		Node currNode = root;
		while(currNode.right!=null){
			currNode = currNode.right;
		}
		return currNode.value;
	}
	
	public static void printInorder(){
		System.out.print("Printing tree Inorder - ");
		printInorderRec(root);
		System.out.println();
	}
	
	private static void printInorderRec(Node currNode){
		if(currNode == null){
			return;
		}
		printInorderRec(currNode.left);
		System.out.print(currNode.value+", ");
		printInorderRec(currNode.right);
	}
	
	public static void printPostorder(){
		System.out.print("Printing tree Postorder - ");
		printPostorderRec(root);
		System.out.println();
	}
	
	private static void printPostorderRec(Node currNode){
		if(currNode == null){
			return;
		}
		printPostorderRec(currNode.left);
		printPostorderRec(currNode.right);
		System.out.print(currNode.value+", ");
	}
	
	public static void printPreorder(){
		System.out.print("Printing tree Preorder - ");
		printPreorderRec(root);
		System.out.println();
	}
	
	private static void printPreorderRec(Node currNode){
		if(currNode == null){
			return;
		}
		System.out.print(currNode.value+", ");
		printPreorderRec(currNode.left);
		printPreorderRec(currNode.right);
	}
	
	public static void printLevelorder(){
		if(root == null)
			return;
		System.out.print("Printing level order - ");
		Queue<Node> nodeQ = new LinkedList<Node>();
		nodeQ.add(root);
		while(!nodeQ.isEmpty()){
			Node n = nodeQ.poll();
			System.out.print(n.value + " ");
			if(n.left != null){
				nodeQ.add(n.left);
			}
			if(n.right != null){
				nodeQ.add(n.right);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		root = new Node(40);
		root.left = new Node(25);
		root.left.left = new Node(10);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(17);
		root.left.right = new Node(32);
		root.left.right.left = new Node(30);
		root.left.right.right = new Node(38);
		root.right = new Node(78);
		root.right.left = new Node(50);
		root.right.right = new Node(93);

		insert(64);
		if (root.right.left.right.value == 64) {
			System.out.println("successfully inserted");
		}
		System.out.println("Minimum value - " + findMinimum());
		System.out.println("Maximum value - " + findMaximum());
		printInorder();
		printPostorder();
		printPreorder();
		printLevelorder();
		System.out.println("finished");
	}

}