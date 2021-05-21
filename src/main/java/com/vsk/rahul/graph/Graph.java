package com.vsk.rahul.graph;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Graph<T> {

	private Map<T, Set<T>> adjacencyList = new HashMap<>();
	private Map<T, Integer> indegree = new HashMap<>();
	
	public Graph<T> add(T from, T to) {
		assertNotNull("from vertex can not be null", from);
		assertNotNull("to vertex can not be null", to);
		
		if(this.adjacencyList.get(from) == null)
			this.adjacencyList.put(from, new TreeSet<T>());
		
		if(this.adjacencyList.get(to) == null)
			this.adjacencyList.put(to, new TreeSet<T>());
		
		if(this.adjacencyList.get(from).add(to)) {
			this.indegree.put(to, this.indegree.getOrDefault(to, 0) + 1);
			if(this.indegree.get(from) == null) {
				this.indegree.put(from, 0);
			}
		}
		return this;
	}
	
	public Set<T> neighbourVertices(T t) {
		return this.adjacencyList.get(t);
	}
	
	public int indegree(T vertex) {
		assertNotNull("vertex can not be zero or less than zero", vertex);
		assertNotNull("vertex doesn't exists", this.indegree.get(vertex));
		return this.indegree.get(vertex);
	}
	
	public Map<T, Integer> indegree() {
		return new HashMap<>(this.indegree);
	}
	
	public int outdegree(T vertex) {
		assertNotNull("vertex can not be null", vertex);
		assertNotNull("vertex doesn't exists", this.adjacencyList.get(vertex));
		return this.adjacencyList.get(vertex).size();
	}
	
	public Map<T, Integer> outdegree() {
		return this.adjacencyList.entrySet()
				.stream()
				.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()));
	}
	
	public void print() {
		this.adjacencyList.entrySet()
				.stream()
				.forEach(e -> {
					System.out.println(String.format("%s -> %s", e.getKey(), e.getValue()));
				});
	}
	
	public void printIndegree() {
		printDegree(indegree());
	}
	
	public void printOutdegree() {
		printDegree(outdegree());
	}
	
	private void printDegree(Map<T, Integer> degree) {
		degree.entrySet()
				.stream()
				.map(e -> e.getKey())
				.sorted()
				.forEach(e -> {
					System.out.println(String.format("%s -> %d", e, degree.get(e)));
				});
	}
}