/**
 * 
 */
package com.vsk.rahul.algo.implementation;

/**
 * @author Rahul
 *
 */
public class BomberMan {

	static final int UPPER_CASE_O = 79;
	
	static final int DOT = 46;
	
	public static int[][] process(int[][] plot, long time) {
		
		int[][] detonating_bombs = new int[plot.length][plot[0].length];
		
		for(long i = 1L; i <= time; i++) {
			int remainder = (int)(i%3L);
			switch(remainder) {
				case 1 : check(plot, detonating_bombs);
						 break;
				case 2 : plant(plot);
						 break;
				case 0 : detonate(plot, detonating_bombs);
						 break;
			}
		}
		return plot;
	}
	
	static void check(int[][] plot, int[][] detonating_bombs) {
		int R = plot.length;
		int C = plot[0].length;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				detonating_bombs[i][j] = plot[i][j];
			}
		}
	}
	
	static void plant(int[][] plot) {
		int R = plot.length;
		int C = plot[0].length;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				plot[i][j] = UPPER_CASE_O;
			}
		}
	}
	
	static void detonate(int[][] plot, int[][] detonating_bombs) {
		int R = plot.length;
		int C = plot[0].length;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(detonating_bombs[i][j] == UPPER_CASE_O) {
					detonate(plot, i, j);
					
					detonate(plot, i, j - 1);
					detonate(plot, i, j + 1);
					
					detonate(plot, i - 1, j);
					detonate(plot, i + 1, j);
				}
			}
		}
	}
	
	private static void detonate(int[][] plot, int i, int j) {
		try{
			plot[i][j] = DOT;
		}catch(IndexOutOfBoundsException e) {
			//ignore
		}
	}
}