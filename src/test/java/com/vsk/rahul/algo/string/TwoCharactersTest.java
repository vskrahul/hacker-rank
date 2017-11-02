/**
 * 
 */
package com.vsk.rahul.algo.string;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Rahul
 *
 */
public class TwoCharactersTest {

	@Test(enabled = false)
	public void test() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "string", "two_characters_IN_1.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "string", "two_characters_OUT_1.data")));
		
		in.nextInt();
		String s = in.next();
		
		int actual = TwoCharacters.longestAltString(s);
		int expected = out.nextInt();
		
		Assert.assertEquals(actual, expected);
		
		in.close();
		out.close();
	}
}