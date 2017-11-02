/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.util.Scanner;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * @author Rahul
 *
 */
public class BomberManTest {

	@Test(enabled = true)
	public void test() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "implementation", "bomber_man_IN_1.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "bomber_man_OUT_1.data")));
		
		int row = in.nextInt();
		int column = in.nextInt();
		long time = in.nextLong();
		int[][] plot = plot(row, column, in);
		int[][] actual = BomberMan.process(plot, time);
		assertEqual(actual, out);
		in.close();
		out.close();
	}
	
	void assertEqual(int[][] actual, Scanner out) {
		for(int i = 0; i < actual.length; i++) {
			String s = out.next();
			int j = 0;
			for(char c : s.toCharArray()) {
				Assert.assertEquals(actual[i][j], c);
				j++;
			}
		}
	}
	
	int[][] plot(int R, int C, Scanner in) {
		int[][] plot = new int[R][C];
		for(int i = 0; i < R; i++) {
			String s = in.next();
			int j = 0;
			for(char c : s.toCharArray()) {
				plot[i][j] = c;
				j++;
			}
		}
		return plot;
	}
}