/**
 * 
 */
package com.vsk.rahul.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * <p>
 * Unit test cases to test {@link StringUtils} utility methods.
 * 
 * @author Rahul
 *
 */
@Test(enabled = true)
public class StringUtilsTest {
	
	/**
	 * Unit test case to test {@link StringUtils#toString(String[], String)} method.
	 */
	public void toStringTest() {
		String[] arr = new String[]{ "Rahul"
									,"Vsk"
									,"is"
									,"a"
									,"good"
									,"programmer"
		};
		Reporter.log(String.format("StringUtils.toString utit test for : %s", Arrays.toString(arr)), true);
		Assert.assertEquals(StringUtils.toString(arr, " "), "Rahul Vsk is a good programmer");
	}
	
	public void permutations() {
		String s = "abc";
		
		Reporter.log(String.format("StringUtils.permutations utit test for : %s", s), true);
		
		Assert.assertEquals(Mathematics.permutations(s.length(), 1), s.length());
		
		List<String> list = StringUtils.permutation(s);
		List<String> expected = new ArrayList<>();
		
		expected.add("abc");
		expected.add("acb");
		expected.add("bac");
		expected.add("bca");
		expected.add("cab");
		expected.add("cba");
		Assert.assertEquals(list, expected);
	}
	
	public void lexicographicalValueTest() {
		Assert.assertEquals(StringUtils.lexicographicalValue("abc"), 586);
	}

}