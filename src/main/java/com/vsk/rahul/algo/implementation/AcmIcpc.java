/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import com.vsk.rahul.utils.NumberCombinations;

/**
 * @author Rahul
 *
 */
public class AcmIcpc {

	public static int[] numberArr(int N) {
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = i + 1;
		return arr;
	}
	
	public int[] maxPossibleScore(int subjects[][], int M, int N) {
		
		NumberCombinations[] numComb = NumberCombinations.combinations(numberArr(N), 2);
        
        int maxScore = -1;
        int teamScore = 0;
        
        for(NumberCombinations nc : numComb) {
        	int p1 = nc.getOne() - 1;
        	int p2 = nc.getTwo() - 1;
        	for(int i = 0; i < M; i++) {
        		if(subjects[p1][i] == 1 || subjects[p2][i] == 1) {
        			teamScore += 1;
        		}
        	}
        	nc.setScore(teamScore);
        	if(teamScore > maxScore)
        		maxScore = teamScore;
        	teamScore = 0;
        }
        int count = 0;
        for(NumberCombinations nc : numComb) {
        	if(maxScore == nc.getScore()) {
        		count += 1;
        	}
        }
        return new int[]{maxScore, count};
	}
}