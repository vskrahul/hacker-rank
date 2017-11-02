/**
 * 
 */
package com.vsk.rahul.functional.adhoc;

import com.vsk.rahul.utils.Mathematics;

/**
 * @author Rahul
 *
 */
public class JumpingBunnies {

	public long meet(long[] jumps) {
		
		long m = 1L;
		
		for(long l : jumps) {
			m *= l;
		}
		
		return m/Mathematics.gcd(jumps, jumps.length);
	}
}
