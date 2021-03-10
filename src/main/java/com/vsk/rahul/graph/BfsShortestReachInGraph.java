package com.vsk.rahul.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BfsShortestReachInGraph {
	
	int[] distance;
	List<List<Integer>> adjacencyList;
	int numberOfVertices;
	int numberOfEdges;
	
	public BfsShortestReachInGraph(int numberOfVertices, int numberOfEdges) {
		this.numberOfVertices = numberOfVertices;
		this.numberOfEdges = numberOfEdges;
		this.distance = new int[numberOfVertices];
		this.adjacencyList = initializeListOfFixedSize(numberOfVertices);
		
		Arrays.fill(this.distance, -1);
	}
	
	public static List<List<Integer>> initializeListOfFixedSize(int size) {
		List<List<Integer>> list = new ArrayList<>(size);
		
		for(int i = 0; i < size; i++)
			list.add(new ArrayList<Integer>());
		
		return list;
	}
	
	/**
	 * u -> v
	 * 
	 * @param u out edge
	 * @param v in edge
	 */
	void addEdge(int u , int v) {		
		this.adjacencyList.get(u - 1).add(v);
		this.adjacencyList.get(v - 1).add(u);
	}
	
	void shortestPathFrom(int source) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		this.distance[source - 1] = 0;
		
		boolean[] visited = new boolean[this.numberOfVertices];
		
		while(!queue.isEmpty()) {
			int v = queue.poll();

			visited[source - 1] = true;
			
			List<Integer> adjacentVertices = this.adjacencyList.get(v - 1);
			
			for(int e : adjacentVertices) {
				if(!visited[e - 1]) {
					queue.add(e);
					visited[e - 1] = true;
					this.distance[e - 1] = this.distance[v - 1] + 6;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int queries = scanner.nextInt();

		for (int t = 0; t < queries; t++) {

			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			BfsShortestReachInGraph graph = new BfsShortestReachInGraph(n, m);

			// read and set edges
			for (int i = 0; i < m; i++) {
				int u = scanner.nextInt();
				int v = scanner.nextInt();

				// add each edge to the graph
				graph.addEdge(u, v);
			}

			// Find shortest reach from node s
			int startId = scanner.nextInt();
			graph.shortestPathFrom(startId);

			for (int i = 0; i < graph.distance.length; i++) {
				if (i != startId - 1) {
					System.out.print(graph.distance[i]);
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		scanner.close();
	}
}
