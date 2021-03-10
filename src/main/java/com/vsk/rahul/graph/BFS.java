package com.vsk.rahul.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.vsk.rahul.utils.CollectionUtils;

public class BFS {
	
	List<List<Integer>> adjacentList;
	int numberOfVertices;
	int[] visited;
	int[] distance;
	int[] parent;
	
	public BFS(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		this.adjacentList = CollectionUtils.initializeAdjacencyListOfFixedSize(numberOfVertices);
		this.visited = new int[numberOfVertices];
		this.distance = new int[numberOfVertices];
		this.parent = new int[numberOfVertices];
	}
	
	void process(int i) {
		Queue<Integer> queue = new LinkedList<>();
		
		this.distance[i - 1] = 0;
		this.visited[i - 1] = 1;
		queue.add(i);
		
		while(!queue.isEmpty()) {
			int j = queue.poll();
			List<Integer> adjacents = this.adjacentList.get(j - 1);
			
			for(int k : adjacents) {
				if(this.visited[k - 1] == 0) {
					distance[k - 1] = distance[j - 1] + 1;
					visited[k - 1] = 1;
					parent[k - 1] = j;
					queue.add(k);
				}
			}
		}
	}

	public static void main(String[] args) {
		int numberOfVertices = 10;
		BFS graph = new BFS(numberOfVertices);
		
		// 1 -> 2, 3, 4
		graph.adjacentList.get(0).add(2);
		graph.adjacentList.get(0).add(3);
		graph.adjacentList.get(0).add(4);
		// 2 -> 1, 3
		graph.adjacentList.get(1).add(1);
		graph.adjacentList.get(1).add(3);
		// 3 -> 1, 2
		graph.adjacentList.get(2).add(1);
		graph.adjacentList.get(2).add(2);
		// 4 -> 1, 5, 8
		graph.adjacentList.get(3).add(1);
		graph.adjacentList.get(3).add(5);
		graph.adjacentList.get(3).add(8);
		// 5 -> 6, 7, 4
		graph.adjacentList.get(4).add(6);
		graph.adjacentList.get(4).add(7);
		graph.adjacentList.get(4).add(4);
		// 6 -> 5, 7, 8, 9
		graph.adjacentList.get(5).add(5);
		graph.adjacentList.get(5).add(7);
		graph.adjacentList.get(5).add(8);
		graph.adjacentList.get(5).add(9);
		// 7 -> 5, 6
		graph.adjacentList.get(6).add(5);
		graph.adjacentList.get(6).add(6);
		// 8 -> 4, 6, 9
		graph.adjacentList.get(7).add(4);
		graph.adjacentList.get(7).add(6);
		graph.adjacentList.get(7).add(9);
		// 9 -> 6, 8, 10
		graph.adjacentList.get(8).add(6);
		graph.adjacentList.get(8).add(8);
		graph.adjacentList.get(8).add(10);
		// 10 -> 9
		graph.adjacentList.get(9).add(9);
		
		graph.process(1);
		
		System.out.println(Arrays.toString(graph.distance));
		System.out.println(Arrays.toString(graph.parent));
	}
}
