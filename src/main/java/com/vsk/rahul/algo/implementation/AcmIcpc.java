/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.util.Scanner;

/**
 * <p>AcmIcpc class.</p>
 *
 * @author Rahul
 * @version $Id: $Id
 */
public class AcmIcpc {

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();

		int topics[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			int[] a = new int[M];
			int ci = 0;
			String s = in.next();
			for (char c : s.toCharArray()) {
				a[ci] = Character.getNumericValue(c);
				ci++;
			}
			topics[i] = a;
		}
		int[] result = maxPossibleScore(topics, N, M);
		System.out.println(result[0]);
		System.out.println(result[1]);
		in.close();
	}
	
	/**
	 * <p>maxPossibleScore.</p>
	 *
	 * @param topics an array of int.
	 * @param N a int.
	 * @param M a int.
	 * @return an array of int.
	 */
	public static int[] maxPossibleScore(int[][] topics, int N, int M) {
		int maxScore = -1;
		int count = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int m = i + 1; m < N; m++) {
				int mkt = 0;

				for (int x = 0; x < M; x++) {
					mkt += (topics[i][x] == 1 || topics[m][x] == 1) ? 1 : 0;
				}

				if (mkt > maxScore) {
					maxScore = mkt;
					count = 1;
				} else {
					if (maxScore == mkt)
						count += 1;
				}
			}
		}
		return new int[]{maxScore, count};
	}
}
