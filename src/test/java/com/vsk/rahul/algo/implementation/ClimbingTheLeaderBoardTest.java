/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.util.Scanner;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vsk.rahul.algo.implementation.ClimbingTheLeaderBoard.Player;

/**
 * @author Rahul
 *
 */
public class ClimbingTheLeaderBoardTest {

	static Logger logger = Logger.getLogger(ClimbingTheLeaderBoardTest.class.getName());

	@Test(enabled = false)
	public void check() {
		Scanner in = new Scanner(this.getClass()
							.getResourceAsStream(String.format("/%s/%s", "implementation", "test_case_2_in.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "test_case_2_out.data")));
		int n = in.nextInt();// number of players before Alice.
		ClimbingTheLeaderBoard.scores = new Player[n + 1];
		ClimbingTheLeaderBoard.currentIndex = n;
		ClimbingTheLeaderBoard.scores[n] = new Player();

		for (int i = 0; i < n; i++) {
			Player player = new Player();
			player.score = in.nextInt();
			if (i == 0) {
				player.rank = 1;
				ClimbingTheLeaderBoard.scores[i] = player;
				continue;
			}
			if (player.score.equals(ClimbingTheLeaderBoard.scores[i - 1].score)) {
				player.rank = ClimbingTheLeaderBoard.scores[i - 1].rank;
			} else {
				player.rank = ClimbingTheLeaderBoard.scores[i - 1].rank + 1;
			}
			ClimbingTheLeaderBoard.scores[i] = player; 
		} // for loop ends here..

		int m = in.nextInt();
		for (int j = 0; j < m; j++) {
			if(j == 150) {
				System.out.print("Break....");
			}
			int actual = ClimbingTheLeaderBoard.rank(in.nextInt());
			int expected = out.nextInt();
			logger.info(String.format("Actual: %d, Expected: %d", actual, expected));
			Assert.assertEquals(actual, expected);
		}
		in.close();
		out.close();
	}

}