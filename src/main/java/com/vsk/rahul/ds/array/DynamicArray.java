/**
 * 
 */
package com.vsk.rahul.ds.array;

/**
 * @author Rahul
 *
 */
public class DynamicArray {

	static int size(int value) {
		return (new String(value + "")).length();
	}

	static int append(int source, int target) {
		if (source == 0) {
			if (target == 0)
				return 0;
			return target;
		} else {
			if (target == 0)
				return source;
			return Integer.parseInt(source + "" + target);
		}
	}

	static int get(int[] arr, int idx) {
		int item = 0;
		try {
			item = arr[idx];
		} catch (ArrayIndexOutOfBoundsException e) {
			item = 0;
		}
		return item;
	}
}
