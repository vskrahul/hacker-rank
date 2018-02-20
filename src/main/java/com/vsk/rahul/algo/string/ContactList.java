/**
 * 
 */
package com.vsk.rahul.algo.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Rahul
 *
 */
public class ContactList {

	private Node root = new Node();
	
	private static ContactList instance = null;
	
	private ContactList() {
		
	}
	
	private ContactList(String[] words) {
		for(String s : words) {
			add(s);
		}
	}
	
	@Override
	public String toString() {
		return root.toString();
	}
	
	public static ContactList instance() {
		if(Objects.isNull(instance)) {
			synchronized (ContactList.class) {
				if(Objects.isNull(instance)) {
					instance = new ContactList();
				}
			}
		}
		return instance;
	}
	
	public static ContactList instance(String[] words) {
		if(Objects.isNull(instance)) {
			synchronized (ContactList.class) {
				if(Objects.isNull(instance)) {
					instance = new ContactList(words);
				}
			}
		}
		return instance;
	}
	
	public void add(String contact) {
		Node current = root;
		for(int i = 0; i < contact.length(); i++) {
			Character ch = contact.charAt(i);
			current.put(ch);
			current = current.get(ch);
			current.size++;
		}
	}
	
	public int search(String prefix) {
		Node current = root;
		for(int i = 0; i < prefix.length(); i++) {
			Character ch = prefix.charAt(i);
			current = current.get(ch);
			if(Objects.isNull(current))
				return 0;
		}
		return current.size;
	}
	
	public int search(String str, boolean prefixOnly) {
		Node current = root;
		for(int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			current = current.get(ch);
			if(Objects.isNull(current))
				return 0;
		}
		return prefixOnly ? current.size : current.node.size() == 0 ? current.size : 0;
	}
	
	static class Node {
		
		private Map<Character, Node> node = new HashMap<>();
		
		private int size;
		
		@Override
		public String toString() {
			return String.format("[%s#%d]", node, size);
		}
		
		public void put(Character ch) {
			node.putIfAbsent(ch, new Node());
		}
		
		public Node get(Character ch) {
			return node.get(ch);
		}
	}
}