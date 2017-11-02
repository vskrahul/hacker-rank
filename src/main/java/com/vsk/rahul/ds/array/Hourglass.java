/**
 * 
 */
package com.vsk.rahul.ds.array;

/**
 * @author Rahul
 *
 */
public class Hourglass {

	public static void main(String[] args) {
		
		int N = 6;
		int[][] hourglass = new int[][]{
			{-1, -1, 0, -9, -2, -2},
			{-2, -1, -6, -8, -2, -5},
			{-1, -1, -1, -2, -3, -4},
			{-1, -9, -2, -4, -4, -5},
			{-7, -3, -3, -2, -9, -9},
			{-1, -3, -1, -2, -4, -5}
		};

		int max = -64;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				int sum = sum(hourglass, i, j, N, max);
				if (max < sum)
					max = sum;
			}
		}
		System.out.print(max);
	}

	static int sum(int[][] hourglass, int i, int j, int N, int max) {
		if (i + 2 >= N || j + 2 >= N)
			return max;

		return hourglass[i][j] + hourglass[i][j + 1] + hourglass[i][j + 2] 
								+ hourglass[i + 1][j + 1]
				+ hourglass[i + 2][j] + hourglass[i + 2][j + 1] + hourglass[i + 2][j + 2];
	}
}
