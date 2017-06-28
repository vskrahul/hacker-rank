/**
 * 
 */
package com.vsk.rahul.algo.implementation;

/**
 * <p>JumpingOnClouds class.</p>
 *
 * @author Rahul
 * @version $Id: $Id
 */
public class JumpingOnClouds {

	/**
	 * <p>jumps.</p>
	 *
	 * @param c an array of int.
	 * @param clouds a int.
	 * @return a int.
	 */
	public int jumps(int c[], int clouds) {
		int jump = 0;
		for (int i = 0; i < clouds;) {
			if (i + 2 < clouds) {
				if (c[i + 2] == 0) {
					jump = jump + 1;
					i = i + 2;
				} else {
					if (c[i + 1] == 0) {
						jump = jump + 1;
						i = i + 1;
					} else {
						return -1;
					}
				}
			} else {
				if (i + 1 < clouds) {
					if (c[i + 1] == 0) {
						jump = jump + 1;
						i = i + 1;
					} else {
						return -1;
					}
				} else {
					i = i + 1;
				}
			}
		}
		return jump;
	}

}
