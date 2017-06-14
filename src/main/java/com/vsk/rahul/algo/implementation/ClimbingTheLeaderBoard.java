/**
 * 
 */
package com.vsk.rahul.algo.implementation;

/**
 * @author Rahul
 *
 */
public class ClimbingTheLeaderBoard {

	public static int currentIndex;
	public static Player[] scores;

	// return current rank
	public static int rank(int score) {

		Player alice = scores[currentIndex];
		alice.score = score;
		
		for (int i = currentIndex - 1; i >= 0; i--) {
			Player p = scores[i];
			if (p.score.equals(alice.score)) {
				// Just insert the player in the scores array.
				// Don't do ranking calculation.
				alice.rank = p.rank;
				insert(i + 1, alice, false);
				//decrease right candidates rank by 1
				updateRank(currentIndex + 1, scores.length, -1);
				currentIndex = i + 1;
				break;
			} else {
				if (p.score.intValue() > alice.score.intValue()) {
					alice.rank = p.rank + 1;
					if(i != currentIndex - 1) {
						insert(i + 1, alice, true);
						currentIndex = i + 1;
					}
					break;
				} else {
					if (p.score.intValue() < alice.score.intValue()) {
						/**
						 * Alice score is maximum, even greater than the first ranker.
						 * So do needful.
						 */
						if(i == 0) {
							alice.rank = scores[i].rank;
							insert(i, alice, true);
							updateRank(currentIndex + 1, scores.length, 1);
							currentIndex = i;
							break;
						}
						continue;
					}
				}
			}
		} // for-loop ends here
		return alice.rank;
	}

	/**
	 * 
	 * @param start Start Index
	 * @param end End Index
	 */
	static void updateRank(int start, int end, int value) {
		for(int i = start; i < end; i++) {
			scores[i].rank = scores[i].rank + value;
		}
	}
	
	static void insert(int index, Player alice, boolean reranking) {
		Player temp = null;
		for(int i = index; i < currentIndex + 1; i++) {
			temp = scores[i];
			if(reranking && i != currentIndex)
				temp.rank += 1;
			scores[i] = alice;
			alice = temp;
		}
	}

	static class Player {
		Integer score;
		Integer rank;

		public String toString() {
			return String.format("[%d - %d]", score, rank);
		}
		
		static Player build(){
			return new Player();
		}
		
		Player score(Integer score) {
			this.score = score;
			return this;
		}
		
		Player rank(Integer rank) {
			this.rank = rank;
			return this;
		}
	}

	public static void main(String[] args) {
		int n = 7; // number of players before Alice.
		scores = new Player[]{
			Player.build().score(100).rank(1),
			Player.build().score(100).rank(1),
			Player.build().score(50).rank(2),
			Player.build().score(40).rank(3),
			Player.build().score(40).rank(3),
			Player.build().score(20).rank(4),
			Player.build().score(10).rank(5),
			Player.build()
		};
		currentIndex = n;
		
		System.out.println(rank(5));
		System.out.println(rank(25));
		System.out.println(rank(50));
		System.out.println(rank(120));
	}
	
}
