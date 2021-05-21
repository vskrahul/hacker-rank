package com.vsk.rahul.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * Topological Sorting
 * </p>
 * 
 * @author Rahul.Vishvakarma
 *
 */
public class TopologicalSort<T> {

    private Graph<T> graph = new Graph<>();
    private Map<T, Integer> indegree = null;
    
    public TopologicalSort<T> add(T from, T to) {
    	this.graph.add(from, to);
    	return this;
    }
    
    public List<T> process() {
    	this.indegree = this.graph.indegree();
    	List<T> topologicalOrder = new ArrayList<>();
    	Queue<T> queue = initialIndegreeZeroVertices();
    	
    	while(!queue.isEmpty()) {
    		T v = queue.poll();
    		this.indegree.remove(v);
    		decreaseNeighbourInDegreeByOne(queue, v);
    		topologicalOrder.add(v);
    	}
    	return topologicalOrder;
    }
    
    private Queue<T> initialIndegreeZeroVertices() {
    	
    	return this.indegree.entrySet()
    				.stream()
    				.filter(e -> e.getValue() == 0)
    				.map(e -> e.getKey())
    				.collect(Collectors.toCollection(LinkedList::new));
    }
    
    private void decreaseNeighbourInDegreeByOne(Queue<T> queue, T v) {
    	Set<T> neighboutVertices = this.graph.neighbourVertices(v);
    	for(T n : neighboutVertices) {
    		Integer in = this.indegree.get(n);
    		if(in != null) {
    			this.indegree.put(n, in - 1);
    			if(in == 1)
    				queue.add(n);
    		}
    	}
    }
    
    List<Integer> indegree(Map<T, Integer> indegree) {
    	return indegree.entrySet()
		        		.stream()
		        		.map(e -> e.getKey())
		        		.sorted()
		        		.map(e -> indegree.get(e))
		        		.collect(Collectors.toList());
    }

    public static void main(String[] args) {
        
    	TopologicalSort<String> topological = new TopologicalSort<>();

        topological.add("1", "3").add("1", "4").add("1", "5")
	        				.add("2", "3").add("2", "8")
	        				.add("3", "6")
	        				.add("4", "6").add("4", "8")
	        				.add("5", "8")
	        				.add("6", "7")
	        				.add("7", "8");
        
        topological.graph.print();
        
        List<String> topologicalOrder = topological.process();
        
        topologicalOrder.stream()
        				.map(s -> s + " -> ")
        				.forEach(System.out::print);
    }
}
