/**
 * 
 */
package com.vsk.rahul.utils;

/**
 * <p>Mathematics class.</p>
 *
 * @author Rahul
 * @version $Id: $Id
 */
public class Mathematics {

	/**
	 * <p>factorial.</p>
	 *
	 * @param i a int.
	 * @return a int.
	 */
	public static int factorial(int i) {
		if(i == 1)
			return 1;
		return i * factorial(i - 1);
	}
	
	/**
	 * <p>combinations.</p>
	 *
	 * @param n a int.
	 * @param r a int.
	 * @return a int.
	 */
	public static int combinations(int n, int r) {
		return factorial(n)/(factorial(n-r) * factorial(r));
	}
	
	/**
	 * <p>permutations.</p>
	 *
	 * @param n a int.
	 * @param r a int.
	 * @return a int.
	 */
	public static int permutations(int n, int r) {
		return factorial(n)/factorial(n-r);
	}
}
