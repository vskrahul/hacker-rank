/**
 * 
 */
package com.vsk.rahul.algo.string;

/**
 * @author Rahul
 *
 */
public class TwoCharacters {

	public static int longestAltString(String s) {
	    char [][] letters = new char[3][3];
	    int [][] values = new int[3][3];
	    for(char c : s.toCharArray()) {
	        int index = (int)(c - 'a');
	        for(int i = 0; i < 3; i++) {
	            if(letters[index][i] != c && values[index][i] != -1) {
	                letters[index][i] = c;
	                ++values[index][i];
	            } else {
	                values[index][i] = -1;
	            }
	            if(letters[i][index] != c && values[i][index] != -1) {
	                letters[i][index] = c;
	                ++values[i][index];
	            } else {
	                values[i][index] = -1;
	            }
	            print(letters);
	            print(values);
	        }
	    }
	    int largestString = 0;
	    for(int i = 0; i < 3; i++) {
	        for(int j = 0; j < 3; j++) {
	            if(values[i][j] > largestString) {
	                largestString = values[i][j];
	            }
	        }
	    }
	    if(largestString > 1) {
	        return largestString;
	    } else {
	        return 0;
	    }
	}
	
	private static void print(char[][] letters){
		int R = letters.length;
		int C = letters[0].length;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(String.format("%c ", letters[i][j]));
			}
			System.out.print("\n");
		}
	}
	
	private static void print(int[][] values) {
		int R = values.length;
		int C = values[0].length;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(String.format("%d ", values[i][j]));
			}
			System.out.print("\n");
		}
	}
}
