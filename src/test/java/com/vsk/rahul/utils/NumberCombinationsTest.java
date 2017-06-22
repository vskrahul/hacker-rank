/**
 * 
 */
package com.vsk.rahul.utils;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Rahul
 *
 */
public class NumberCombinationsTest {

	@Test(enabled = false)
	public void check() {
		int arr[] = new int[]{1, 2, 3, 4};
		int set = 2;
		
		NumberCombinations[] result = NumberCombinations.combinations(arr, set);
		Assert.assertEquals(Arrays.toString(result), "[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]");
	}
}