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
public class AbsolutePermutationTest {

	@Test(enabled = false)
	public void test() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "implementation", "absolute_permuation_IN_1.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "absolute_permuation_OUT_1.data")));
        int T = in.nextInt();
        
        for(int t = 0; t < T; t++){
            int n = in.nextInt();
            int k = in.nextInt();
            
            String actual = AbsolutePermutation.absolutePermutation(n, k);
            String expected = out.nextLine();
            Assert.assertEquals(actual, expected);
        }
        in.close();
        out.close();
	}
}
