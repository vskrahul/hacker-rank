/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.math.BigInteger;

/**
 * @author Rahul
 *
 */
public class ExtraLongFactorial {

	
	static BigInteger factorial(BigInteger i) {
		if(BigInteger.ONE.equals(i)) {
			return BigInteger.valueOf(1L);
		}
		return i.multiply(factorial(i.subtract(BigInteger.valueOf(1L))));
	}
	
	public static void main(String[] args) {
        System.out.print(factorial(BigInteger.valueOf(25L)));
    }
}