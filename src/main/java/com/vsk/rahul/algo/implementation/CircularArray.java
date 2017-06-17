/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.util.Scanner;

/**
 * @author Rahul
 *
 */
public class CircularArray {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < q; a0++){
            System.out.println(reverse(a, k, in.nextInt()));
        }
        in.close();
    }
	
	/**
	 * <p>
	 * First find out k%a.length; which are the actual shifts happened
	 * on given array.</p>
	 * <p>But we are not modifying the array so have to shift back
	 * by k%a.length; from given index i.</p>
	 * 
	 * 
	 * @param a Array
	 * @param k Number of circular rotations
	 * @param i Index to find out current value after circular rotation
	 * @return value at given index i
	 */
	public static int reverse(int[] a, int k, int i) {
		int r =  k%a.length;
        if(i >= r)
        	return a[i-r];
        else
        	return a[a.length + i - r];
	}
}
