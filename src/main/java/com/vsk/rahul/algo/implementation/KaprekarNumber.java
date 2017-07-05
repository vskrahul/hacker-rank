/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import com.vsk.rahul.utils.Mathematics;

/**
 * <p>
 * To Find out if any positive integer is Kaprekar Number.
 * <p>
 * Any number is an n-Kaprekar if it follows below formula. 
 * Where {@code n} is number is the digits in {@code k}
 * <p>
 * <ol>
 * <li>{@code k = q + r}, And
 * <li>{@code k*k = q*(10^n) + r }
 * </ol>
 * 
 * 
 * 
 * @author Rahul
 *
 */
public class KaprekarNumber {

	private static boolean isKaprekar(long k, String sqr) {
		String kStr = Long.toString(k);
        long sqrLong = Long.parseLong(sqr);
        
		for(int i = 1; i < sqr.length(); i++) {
			
			long q = Long.valueOf(sqr.substring(0, i));
			long r = Long.valueOf(sqr.substring(i));
			
			if(q + r == k) {
				if(sqr.charAt(i) == '0') {
					if(sqrLong == (long)(q*Mathematics.toThePower(10, kStr.length()) + r))
						return true;
					else
						return false;
				}
				return true;
			}
		}
		return false;
	}
	
	public static boolean isKaprekar(long k) {
		if(k <= 0) 
			return false;
		if(k == 1)
			return true;
        long sqr = k * k;
        return isKaprekar(k, Long.toString(sqr));
    }
}
