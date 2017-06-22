/**
 * 
 */
package com.vsk.rahul.utils;

/**
 * @author Rahul
 *
 */
public class Mathematics {

	public static int factorial(int i) {
		if(i == 1)
			return 1;
		return i * factorial(i - 1);
	}
	
	public static int combinations(int n, int r) {
		return Mathematics.factorial(n)/(Mathematics.factorial(n-r) * Mathematics.factorial(r));
	}
	
	public static int permutations(int n, int r) {
		return Mathematics.factorial(n)/Mathematics.factorial(n-r);
	}
}