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
public class SaveThePrisonerTest {

	@Test(enabled = false)
	public void check() {
		
		Scanner in = new Scanner(this.getClass()
									.getResourceAsStream
									(String.format("/%s/%s", "implementation", "save_the_prisoner_IN_1.data"))
					);
		Scanner out = new Scanner(
						this.getClass()
						.getResourceAsStream
							(String.format("/%s/%s", "implementation", "save_the_prisoner_OUT_1.data")
							)
						);
		int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            int actual = SaveThePrisoner.saveThePrisoner(n, m, s);
            Assert.assertEquals(out.nextInt(), actual);
        }
        
        in.close();
        out.close();
	}
}
