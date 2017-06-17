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
            System.out.println(reverse(a, n, k, in.nextInt()));
        }
        in.close();
    }
	
	public static int reverse(int[] a, int n, int k, int i) {
		int r =  k%n;
        if(i >= r)
        	return a[i-r];
        else
        	return a[a.length + i - r];
	}
}
