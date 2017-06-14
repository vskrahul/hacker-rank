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
public class Solution {

	private Integer N;
	
	private Integer leftUpDiagonal;
	
	private Integer rightUpDiagonal;
	
	private Integer leftDownDiagonal;
	
	private Integer rightDownDiagonal;
	
	private Integer left;
	
	private Integer right;
	
	private Integer up;
	
	private Integer down;
	
	private Position queen = null;
	
	private final List<Position> obstacles = new ArrayList<Position>();
	
	public static void main(String[] args) {

		Solution s = new Solution();

		Scanner in = new Scanner(System.in);

		s.N = in.nextInt(); // number of cells in a column or row
		int k = in.nextInt(); // number of obstacles

		int rQueen = in.nextInt(); // vertical axis co-ordinate of queen
		int cQueen = in.nextInt(); // horizontal axis co-ordinate of queen

		s.queen = Position.instance(rQueen, cQueen);
		s.count();

		for (int a0 = 0; a0 < k; a0++) {
			int rObstacle = in.nextInt();
			int cObstacle = in.nextInt();
			if (rObstacle <= s.N && cObstacle <= s.N)
				s.obstacle(Position.instance(rObstacle, cObstacle));
		}
		
		System.out.println(s.totalMoves());
		
		in.close();
	}
	
	/**
	 * Sum and return all the number of moves of queen.
	 * 
	 * @return int
	 */
	int totalMoves() {
		return this.left +
				this.leftUpDiagonal +
				this.up +
				this.rightUpDiagonal +
				this.right +
				this.rightDownDiagonal +
				this.down +
				this.leftDownDiagonal;
	}
	
	/**
	 * Count total number of possible moves of queen
	 * 
	 * @return {@link Solution}
	 */
	Solution count() {
		this.leftUpDiagonal = N - this.queen.r() < this.queen.q() -1 ? N - this.queen.r() : this.queen.q() - 1;
		this.leftDownDiagonal = this.queen.r() < this.queen.q() ? this.queen.r() - 1 : this.queen.q() - 1;
		this.rightUpDiagonal = N - this.queen.r() < N - this.queen.q() ? N - this.queen.r() : N - this.queen.q();
		this.rightDownDiagonal = this.queen.r() - 1 < N - this.queen.q() ? this.queen.r() - 1 : N - this.queen.q();
		this.left = this.queen.q() - 1;
		this.right = N - this.queen.q();
		this.up = N - this.queen.r();
		this.down = this.queen.r() - 1;
		return this;
	}
	
	private int difference(int i, int j) {
		if(i >= j) {
			return i - j;
		} else {
			return j - i;
		}
	}
	
	/**
	 * Update number of queen moves with respect the list of obstacles,
	 * Given by the program executor :)
	 * 
	 * @return {@link Solution}
	 */
	Solution obstacle(Position obstacle) {
		
		//This obstacle is on diagonals
		if(difference(obstacle.r(), queen.r()) == difference(obstacle.q(), queen.q())) {
			
			//Obstacle is Up diagonals
			if(obstacle.r() > queen.r()) {
				
				// Obstacle is on right UP diagonal
				if(obstacle.q() > queen.q()) {
					rightup(obstacle.q() - queen.q() - 1);
				} else {
					// Obstacle is on left UP diagonal
					leftup(queen.q() - obstacle.q() - 1);
				}
			} else {
				//Obstacle is Down diagonals
				
				//left down
				if(obstacle.q() < queen.q()) {
					leftdown(queen.q() - obstacle.q() - 1);
				} else {
					//right down diagonal
					rightdown(obstacle.q() - queen.q() - 1);
				}
			}
		} else {
			// horizontal axis
			if(obstacle.r() == queen.r()) {
				
				if(obstacle.q() < queen.q()) {
					left(queen.q() - obstacle.q() - 1);
				} else {
					right(obstacle.q() - queen.q() - 1);
				}
			} else {
				if(obstacle.q() == queen.q()) {
                    //vertical axis
                    if(obstacle.r() < queen.r()) {
                        down(queen.r() - obstacle.r() - 1);
                    } else {
                        up(obstacle.r() - queen.r() - 1);
                    }
                }
			}
		}
		return this;
	}
	
	void left(int v) {
		if(v < this.left) {
			this.left = v;
		}
	}
	
	void right(int v) {
		if(v < this.right) {
			this.right = v;
		}
	}
	
	void up(int v) {
		if(v < this.up) {
			this.up = v;
		}
	}
	
	void down(int v) {
		if(v < this.down) {
			this.down = v;
		}
	}
	
	void leftup(int v) {
		if(v < this.leftUpDiagonal) {
			this.leftUpDiagonal = v;
		}
	}
	
	void rightup(int v) {
		if(v < this.rightUpDiagonal) {
			this.rightUpDiagonal = v;
		}
	}
	
	void leftdown(int v) {
		if(v < this.leftDownDiagonal) {
			this.leftDownDiagonal = v;
		}
	}
	
	void rightdown(int v) {
		if(v < this.rightDownDiagonal) {
			this.rightDownDiagonal = v;
		}
	}

	public Integer getN() {
		return N;
	}

	public void setN(Integer n) {
		N = n;
	}

	public Position getQueen() {
		return queen;
	}

	public void setQueen(Position queen) {
		this.queen = queen;
	}

	public void add_obstacles(Position p) {
		if(p.q() <= this.N && p.r() < this.N)
			obstacles.add(p);
	}
}

class Position {

	private int r; // vertical axis

	private int q; // horizontal axis

	private Position() {

	}

	private Position(int r, int q) {
		this.r = r;
		this.q = q;
	}

	public static Position instance(int r, int q) {
        return new Position(r, q);
    }

	public int r() {return r;}

	public int q() {return q;}

	@Override
	public boolean equals(Object o) {
		Position p = null;
		boolean flag = false;
		if (o instanceof Position) {
			p = (Position) o;
			flag = p.r == this.r && p.q == this.q;
		}
		return flag;
	}
}