/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.math.BigInteger;

/**
 * <p>ExtraLongFactorial class.</p>
 *
 * @author Rahul
 * @version $Id: $Id
 */
public class ExtraLongFactorial {

	
	static BigInteger factorial(BigInteger i) {
		if(BigInteger.ONE.equals(i)) {
			return BigInteger.valueOf(1L);
		}
		return i.multiply(factorial(i.subtract(BigInteger.valueOf(1L))));
	}
	
	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
        System.out.print(factorial(BigInteger.valueOf(25L)));
    }
}
