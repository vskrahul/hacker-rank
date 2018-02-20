/**
 * 
 */
package com.vsk.rahul.tree;

import java.util.HashMap;
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
	 * Calculate the height of given node and its all child nodes,
	 * and store all of the in a store and return the store.
	 * 
	 * @return store {@link Map}
	 */
	public Map<Integer, Integer> heightOfEachNode() {
		Map<Integer, Integer> store = new HashMap<>();
		height(this.root, 0, store);
		return store;
	}
	
	/**
	 * Height of the root node.
	 * 
	 * @return height of the root node.
	 */
	public int height() {
		return height(this.root, 0);
	}
	
	/**
	 * Calculate the height of each node individually 
	 * and store in a Map.
	 * 
	 * @param node - root node most of the times.
	 * @param height  - just pass zero.
	 * @param store - store to store the height of each node in {value, height} format.
	 * @return return height of root node + 1
	 */
	private int height(Node node, int height, Map<Integer, Integer> store) {
		if(node == null)
			return 0;
		if(isLeaf(node)) {
			store.put(node.data, 0);
			return 1;
		}
		int left = Integer.max(height(node.left, height, store), height);
		int right = Integer.max(height(node.right, height, store), height);
		store.put(node.data, Integer.max(left, right));
		return Integer.max(left, right) + 1;
	}
	
	/**
	 * Calculate height for the given node.
	 * 
	 * @param node node to for which height is calculated.
	 * @param height - just pass zero as a initial value.
	 * @return height of the given node
	 */
	private int height(Node node, int height) {
		if(node == null || isLeaf(node))
			return height;
		
		if(node.left != null && node.right != null )
			return Integer.max(height(node.left, height + 1), height(node.right, height + 1));
		
		if(node.left != null)
			return height(node.left, height + 1);
		
		if(node.right != null)
			return height(node.right, height + 1);
		
		return 0;
	}
	
	/**
	 * Check if the given is node is leaf or not.
	 * 
	 * @param node node to check if leaf or not?
	 * @return {@code true} if given node is leaf or {@code false}.
	 */
	private boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}
}