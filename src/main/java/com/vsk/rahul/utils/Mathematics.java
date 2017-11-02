/**
 * 
 */
package com.vsk.rahul.utils;

/**
 * <p>
 * Mathematics class.
 * </p>
 *
 * @author Rahul
 * @version $Id: $Id
 */
public class Mathematics {

	/**
	 * <p>
	 * factorial.
	 * </p>
	 *
	 * @param i
	 *            a int.
	 * @return a int.
	 */
	public static int factorial(int i) {
		if (i == 1)
			return 1;
		return i * factorial(i - 1);
	}

	/**
	 * <p>
	 * combinations.
	 * </p>
	 *
	 * @param n
	 *            a int.
	 * @param r
	 *            a int.
	 * @return a int.
	 */
	public static int combinations(int n, int r) {
		return factorial(n) / (factorial(n - r) * factorial(r));
	}

	/**
	 * <p>
	 * permutations.
	 * </p>
	 *
	 * @param n
	 *            Number of objects involved in arrangements.
	 * @param r
	 *            Number of Group to be form.
	 * @return Possible number of arrangements.
	 */
	public static int permutations(int n, int r) {
		return factorial(n) / factorial(n - r);
	}

	/**
	 * <p>
	 * Return floor value of the given double number.
	 * 
	 * <p>
	 * E.g.; floor(7.23) = 8
	 * 
	 * @param v
	 *            double number
	 * @return ceiling value
	 */
	public static int floor(double v) {
		return (int) Math.floor(v);
	}

	/**
	 * <p>
	 * Return ceiling value of the given double number.
	 * 
	 * <p>
	 * E.g.; ceil(7.23) = 7
	 * 
	 * @param v
	 *            double number
	 * @return ceiling value
	 */
	public static int ceil(double v) {
		return (int) Math.ceil(v);
	}

	/**
	 * Return square root of give double number.
	 * 
	 * @param v
	 *            double number
	 * @return square root
	 */
	public static double sqrt(double v) {
		return Math.sqrt(v);
	}

	/**
	 * Return v to the power of n.
	 * 
	 * @param v
	 *            integer value
	 * @param n
	 *            power of value v
	 * @return v^n
	 */
	public static long toThePower(int v, int n) {
		if (n == 0)
			return 1;
		long result = v;
		for (int i = 1; i < n; i++) {
			result = result * v;
		}
		return result;
	}

	/**
	 * Return v to the power of n.
	 * 
	 * @param v
	 *            integer value
	 * @param n
	 *            power of value v
	 * @return v^n
	 */
	public static int toThePowerInt(int v, int n) {
		if (n == 0)
			return 1;
		int result = v;
		for (int i = 1; i < n; i++) {
			result = result * v;
		}
		return result;
	}

	/**
	 * Return GCD of two numbers.
	 * 
	 * @param a number1
	 * @param b number2
	 * @return GCD
	 */
	public static long gcd(long a, long b) {
		// Everything divides 0
		if (a == 0 || b == 0)
			return 0L;

		// base case
		if (a == b)
			return a;

		// a is greater
		if (a > b)
			return gcd(a - b, b);
		return gcd(a, b - a);
	}

	/**
	 * Return GCD of N numbers.
	 * 
	 * @param arr Numbers
	 * @param n Total numbers
	 * @return GCD
	 */
	public static long gcd(long arr[], int n) {
		long result = arr[0];
		for (int i = 1; i < n; i++)
			result = gcd(arr[i], result);
		return result;
	}
	
	/**
	 * Apply XOR operation on all passed intergers.
	 * 
	 * @param x int var args
	 * @return xor applied result
	 */
	public static int xor(int... x) {
		if(x.length == 0)
			return 0;
		
		int result = x[0];
		for(int i = 1; i < x.length; i++) {
			result = result^x[i];
		}
		return result;
	}
}