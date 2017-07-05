/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.util.Iterator;
import java.util.List;

import com.vsk.rahul.utils.StringUtils;

/**
 * <p>
 * Hacker rank problem.
 * This class has only one method, where the problem is described : {@link BiggerIsGreaterTest#biggerIsGreater(String)}.
 * 
 * @author Rahul
 *
 */
public class BiggerIsGreater {

	/**
	 * <p>
	 * Found out a String lexicographically bigger than given String.
	 * In case of multiple possible answers print the smallest one.
	 * 
	 * @param s Given String
	 * @return Lexicographically smallest String among bigger one. 
	 */
	public static String biggerIsGreater(String s) {
		if(allSame(s)) {
			return "no answer";
		}
		List<String> perm = StringUtils.permutation(s);
		Iterator<String> itr = perm.stream().sorted().iterator();
		
		boolean flag = false;
		String str = "";
		while(itr.hasNext()) {
			str = itr.next();
			if(flag) {
				break;
			}
			if(s.equals(str)) {
				flag = true;
			}
		}
		
		return str;
	}
	
	private static boolean allSame(String s) {
		char[] cArr = s.toCharArray();
		for(int i = 1; i < cArr.length; i++) {
			if(cArr[0] == cArr[i]) {
				return true;
			}
		}
		return false;
	}
}