/**
 * 
 */
package com.vsk.rahul.competition.woc36;

import java.util.Scanner;

import org.testng.annotations.Test;

import junit.framework.Assert;

/**
 * @author Rahul Vishvakarma
 *
 */
public class RaceAgainstTimeTest {

	@Test
	public void test() {
		
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "competition/week_36", "race_against_time_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "competition/week_36"
																							, "race_against_time_OUT.data")));
		int n = in.nextInt();
        int mason_height = in.nextInt();
        int[] heights = new int[n];
        heights[0] = mason_height;
        for(int heights_i = 1; heights_i < n; heights_i++){
            heights[heights_i] = in.nextInt();
        }
        int[] prices = new int[n];
        prices[0] = 0;
        for(int prices_i = 1; prices_i < n; prices_i++){
            prices[prices_i] = in.nextInt();
        }
        
        RaceAgainstTime race = RaceAgainstTime.instance();
        
        race.mason_height = mason_height;
        race.n = n;
        race.heights = heights;
        race.prices = prices;
        
        int result = race.time();
        Assert.assertEquals(out.nextInt(), result);
		
		in.close();
		out.close();
	}
}