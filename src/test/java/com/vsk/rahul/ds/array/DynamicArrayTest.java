/**
 * 
 */
package com.vsk.rahul.ds.array;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Bad problem. Don't Try.
 * 
 * @author Rahul
 *
 */
public class DynamicArrayTest {

	@Test(enabled = false)
	public void check() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "data_structure/array", "dynamic_array_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(
									String.format("/%s/%s", "data_structure/array", "dynamic_array_OUT.data")));

		int N = in.nextInt();
		int Q = in.nextInt();

		int[] seqList = new int[N];

		int lastAnswer = 0;
		
		for (int i = 0; i < Q; i++) {

			int queryType = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();

			int idx = (x ^ lastAnswer) % N;

			if (queryType == 1) {
				int seq = DynamicArray.get(seqList, idx);
				seqList[idx] = DynamicArray.append(seq, y);
			} else {
				int seq = DynamicArray.get(seqList, idx);
				lastAnswer = y % DynamicArray.size(seq);
				Assert.assertEquals(out.nextInt(), lastAnswer);
			}
		}
		
		in.close();
		out.close();
	}
}
