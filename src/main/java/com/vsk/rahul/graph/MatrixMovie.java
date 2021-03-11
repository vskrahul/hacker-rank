package com.vsk.rahul.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

import com.vsk.rahul.utils.CollectionUtils;

import lombok.AllArgsConstructor;

public class MatrixMovie {
	
	List<List<Matrix>> adjacentList;
	int numberOfCities;
	int numberOfMachines;
	int[] visited;
	int[] machines;
	boolean isCase1 = true;
	
	MatrixMovie(int N, int m) {
		numberOfCities = N;
		numberOfMachines = m;
		visited = new int[N];
		machines = new int[m];
		adjacentList = initializeAdjacencyListOfFixedSizeT(N);
	}
	
	static List<List<Matrix>> initializeAdjacencyListOfFixedSizeT(int size) {
		List<List<Matrix>> list = new ArrayList<>(size);
		
		for(int i = 0; i < size; i++)
			list.add(new ArrayList<>());
		
		return list;
	}
	
	int process() {
		
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> sets = new ArrayList<>();
		
		for(int m = 0; m < this.machines.length; m++) {
			
			if(this.visited[this.machines[m]] == 1)
				continue;
			
			this.visited[this.machines[m]] = 1;
			queue.add(this.machines[m]);
			
			int weightDirectlyConnectedWithCity = 0;
			int weightOfInterConnectedMachines = 0;
			
			while(!queue.isEmpty()) {
				int j = queue.poll();
				List<Matrix> adj = this.adjacentList.get(j);
				
				for(Matrix matrix : adj) {
					if(isMachine(matrix.v)) {
						isCase1 = false;
						if(this.visited[matrix.v] == 0) {
							queue.add(matrix.v);
							weightOfInterConnectedMachines += matrix.w;
							this.visited[matrix.v] = 1;
						}
					} else {
						weightDirectlyConnectedWithCity = matrix.w;
					}
				}
			}
			if(weightOfInterConnectedMachines == 0)
				sets.add(weightDirectlyConnectedWithCity);
			else
				if(weightDirectlyConnectedWithCity == 0)
					sets.add(weightOfInterConnectedMachines);
				else
					sets.add(Integer.min(weightDirectlyConnectedWithCity, weightOfInterConnectedMachines));
		}
		return time(sets, isCase1);
	}
	
	int time(List<Integer> set, boolean flag) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int v : set) {
			sum = sum + v;
			if(v > max)
				max = v;
		}
		return flag ? sum - max : sum;
	}
	
	boolean isMachine(int x) {
		for(int i = 0; i < this.machines.length; i++)
			if(this.machines[i] == x)
				return true;
		return false;
	}
	
	boolean checkInputError(String s) {
		String[] arr = s.split(" ");
		for(String ss : arr) {
			try {
				Integer.parseInt(ss);
			} catch(NumberFormatException e) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(FindTheNearestClone.class
				.getResourceAsStream(String.format("/%s/%s", "graph/matrix", "test_case_3_in.data")));
		Scanner out = new Scanner(FindTheNearestClone.class.getResourceAsStream(
									String.format("/%s/%s", "graph/matrix", "test_case_2_out.data")));
		
		int N = scanner.nextInt();
		int machines = scanner.nextInt();
		
		scanner.nextLine();
		String checkInputError = scanner.nextLine();
		
		MatrixMovie matrixMovie = new MatrixMovie(N, machines);
		
		int x = 0;
		if(!matrixMovie.checkInputError(checkInputError)) {
			x = 1;
			String[] arr = checkInputError.split(" ");
			
			int u = Integer.parseInt(arr[0]);
			int v = Integer.parseInt(arr[1]);
			int w = Integer.parseInt(arr[2]);
			
			Matrix matrix1 = new Matrix(u, v, w);
			Matrix matrix2 = new Matrix(v, u, w);
			
			matrixMovie.adjacentList.get(u).add(matrix1);
			matrixMovie.adjacentList.get(v).add(matrix2);
		}
		
		matrixMovie.numberOfCities = N;
		matrixMovie.numberOfMachines = machines;
		
		for(; x < N - 1; x++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			
			Matrix matrix1 = new Matrix(u, v, w);
			Matrix matrix2 = new Matrix(v, u, w);
			
			matrixMovie.adjacentList.get(u).add(matrix1);
			matrixMovie.adjacentList.get(v).add(matrix2);
		}
		
		for(int y = 0; y < machines; y++) {
			try {
				matrixMovie.machines[y] = scanner.nextInt();
			} catch(NoSuchElementException e) {
				break;
			}
		}
		
		System.out.println(matrixMovie.process());
		
		scanner.close();
		out.close();
	}
}

class Matrix {
	int u;
	int v;
	int w;
	Matrix(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
	public String toString() {
		return String.format("%d->%d {%d}", u, v, w);
	}
}
