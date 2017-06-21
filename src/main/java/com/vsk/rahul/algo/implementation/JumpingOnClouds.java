/**
 * 
 */
package com.vsk.rahul.algo.implementation;

/**
 * @author Rahul
 *
 */
public class JumpingOnClouds {

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