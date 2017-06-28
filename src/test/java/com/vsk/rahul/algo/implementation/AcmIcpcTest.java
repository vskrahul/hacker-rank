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
public class AcmIcpcTest {

	@Test(enabled = false)
	public void check() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "implementation", "organize_containers_of_balls_IN_1.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "organize_containers_of_balls_OUT_1.data")));
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		int subjects[][] = new int[N][M];

        for(int i = 0; i < N; i++) {
        	String s = in.next();
        	int j = 0;
    		for(char c : s.toCharArray()) {
    			subjects[i][j] = Character.getNumericValue(c);
    			j++;
    		}
        }
		
        int result[] = AcmIcpc.maxPossibleScore(subjects, M, N);
        Assert.assertEquals(result[0], out.nextInt());
        Assert.assertEquals(result[1], out.nextInt());
		in.close();
		out.close();
	}
}