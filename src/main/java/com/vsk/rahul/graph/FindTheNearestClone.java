package com.vsk.rahul.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.vsk.rahul.utils.CollectionUtils;

public class FindTheNearestClone {
	
	List<List<Integer>> adjacentList;
	int numberOfVertices;
	int[] visited;
	int[] distance;
	int[] parent;
	int[] colorTags;
	
	public FindTheNearestClone(int numberOfVertices) {
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
	
	int nearestNode(int x) {
		
		int minDist = Integer.MAX_VALUE;
		
		for(int i = 0; i < this.numberOfVertices; i++) {
			int key = -1;
			if(this.colorTags[i] == x)
				key = i;
			else
				continue;
			
			for(int k = key + 1; k < this.numberOfVertices; k++) {
				if(this.colorTags[k] == x) {
					if(minDist > distance[k] - distance[key]) {
						minDist = distance[k] - distance[key];
					}
				}
			}
			
		}
		return minDist == Integer.MAX_VALUE ? -1 : minDist;
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(FindTheNearestClone.class
				.getResourceAsStream(String.format("/%s/%s", "graph/find_nearest_clone", "test_case_4_in.data")));
		Scanner out = new Scanner(FindTheNearestClone.class.getResourceAsStream(
									String.format("/%s/%s", "graph/find_nearest_clone", "test_case_4_out.data")));
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		FindTheNearestClone nearest = new FindTheNearestClone(n);
		
		for (int i = 0; i < m; i++) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			
			nearest.adjacentList.get(from - 1).add(to);
			nearest.adjacentList.get(to - 1).add(from);
		}
		nearest.colorTags = new int[n]; 
		for (int i = 0; i < n; i++) {
			nearest.colorTags[i] = scanner.nextInt();
		}
		int colorToMatch = scanner.nextInt();
		
		int key = 1;
		for(int k = 0; k < nearest.numberOfVertices; k++) {
			if(nearest.colorTags[k] == colorToMatch) {
				key = k + 1;
				break;
			}
		}
		
		nearest.process(key);
		
		System.out.println(Arrays.toString(nearest.colorTags));
		System.out.println(Arrays.toString(nearest.distance));
		System.out.println(nearest.nearestNode(colorToMatch));
		
		scanner.close();
		out.close();
	}
}