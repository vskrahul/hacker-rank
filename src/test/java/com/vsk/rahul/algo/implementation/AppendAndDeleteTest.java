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
public class AppendAndDeleteTest {

	@Test(enabled = false, testName = "AppendAndDelete")
	public void check() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "implementation", "append_and_delete_1_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "append_and_delete_1_OUT.data")));
		
		String s = in.next();
		String t = in.next();
		int k = in.nextInt();
		AppendAndDelete instance = new AppendAndDelete();
		String expected = out.next();
		String actual = instance.status(s, t, instance.difference(s, t), k);
		Assert.assertEquals(expected, actual);
		
		in.close();
		out.close();
	}
}