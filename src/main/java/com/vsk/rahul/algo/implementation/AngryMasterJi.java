/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.util.Scanner;

/**
 * <p>AngryMasterJi class.</p>
 *
 * @author Rahul
 * @version $Id: $Id
 */
public class AngryMasterJi {

	/**
	 * <p>is_class_cancelled.</p>
	 *
	 * @param N a int.
	 * @param K a int.
	 * @param in a {@link java.util.Scanner} object.
	 * @return a {@link java.lang.String} object.
	 */
	public static String is_class_cancelled(int N, int K, Scanner in) {
		int student = 0;
		for(int i = 0; i < N; i++) {
			int t = in.nextInt();
			if(t <= 0)
				student += 1;
			/**
			 * TIPS: Don't break the loop. If do consume all the values for current test case.
			 * Otherwise code will be break out.
			 * And, it will be hard to find out the cause.
			 * Because logic will seems to be correct.
			 */
		}
		return student >= K ? "NO" : "YES";
	}
}
