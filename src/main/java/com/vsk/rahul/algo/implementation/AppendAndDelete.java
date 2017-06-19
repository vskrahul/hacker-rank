/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.util.Scanner;

/**
 * @author Rahul
 *
 */
public class AppendAndDelete {

	/**
	 * Return the matching length between String s & t.
	 * It compares from index 0 till no match found.
	 * 
	 * @param s String 1
	 * @param t String 2
	 * @return {@link int} return the matching length
	 */
	public int difference(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int i = 0;
        
        for(;i < sarr.length && i < tarr.length; i++) {
            if(sarr[i] != tarr[i]) break;
        }
        return i;
	}

	public String status(String s, String t, int match, int k) {
		// if matching length is equal to String s length.
		if(s.length() == match) {
			// if matching length is equal to String t length, it means s & t are matching completely.
            if(t.length() == match) {
                return "Yes";
            } else {
            	// If t is not matching with by one character only
            	// then number of operations should be of evenly divisible by 3.
                if(t.length() - match == 1)
                    return  k%3 == 0 ? "Yes" : "No";
                else
                    return  k%(t.length() - match) == 0 ? "Yes" : "No";
            }
        }
        return s.length() - match + t.length() - match <= k ? "Yes" : "No";
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String t = in.next();
		int k = in.nextInt();
		AppendAndDelete instance = new AppendAndDelete();
		System.out.print(instance.status(s, t, instance.difference(s, t), k));
	}
}