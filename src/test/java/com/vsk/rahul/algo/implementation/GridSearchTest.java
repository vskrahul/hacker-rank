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
public class GridSearchTest {

	@Test(enabled = true)
	public void test() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "implementation", "grid_search_IN_1.data")));
		Scanner out = new Scanner(this.getClass()
										.getResourceAsStream(String.format("/%s/%s", "implementation"
																					, "grid_search_OUT_1.data")));
		
		int T = in.nextInt();

        for(int t = 0; t < T; t++){
            
            int i1 = in.nextInt();
            int j1 = in.nextInt();
            
            int[][] grid = new int[i1][j1];
            
            for(int g = 0; g < i1; g++) {
               String s = in.next();
               int j = 0;
               for(char c : s.toCharArray()) {
               		grid[g][j] = Character.getNumericValue(c);
               		j++;
               }
            }//grid loop ends

            int i2 = in.nextInt();
            int j2 = in.nextInt();

            int[][] pattern = new int[i2][j2];
            
            for(int p=0; p < i2; p++){
               String s = in.next();
               int j = 0;
               for(char c : s.toCharArray()) {
               		pattern[p][j] = Character.getNumericValue(c);
               		j++;
               }
            }//pattern loop ends
            String actual = "";
            if(GridSearch.match(grid, pattern))
            	actual = "YES";
            else
            	actual = "NO";
            Assert.assertEquals(actual, out.next());
        }// test case loop ends
		
		in.close();
		out.close();
	}
}