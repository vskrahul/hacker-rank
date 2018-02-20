/**
 * 
 */
package com.vsk.rahul.algo.string.dp;

import java.util.Arrays;

/**
 * @author Rahul Vishvakarma
 *
 */
public class Equal {

	static int equal(int[] arr) {
		
		int count = 0;
		int v = 0;
        
		Arrays.sort(arr);
        
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] + v - arr[i] != 0) {
            	
                int diff = arr[i + 1] + v - arr[i];
                arr[i + 1]  = arr[i + 1] + v;
                
                count += (int)diff / 5 + diff % 5 / 2 + diff % 5 % 2 / 1;
                v += diff;
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{1, 5, 5};
		
		System.out.println(equal(arr));
		
	}
}