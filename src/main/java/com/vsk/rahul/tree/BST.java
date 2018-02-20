/**
 * 
 */
package com.vsk.rahul.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>
 * Each node in binary tree has 0, 1 or 2 children.
 * <p>
 * A single node tree is also a valid binary tree.
 * 
 * Binary Tree node has three properties
 * <li>Data
 * <li>Left Node reference
 * <li>Right Node reference
 * 
 * @author Rahul
 *
 */
public class BST {

	public static class Node {
		private Integer data;
		
		private Node left;
		
		private Node right;
		
		@Override
		public String toString() {
			return String.format("[%d]", data);
		}
		
		public Node(Integer data) {
			this.data = data;
		}
	}
	
	private Node root = null;
	
	public BST() {
		this.root = null;
	}
	
	public BST(Node root) {
		this.root = root;
	}
	
	public Node root() {
		return this.root;
	}
	
	public Node insertRecur(Integer data) {
		this.root = insertRecur(root, data); 
		return this.root;
	}
	
	private Node insertRecur(Node root, Integer data) {
		
		if(root == null) {
			root = new Node(data);
			return root;
		}
		
		if(data < root.data) {
			root.left = insertRecur(root.left, data);
		} else {
			if(data > root.data)
				root.right = insertRecur(root.right, data);
		}
		
		return root;
	}
	
	/**
	 * Insert data in {@link BinarySearchTree}
	 * 
	 * @param data
	 * @return
	 */
	public Node insert(Integer data) {
		
		if(root == null) {
			root = new Node(data);
			return root;
		}
		
		Node p1 = root, p2 = root;
		boolean left = true;
		while(p2 != null) {
			p1 = p2;
			if(data < p1.data) {
				left = true;
				p2 = p1.left;
			} else {
				if(data > p1.data) {
					left = false;
					p2 = p1.right;
				} else {
					System.out.printf("%d is already exists.", data);
					return root;
				}
			}
		}
		if(left) {
			p1.left = new Node(data);
		} else {
			p1.right = new Node(data);
		}
		return root;
	}
	
	public void remove(Integer data) {
		
	}
	
	public Integer search(Integer data) {
		return search(root, data);
	}
	
	private Integer search(Node root, Integer data) {
		if(root != null) {
			if(data < root.data) {
				search(root.left, data);
			} else {
				if(data > root.data) {
					search(root.right, data);
				} else {
					if(data == root.data) {
						return data;
					}
				}
			}
		}
		return null;
	}
	
	public int size() {
		return 0;
	}
	
	public int height() {
		return 0;
	}
	
	public int levelHasMaxSum() {
		return 0;
	}
	
	/**
	 * LDR - Sorted sequence
	 * 
	 * @param root
	 */
	public void inOrderRecur() {
		inOrderRecur(root);
	}
	
	private void inOrderRecur(Node root) {
		if(root != null) {
			inOrderRecur(root.left);
			System.out.printf("%d->", root.data);
			inOrderRecur(root.right);
		}
	}
	
	/**
	 * LDR - Sorted sequence
	 */
	public void inOrder() {
		
		Stack<Node> stack = new Stack<>();
		
		Node pointer = root;
		
		while(true) {
			
			while(pointer != null) {
				stack.push(pointer);
				pointer = pointer.left;
			}
			
			if(stack.empty())
				break;
			
			pointer = stack.pop();
			System.out.printf("%d ", pointer.data);
			pointer = pointer.right;
		}
	}
	
	/**
	 * DLR
	 * 
	 * @param root
	 */
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node root) {
		if(root != null) {
			System.out.printf("%d->", root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	/**
	 * LRD
	 * 
	 * @param root
	 */
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(Node root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.printf("%d->", root.data);
		}
	}
	
	/**
	 * 
	 */
	public void levelOrder() {
		Node pointer = root;
		
		Queue<Node> currentLevel = new LinkedList<>();
		Queue<Node> nextLevel = new LinkedList<>();
		
		currentLevel.add(pointer);
		
		while(!currentLevel.isEmpty()) {
			Node node = currentLevel.poll();
			System.out.printf("%d, ", node.data);
			if(node.left != null) nextLevel.add(node.left);
			if(node.right != null) nextLevel.add(node.right);
			
			/**
			 * Current Level is processed completely.
			 * Let's move to next level.
			 */
			if(currentLevel.isEmpty()) {
				System.out.printf("\n");
				currentLevel.addAll(nextLevel);
				nextLevel.clear();
			}
		}
	}
	
	/**
	 * <p>
	 * Function to calculate the height of balanced BST.
	 * <p>
	 * E.g;
	 * 
	 * <p>
	 * for {@code numberOfNodes = 3}, height = (log4/log2 - 1) => 1;
	 * 
	 * @param numberOfNodes  total number of nodes in the BST
	 * @return height - root is considered to be at level 0
	 */
	public int height(int numberOfNodes) {
		return (int)(Math.log(numberOfNodes + 1)/Math.log(2) - 1);
	}
	
	/**
	 * Height of a node from its most distant leaf
	 * 
	 * @param node {@link Node}
	 * @return height of the given node
	 */
	public int height(Node node, Map<Integer, Integer> store) {
		return height(node, 0, 0, store);
	}
	
	public int heightOfEachNode(Node node, int height) {
		if(node == null)
			return 0;
		if(isLeaf(node))
			return 1;
		int left = Integer.max(heightOfEachNode(node.left, height), height);
		int right = Integer.max(heightOfEachNode(node.right, height), height);
		return Integer.max(left, right) + left + right;
	}
	
	private int height(Node node, int height, int max, Map<Integer, Integer> store) {
		if(node == null)
			return Integer.max(height, max) - 1;
		max = Integer.max(height(node.left, height + 1, max, store), max);
		max = Integer.max(height(node.right, height + 1, max, store), max);
		store.put(node.data, max);
		return max;
	}
	
	private boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}
}