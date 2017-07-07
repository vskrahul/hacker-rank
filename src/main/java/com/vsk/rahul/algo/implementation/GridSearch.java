/**
 * 
 */
package com.vsk.rahul.algo.implementation;

/**
 * <p>
 * Given a Grid - 2D matrices
 * and, a Pattern - 2D matrices
 * 
 * <p>
 * This class has method to tell if Grid has any match with given Pattern.
 * 
 * @author Rahul
 *
 */
public class GridSearch {

	public static boolean match(int[][] grid, int[][] pattern) {
		int i1 = grid.length;
		int j1 = grid[0].length;

		int i2 = pattern.length;
		int j2 = pattern[0].length;
		boolean match = false;

		for(int i = 0; i <= i1 - i2; i++) {
			for(int j = 0; j <= j1 - j2; j++) {
				if(pattern[0][0] == grid[i][j]) {
					//match grid
					match = matchPattern(grid, pattern, i, j);
					if(match)
						return match;
				}
			}
		}
		return false;
	}

	private static boolean matchPattern(int[][] grid, int[][] pattern, int x, int y) {
		int i2 = pattern.length;
		int j2 = pattern[0].length;
		
		for(int p1 = 0, i = x; p1 < i2; i++, p1++) {
			for(int p2 = 0, j = y; p2 < j2; j++, p2++) {
				if(pattern[p1][p2] == grid[i][j])
					continue;
				return false;
			}
		}
		return true;
	}
}
