/**
 * 
 */
package com.vsk.rahul.competition.woc36;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Rahul Vishvakarma
 *
 */
public class CutAStripTest {

	@Test
	public void test() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "competition/week_36", "cut_a_strip_1_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "competition/week_36"
																							, "cut_a_strip_1_OUT.data")));
		int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] A = new int[n][m];
        for(int A_i = 0; A_i < n; A_i++) {
            for(int A_j = 0; A_j < m; A_j++) {
                A[A_i][A_j] = in.nextInt();
            }
        }
        CutAStrip strip = new CutAStrip();
        int result = strip.cutAStrip(A, k);
        Assert.assertEquals(result, out.nextInt());
		
		in.close();
		out.close();
	}
}