/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Rahul
 *
 */
public class CircularArrayTest {

	@Test(enabled = false)
	public void check() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "implementation", "circular_array_1_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "circular_array_1_OUT.data")));
		
		int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < q; a0++){
            Assert.assertEquals(CircularArray.reverse(a, k, in.nextInt()), out.nextInt());
        }
        in.close();
        out.close();
	}
}
