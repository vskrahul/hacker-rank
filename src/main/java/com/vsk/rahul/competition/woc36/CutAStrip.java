/**
 * 
 */
package com.vsk.rahul.competition.woc36;

/**
 * Hacker rank problem 
 * <a href="https://www.hackerrank.com/contests/w36/challenges/cut-a-strip">cut-a-strip</a>
 * 
 * <p>
 * n - number of rows in the array
 * <p>
 * m - number of columns in the array
 * <p>
 * k - strip size
 * 
 * <p>
 * 1 <= n, m, k <= 380
 * <p>
 * -5000 <= a[i,j] <= 5000 
 * 
 * @author Rahul Vishvakarma
 *
 */
public class CutAStrip {

	public int cutAStrip(int[][] arr, int strip) {
		
		int MAX = Integer.MIN_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			
			int sum = 0;
			int negativeCount = 0;
			
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] < 0 && sum != 0) {
					negativeCount++;
				}
				
				if(arr[i][j] > 0) {
					if(negativeCount <= strip) {
						sum += arr[i][j];
					} else {
						sum = arr[i][j];
						negativeCount = 0;
					}
					MAX = Integer.max(MAX, sum);
				}
				
			}
		}
		
		
		for(int j = 0; j < arr[0].length; j++) {
			
			int sum = 0;
			int negativeCount = 0;
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i][j] < 0 && sum != 0) {
					negativeCount++;
				}
				
				if(arr[i][j] > 0) {
					if(negativeCount <= strip) {
						sum += arr[i][j];
					} else {
						sum = arr[i][j];
						negativeCount = 0;
					}
					MAX = Integer.max(MAX, sum);
				}
				
			}
		}
		
		return MAX;
	}
}