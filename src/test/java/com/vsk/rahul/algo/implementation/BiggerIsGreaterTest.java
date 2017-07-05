/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Rahul
 *
 */
@Test(enabled = false)
public class BiggerIsGreaterTest {

	public void check() {
		Assert.assertEquals(BiggerIsGreater.biggerIsGreater("bb"), "no answer");
		Assert.assertEquals(BiggerIsGreater.biggerIsGreater("ab"), "ba");
		Assert.assertEquals(BiggerIsGreater.biggerIsGreater("hefg"), "hegf");
		Assert.assertEquals(BiggerIsGreater.biggerIsGreater("dhck"), "dhkc");
		Assert.assertEquals(BiggerIsGreater.biggerIsGreater("dkhc"), "hcdk");
	}
}