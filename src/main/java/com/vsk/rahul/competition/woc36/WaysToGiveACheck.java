/**
 * 
 */
package com.vsk.rahul.competition.woc36;

import java.util.Scanner;

/**
 * @author Rahul Vishvakarma
 *
 */
public class WaysToGiveACheck {

	static int waysToGiveACheck(char[][] board) {
        int ways = 0;
        
        int pawn_i = 0, pawn_j = 0;
        int king_i = 0, king_j = 0;
        
        boolean kingFound = false;
        boolean pawnFound = false;
        
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[i].length; j++) {
        		
        		if(board[i][j] == 'k') {
        			king_i = i;
        			king_j = j;
        			kingFound = true;
        		} else {
        			if(board[i][j] == 'P') {
        				if(i > 0 && board[i - 1][j] == '#') {
        					pawn_i = i - 1;
        					pawn_j = j;
        					pawnFound = true;
        				}
        			}
        		}
        		if(kingFound && pawnFound)
        			break;
        	}
        	if(kingFound && pawnFound)
    			break;
        }
        
        if(knight(pawn_i, pawn_j, king_i, king_j))
        	ways++;
        if(rook(pawn_i, pawn_j, king_i, king_j))
        	ways++;
        if(bishop(pawn_i, pawn_j, king_i, king_j))
        	ways++;
        if(queen(pawn_i, pawn_j, king_i, king_j))
        	ways++;
        
        return ways;
    }
	
	static boolean knight(int pawn_i, int pawn_j, int king_i, int king_j) {
		return (king_i == 1 && (king_j == pawn_j - 2 || king_j == pawn_j + 2)) ||
				(king_i == 2 && (king_j == pawn_j - 1 || king_j == pawn_j + 1));
	}
	
	static boolean rook(int pawn_i, int pawn_j, int king_i, int king_j) {
		return king_i == pawn_j || king_j == pawn_j;
	}
	
	static boolean bishop(int pawn_i, int pawn_j, int king_i, int king_j) {
		return king_j < pawn_j 
					? pawn_i + pawn_j == king_i + king_j
					: modulus(pawn_i, pawn_j) == modulus(king_i, king_j);
	}
	
	static boolean queen(int pawn_i, int pawn_j, int king_i, int king_j) {
		return bishop(pawn_i, pawn_j, king_i, king_j)
				|| rook(pawn_i, pawn_j, king_i, king_j);
	}
	
	static int modulus(int i, int j) {
		return i > j ? i - j : j - i;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            char[][] board = new char[8][8];
            for(int board_i = 0; board_i < 8; board_i++) {
            	String nl = in.nextLine();
            	board[board_i] = nl.toCharArray();
            }
            int result = waysToGiveACheck(board);
            System.out.println(result);
        }
        in.close();
    }
}
