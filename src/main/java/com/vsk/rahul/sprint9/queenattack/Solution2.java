/**
 * 
 */
package com.vsk.rahul.sprint9.queenattack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rahul
 *
 */
public class Solution2 {

	private final List<Position2> queenMoves = new ArrayList<Position2>();

	private Position2 queenPosition;

	private final List<Position2> obstacles = new ArrayList<Position2>();
	
	private int N;

	public static void main(String[] args) {

		Solution2 s = new Solution2();

		Scanner in = new Scanner(System.in);

		s.N = in.nextInt(); // number cells in a column or row
		int k = in.nextInt(); // number of obstacles

		int rQueen = in.nextInt(); // vertical axis co-ordinate of queen
		int cQueen = in.nextInt(); // horizontal axis co-ordinate of queen

		s.queenPosition = Position2.instance(rQueen, cQueen);

		for (int a0 = 0; a0 < k; a0++) {
			int rObstacle = in.nextInt();
			int cObstacle = in.nextInt();
			if (rObstacle <= s.N && cObstacle <= s.N)
				s.obstacles.add(Position2.instance(rObstacle, cObstacle));
		}
		
		System.out.println(s.queenMoves().size());
		
		in.close();
	}

	List<Position2> queenMoves() {
		
		int rQ = this.queenPosition.r();
		int qQ = this.queenPosition.q();
		
		this.leftMoves(rQ, qQ)
				.rightMoves(rQ, qQ)
				.upMoves(rQ, qQ)
				.downMoves(rQ, qQ)
				.leftUpDiagonal(rQ, qQ)
				.leftDownDiagonal(rQ, qQ)
				.rightUpDiagonal(rQ, qQ)
				.rightDownDiagonal(rQ, qQ);
		return this.queenMoves;
	}

	Solution2 leftMoves(int rQ, int qQ) {
		for(int i = qQ - 1; i >= 1; i -- ) {
			Position2 p = Position2.instance(rQ, i);
			if(isObstacle(p)) {
				break;
			} else {
				this.queenMoves.add(p);
			}
		}
		return this;
    }

	Solution2 rightMoves(int rQ, int qQ) {
		for(int i = qQ + 1; i <= this.N; i ++ ) {
			Position2 p = Position2.instance(rQ, i);
			if(isObstacle(p)) {
				break;
			} else {
				this.queenMoves.add(p);
			}
		}
		return this;
	}

	Solution2 upMoves(int rQ, int qQ) {
		for(int i = rQ + 1; i <= this.N; i ++ ) {
			Position2 p = Position2.instance(i, qQ);
			if(isObstacle(p)) {
				break;
			} else {
				this.queenMoves.add(p);
			}
		}
		return this;
	}

	Solution2 downMoves(int rQ, int qQ) {
		for(int i = rQ - 1; i >=1; i -- ) {
			Position2 p = Position2.instance(i, qQ);
			if(isObstacle(p)) {
				break;
			} else {
				this.queenMoves.add(p);
			}
		}
		return this;
	}

	Solution2 leftUpDiagonal(int rQ, int qQ) {
		for(int i = rQ + 1, j = qQ - 1; i <= this.N && j >= 1; i ++, j-- ) {
			Position2 p = Position2.instance(i, j);
			if(isObstacle(p)) {
				break;
			} else {
				this.queenMoves.add(p);
			}
		}
		return this;
	}
	
	Solution2 rightUpDiagonal(int rQ, int qQ) {
		for(int i = rQ + 1, j = qQ + 1; i <= this.N && j <= this.N; i ++, j++ ) {
			Position2 p = Position2.instance(i, j);
			if(isObstacle(p)) {
				break;
			} else {
				this.queenMoves.add(p);
			}
		}
		return this;
	}
	
	Solution2 leftDownDiagonal(int rQ, int qQ) {
		for(int i = rQ - 1, j = qQ - 1; i >= 1 && j >= 1; i--, j--) {
			Position2 p = Position2.instance(i, j);
			if(isObstacle(p)) {
				break;
			} else {
				this.queenMoves.add(p);
			}
		}
		return this;
	}
	
	Solution2 rightDownDiagonal(int rQ, int qQ) {
		for(int i = rQ - 1, j = qQ + 1; i >= 1 && j <= this.N; i--, j++) {
			Position2 p = Position2.instance(i, j);
			if(isObstacle(p)) {
				break;
			} else {
				this.queenMoves.add(p);
			}
		}
		return this;
	}
	
	boolean isObstacle(Position2 p) {
		boolean flag = false;
		for(Position2 obs : this.obstacles) {
			if(obs.equals(p)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}

class Position2 {

	private int r; // vertical axis

	private int q; // horizontal axis

	private Position2() {

	}

	private Position2(int r, int q) {
		this.r = r;
		this.q = q;
	}

	public static Position2 instance(int r, int q) {
        return new Position2(r, q);
    }

	public int r() {return r;}

	public int q() {return q;}

	@Override
	public boolean equals(Object o) {
		Position2 p = null;
		boolean flag = false;
		if (o instanceof Position2) {
			p = (Position2) o;
			flag = p.r == this.r && p.q == this.q;
		}
		return flag;
	}
}