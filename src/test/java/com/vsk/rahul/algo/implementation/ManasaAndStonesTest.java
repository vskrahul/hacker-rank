/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Rahul
 *
 */
public class ManasaAndStonesTest {

	@Test(enabled = false, timeOut = 4000)
	public void test() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "implementation", "manasa_and_stones_IN_1.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "manasa_and_stones_OUT_1.data")));
		
		int T = in.nextInt();

		for(int t = 0; t < T; t++) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            String actual = "";
            if(b > a)
            	actual = ManasaAndStones.stones(n - 1, a, b);
            else
            	if(a == b)
            		actual = String.format("%d", (n - 1)*a);
            	else
            		actual = ManasaAndStones.stones(n - 1, b, a);
            
            String expected = out.nextLine();
            System.out.println(String.format("Actual: %s, \nExpected: %s", actual , expected));
            Assert.assertEquals(actual, expected);
        }
		
		in.close();
		out.close();
	}
}
