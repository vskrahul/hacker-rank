package com.vsk.rahul.graph;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class DfsConnectedCell_InAGrid {
	
	static int colorCode = 0;
	static Map<Integer, Integer> gridCounter = new HashMap<>();
	
	static Grid[][] convertToGridArray(int[][] grid) {
		
		Grid[][] grids = new Grid[grid.length][];
		
		for(int i = 0; i < grid.length; i++) {
			grids[i] = new Grid[grid[i].length];
			for(int j = 0; j < grid[i].length; j++) {
				Grid g = new Grid(-1, grid[i][j]);
				grids[i][j] = g;
			}
		}
		return grids;
	}

	static int maxRegion(int[][] grid) {
		
		Grid[][] gridArray = convertToGridArray(grid);
		
		for(int i = 0; i < gridArray.length; i++) {
			
			for(int j = 0; j < gridArray[i].length; j++) {
				
				Grid gridCell = gridValue(i, j, gridArray);
				
				if(isNotEmpty(gridCell)) {
					int cc = getColorCodeFromNeighbour(i, j, gridArray);
					
					if(cc == -1) {
						colorCode++;
						gridCell.colorCode = colorCode;
					} else {
						gridCell.colorCode = cc;
					}
					Integer count = gridCounter.get(gridCell.colorCode);
					if(count == null)
						count = 0;
					count++;
					gridCounter.put(gridCell.colorCode, count);
				}
			}
		}
		
		return maxGridCounter();
    }
	
	static int maxGridCounter() {
		OptionalInt count = gridCounter.keySet()
										.stream()
										.mapToInt(k -> gridCounter.get(k))
										.max();
		if(count.isPresent()) 
			return count.getAsInt();
		else
			return -1;
	}
	
	static int getColorCodeFromNeighbour(int i, int j, Grid[][] grid) {
		Grid left = gridValue(i, j - 1, grid);
		if(isNotEmpty(left)) {
			return left.colorCode;
		}
		
		Grid leftDiagonal = gridValue(i - 1, j - 1, grid);
		if(isNotEmpty(leftDiagonal)) {
			return leftDiagonal.colorCode;
		}
		
		Grid top = gridValue(i - 1, j, grid);
		if(isNotEmpty(top)) {
			return top.colorCode;
		}
		
		Grid topDiagonal = gridValue(i - 1, j + 1, grid);
		if(isNotEmpty(topDiagonal)) {
			return topDiagonal.colorCode;
		}
		return -1;
	}
	
	static Grid gridValue(int i, int j, Grid[][] grid) {
		if(i >= 0 && i < grid.length
				&& j >= 0 && j<= grid[i].length) {
			return grid[i][j];
		}
		return null;
	}
	
	static boolean isNotEmpty(Grid grid) {
		return grid != null && grid.value == 1; 
	}
	

	public static void main(String[] args) throws IOException {
		

		int[][] grid = new int[5][];

		grid[0] = new int[] {1, 0, 1, 1, 0};
		grid[1] = new int[] {1, 1, 0, 0, 1};
		grid[2] = new int[] {0, 1, 1, 1, 0};
		grid[3] = new int[] {0, 0, 0, 0, 1};
		grid[4] = new int[] {1, 1, 1, 0, 0};

		int res = maxRegion(grid);
		System.out.println(res);

	}
}

class Grid {
	int colorCode;
	int value;
	boolean visited;
	
	Grid(int colorCode, int value) {
		this.colorCode = colorCode;
		this.value = value;
	}
	public String toString() {
		return String.format("[%d {%d}]", value, colorCode);
	}
}