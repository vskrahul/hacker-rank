/**
 * 
 */
package com.vsk.rahul.ds.array;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @author Rahul
 *
 */
public class ArrayManipulation {

	private static long[] array = null;
	
	private static long MAX = Long.MIN_VALUE;
	
	@Test(testName = "ArrayManipulation")
	public void check() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "data_structure/array", "array_manipulation_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(
									String.format("/%s/%s", "data_structure/array", "array_manipulation_OUT.data")));
		
		int n = in.nextInt();
	    long m = in.nextLong();
	    
	    array = new long[n+1];
	    
	    for(long a0 = 0; a0 < m; a0++) {
	    	int a = in.nextInt();
	    	int b = in.nextInt();
	        
	        long k = in.nextLong();
	        
	        array[a] += k;
	        
	        if(b + 1 <= n) {
	        	
	        }
	        
	    }
	    
	    for(int a1 = 1; a1 < n + 1; a1++) {
	    	if(MAX < array[a1]) {
	    		MAX = array[a1];
	    	}
	    }
	    Reporter.log(String.format("MAX = %d", MAX), true);
	    Assert.assertEquals(out.nextLong(), MAX);
		
		in.close();
		out.close();
	}
}