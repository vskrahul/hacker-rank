/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import com.vsk.rahul.utils.StringUtils;

/**
 * Encrypt a string as following approach.
 * 
 * <ol>
 * <li> Remove all spaces from the {@link String}</li>
 * <li> L is the length of without space {@link String}</li>
 * <li> split the {@link String} in rows and columns</li>
 * <li> FLOOR(sqrt(L)) &lt;= rows &gt;= CEIL(sqrt(L))</li>
 * <li> rows * columns &gt;= L</li>
 * <li> Print the String column wise separated with single space</li>
 * </ol>
 * @author Rahul
 *
 */
public class Encryption {

	/**
	 * <p>
	 * Return rows and column combinations value which can 
	 * contains all the {@link String} once wrapped.
	 * 
	 * @param L Length of the {@link String}
	 * @return combination of rows and columns which occupy minimum area
	 */
	public static int[] rowsAndColumns(int L) {
		
		double sqrt = Math.sqrt(L);
		int floorV = (int)Math.floor(sqrt);
		int ceilV = (int)Math.ceil(sqrt);
		
		if(floorV * floorV >= L) {
			return new int[]{floorV,  floorV};
		} else {
			if(floorV * ceilV >= L) {
				return new int[]{floorV,  ceilV};
			} else {
				if(ceilV * ceilV >= L) {
					return new int[]{ceilV,  ceilV};
				}
			}
		}
		return new int[]{-1, -1};
	}
	
	public static String encrypt(String input) {
		
		input = input.replaceAll("\\s+","");
		int rowsAndColumn[] = rowsAndColumns(input.length());
		String[] result = new String[rowsAndColumn[1]];
		
		for(int i = 0; i < rowsAndColumn[1]; i++) {
			result[i] = pick(i, rowsAndColumn[1], input);
		}
		
		return StringUtils.toString(result, " ");
	}
	
	/**
	 * <p>
	 * Return a String of characters picked up from the given 
	 * String from a given factor of index.
	 * 
	 * 
	 * @param start Start Index
	 * @param factor Factor of Index
	 * @param input Given String
	 * @return {@link String}
	 */
	public static String pick(int start, int factor, String input) {
		StringBuffer sb = new StringBuffer();
		for(int i = start; i < input.length(); i = i + factor) {
			sb.append(input.charAt(i));
		}
		return sb.toString();
	}
}