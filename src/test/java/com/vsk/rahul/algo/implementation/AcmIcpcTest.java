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

	@Test(enabled = true)
	public void check() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "implementation", "acpc_icmp_1_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "acpc_icmp_1_OUT.data"))); 
		
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
		
        AcmIcpc instance = new AcmIcpc();
        int result[] = instance.maxPossibleScore(subjects, M, N);
        Assert.assertEquals(result[0], out.nextInt());
        Assert.assertEquals(result[1], out.nextInt());
		in.close();
		out.close();
	}
}