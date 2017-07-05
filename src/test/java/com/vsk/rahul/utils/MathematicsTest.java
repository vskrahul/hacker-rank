/**
 * 
 */
package com.vsk.rahul.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test suites of {@link Mathematics}
 * 
 * @author Rahul
 *
 */
@Test(enabled = true)
public class MathematicsTest {

	public void toThePowerTest() {
		Assert.assertEquals(Mathematics.toThePower(5, 3), 125);
	}
}