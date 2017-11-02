/**
 * 
 */
package com.vsk.rahul.ds.array;

import java.util.Arrays;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Array Rotation Test
 * 
 * @author Rahul
 *
 */
public class ArrayRotationTest {

	@Test(testName = "Array Rotation Test")
	public void check() {
		
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "data_structure/array", "left_rotation_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(
									String.format("/%s/%s", "data_structure/array", "left_rotation_OUT.data")));
		
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        Reporter.log(String.format("Before rotation %s", Arrays.toString(a)), true);
        ArrayRotation.rotation(a, d, true);
        Reporter.log(String.format("After %d left rotation : %s", d, Arrays.toString(a)), true);
        
        for (int i = 0; i < a.length; i++) {
            Assert.assertEquals(out.nextInt(), a[i]);
        }


        in.close();
        out.close();
	}
}
