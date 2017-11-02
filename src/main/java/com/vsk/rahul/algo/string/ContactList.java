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
	
	static class Node {
		
		private Map<Character, Node> node = new HashMap<>();
		
		private int size;
		
		public void put(Character ch) {
			node.putIfAbsent(ch, new Node());
		}
		
		public Node get(Character ch) {
			return node.get(ch);
		}
	}
}