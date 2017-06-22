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
public class JumpingOnCloudsTest {

	@Test(enabled = false)
	public void check() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "implementation", "jumping_on_clouds_1_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "jumping_on_clouds_1_OUT.data")));
		
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        JumpingOnClouds instance = new JumpingOnClouds();
        int actual = instance.jumps(c, n);
        int expected = out.nextInt();
        Assert.assertEquals(actual, expected);
        in.close();
        out.close();
	}
}