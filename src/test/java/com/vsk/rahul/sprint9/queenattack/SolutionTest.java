/**
 * 
 */
package com.vsk.rahul.sprint9.queenattack;

import java.util.Scanner;
import java.util.logging.Logger;

import org.testng.annotations.Test;

import junit.framework.Assert;

/**
 * @author Rahul
 *
 */
public class SolutionTest {

	Logger logger = Logger.getLogger("SolutionTest.class");
	
	@Test(enabled = false, timeOut = 20)
	public void check() {

		Solution s = new Solution();

		Scanner in = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "queenattack", "test_case_2_in.data")));

		s.setN(in.nextInt()); // number cells in a column or row
		int k = in.nextInt(); // number of obstacles

		int rQueen = in.nextInt(); // vertical axis co-ordinate of queen
		int cQueen = in.nextInt(); // horizontal axis co-ordinate of queen

		s.setQueen(Position.instance(rQueen, cQueen));
		s.count();
		for (int a0 = 0; a0 < k; a0++) {
			int rObstacle = in.nextInt();
			int cObstacle = in.nextInt();
			s.obstacle(Position.instance(rObstacle, cObstacle));
		}
		
		in.close();
		
		in = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", 
				"queenattack",
				"test_case_2_out.data")));
		
		int expectedResult = in.nextInt();
		int actualResult = s.totalMoves();
		logger.info(String.format("Actual : %d, Expected : %d", actualResult, expectedResult));
		Assert.assertEquals(actualResult, expectedResult);
		
		in.close();
	}
}