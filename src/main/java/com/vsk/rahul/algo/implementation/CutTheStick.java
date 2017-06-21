/**
 * 
 */
package com.vsk.rahul.algo.implementation;

/**
 * @author Rahul
 *
 */
public class CutTheStick {

	public static void main(String[] args) {
		int N = 6;
		int a[] = new int[]{5, 4, 4, 2, 2, 8};

		int count = N;
		int min = 2;
		int tempMin = min;

        while (count != 1) {
            System.out.println(count);
			for (int i = 0; i < N; i++) {
				if(a[i] == 0)
					continue;

				a[i] = a[i] - min;

				if (min > a[i] && a[i] != 0)
					tempMin = a[i];

				if (a[i] == 0) {
					count = count - 1;
				}
			}
			min = tempMin;
		}
        System.out.println(count);
	}

}