/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.util.Scanner;

/**
 * <p>AppendAndDelete class.</p>
 *
 * @author Rahul
 * @version $Id: $Id
 */
public class AppendAndDelete {

	/**
	 * <p>
	 * Return the matching length between String s and t.
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

	/**
	 * <p>status.</p>
	 *
	 * @param s a {@link java.lang.String} object.
	 * @param t a {@link java.lang.String} object.
	 * @param match a int.
	 * @param k a int.
	 * @return a {@link java.lang.String} object.
	 */
	public String status(String s, String t, int match, int k) {
		// if matching length is equal to String s length.
		if(s.length() == match) {
			// if matching length is equal to String t length, it means s & t are matching completely.
            if(t.length() == match)
                return "Yes";
            
	    	// If t is not matching with by one character only
			// then number of operations should be of evenly divisible by 3.
			if(t.length() - match == 1)
			    return  k%3 == 0 ? "Yes" : "No";
			
			return  k%(t.length() - match) == 0 ? "Yes" : "No";
        }
        return s.length() - match + t.length() - match <= k ? "Yes" : "No";
    }

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String t = in.next();
		int k = in.nextInt();
		AppendAndDelete instance = new AppendAndDelete();
		System.out.print(instance.status(s, t, instance.difference(s, t), k));
		in.close();
	}
}
