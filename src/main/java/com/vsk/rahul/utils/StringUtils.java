/**
 * 
 */
package com.vsk.rahul.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p> This class contains String utility methods.
 * 
 * @author Rahul
 */
public class StringUtils {

	/**
	 * <p>
	 * Convert {@link String} array into a single string separated by given separator.
	 * 
	 * @param args array of {@link String}
	 * @param separator Separator to separate the array elements
	 * @return {@link String}
	 */
	public static String toString(String[] args, String separator) {
		StringBuffer sb = new StringBuffer();
		
		for(String s : args) {
			sb.append(s).append(separator);
		}
		
		return sb.toString().trim();
	}
	
	/**
	 * <p>
	 * Return {@link List} of {@link String} containing all possible arrangements
	 * made by characters in the given String.
	 * 
	 * @param str String
	 * @return {@link List} of all arrangements
	 */
	public static List<String> permutation(String str) {
		List<String> arrangements = new ArrayList<>();
	    permutation("", str, arrangements);
	    return arrangements;
	}

	/**
	 * <p>
	 * Internal iterative method called by {@link #permutation(String)}
	 * 
	 * @param prefix Prefix
	 * @param str String
	 * @param arrangements Arrangements
	 */
	private static void permutation(String prefix, String str, List<String> arrangements) {
	    int n = str.length();
	    if (n == 0) arrangements.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), arrangements);
	    }
	}
	
	/**
	 * <p>
	 * Returns the lexicographical value of the given {@link String} value.
	 * 
	 * <p>
	 * This is not general implementation to calculate lexicographical value.
	 * This method is designed to sort all possible arrangements of a {@link String}
	 * lexicographically.
	 * 
	 * @param s Non null {@link String} value
	 * @return lexicographical value
	 * @throws NullPointerException If {@code s} is {@code null}
	 */
	public static int lexicographicalValue(String s) {
		
		Objects.requireNonNull(s);
		
		int lexical = 0;
		int i = 0;
		for(char c : s.toCharArray()) {
			lexical += c*(s.length() - i);
			i++;
		}
		return lexical;
	}
	
	/**
	 * Return true if given String is Palindrome otherwise return false.
	 * 
	 * @param s String
	 * @return is given String Palindrome?
	 */
	public static boolean isPalindrome(String s) {
		char[] arr = s.toCharArray();
		int N = s.length();
		for(int i = 0; i < N/2; i++) {
            if(arr[i] == arr[N - i - 1])
                continue;
            return false;
        }
		return true;
	}
	
	public static int[] ascii(String s) {
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c - 'a'] = c; 
        }
        return arr;
    }
}