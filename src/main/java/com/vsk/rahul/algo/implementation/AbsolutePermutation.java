/**
 * 
 */
package com.vsk.rahul.algo.implementation;

/**
 * @author Rahul
 *
 */
public class AbsolutePermutation {

	public static String absolutePermutation(int n, int k) {
		StringBuffer sb = new StringBuffer();
		if (k >= n) {
			return "-1";
		}
		if (k == 0) {
			for (int a = 1; a <= n; a++)
				sb.append(String.format("%d ", a));
			return sb.toString().trim();
		}

		int temp = k;
		
		if((n%(2*k)) == 0)
			for (int b = 1; b <= n; b++) {
				sb.append(String.format("%d ", b + temp));
				if(b%k == 0)
					temp = temp * -1;
			}
		else
			return "-1";
		return sb.toString().trim();
	}
}
