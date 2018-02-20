/**
 * 
 */
package com.vsk.rahul.competition.woc36;

import java.util.Scanner;

import org.testng.annotations.Test;

/**
 * @author Rahul Vishvakarma
 *
 */
public class WaysToGiveACheckTest {

	@Test
	public void test() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "competition/week_36", "ways_to_give_check_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "competition/week_36"
																							, "ways_to_give_check_OUT.data")));
		
		int t = in.nextInt();
		in.nextLine();
        for(int a0 = 0; a0 < t; a0++) {
            char[][] board = new char[8][8];
            for(int board_i = 0; board_i < 8; board_i++){
            	board[board_i] = in.nextLine().toCharArray();
            }
            int result = WaysToGiveACheck.waysToGiveACheck(board);
            System.out.println(result);
        }
		
		in.close();
		out.close();
	}
}
