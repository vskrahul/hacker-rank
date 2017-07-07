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
public class ChocolatesFeastTest {

	@Test(enabled = false)
	public void test() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "implementation", "chocolates_feast_1_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "chocolates_feast_1_OUT.data")));
		
		int t = in.nextInt();

		for(int tIdx = 0; tIdx < t; tIdx++) {
			int n = in.nextInt();
			int c = in.nextInt();
			int m = in.nextInt();
			int actual = ChocolatesFeast.chocolates(n, c, m);
			int expected = out.nextInt();
			System.out.println(String.format("Actual: %d, Expected: %d", actual, expected));
			Assert.assertEquals(actual, expected);
		}
		in.close();
		out.close();
	}
}
