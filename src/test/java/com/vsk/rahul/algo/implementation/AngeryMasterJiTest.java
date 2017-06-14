/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.util.Scanner;

import org.testng.annotations.Test;

import junit.framework.Assert;

/**
 * @author Rahul
 *
 */
public class AngeryMasterJiTest {

	@Test(enabled = true)
	public void check() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "implementation", "angry_master_ji_1_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "angry_master_ji_1_OUT.data")));
		
		int T = in.nextInt();
		for(int i = 0; i < T; i++) {
			String actual = AngryMasterJi.is_class_cancelled(in.nextInt(), in.nextInt(), in);
			String expected = out.next();
			Assert.assertEquals(expected, actual);
		}
		in.close();
		out.close();
	}
}
