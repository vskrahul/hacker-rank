/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This is Kaprekar Test class
 * 
 * @author Rahul
 *
 */
@Test(enabled = false)
public class KaprekarNumberTest {

	public void test() {
		for(int t = 1; t <= 2; t++) {
			String inFile = String.format("kaprekar_number_%d_IN.data", t);
			String outFile = String.format("kaprekar_number_%d_OUT.data", t);
			Scanner in = new Scanner(this.getClass()
					.getResourceAsStream(String.format("/%s/%s", "implementation", inFile)));
			Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", outFile)));
			int i1 = in.nextInt();
			int i2 = in.nextInt();
			int count = 0;
			System.out.println(String.format("Executing Kaprekar Test Case : %d ", t));
			for(int idx = i1; idx <= i2; idx++) {
				if(KaprekarNumber.isKaprekar(idx)) {
					count++;
					int expected = out.nextInt();
					System.out.println(String.format("Actual : %d, Expected: %d", idx, expected));
					Assert.assertEquals(idx, expected);
				}
			}
			if(count == 0) {
				System.out.print("INVALID RANGE");
				Assert.assertEquals("INVALID RANGE", out.next());
			}
			in.close();
			out.close();
		}
	}
}
