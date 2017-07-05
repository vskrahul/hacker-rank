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
public class OrganizingContainersOfBallsTest {

	@Test(enabled = false)
	public void test() {

		Scanner in = new Scanner(
				this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "organize_containers_of_balls_IN_1.data")));
		Scanner out = new Scanner(
				this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "organize_containers_of_balls_OUT_1.data")));

		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int x = in.nextInt();
					a[i] += x;
					b[j] += x;
				}
			}
			Assert.assertEquals(OrganizingContainersOfBalls.canOrganize(a, b, n), out.next());
		}
		in.close();
		out.close();
	}
}