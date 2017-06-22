/**
 * 
 */
package com.vsk.rahul.utils;

/**
 * @author Rahul
 *
 */
public class NumberCombinations {

	private Integer one;

	private Integer two;

	NumberCombinations(int one, int two) {
		this.one = one;
		this.two = two;
	}
	
	@Override
	public String toString() {
		return String.format("[%d, %d]", one, two);
	}
	
	@Override
	public boolean equals(Object obj) {
		NumberCombinations o = null;
		if(null != obj && obj instanceof NumberCombinations) {
			o = (NumberCombinations)obj;
			return o.one == this.one && o.two == this.two;
		}
		return false;
	}

	static NumberCombinations[] combinations(Integer[] arr, int set) {
		int comb = Mathematics.combinations(arr.length, set);
		NumberCombinations[] result = new NumberCombinations[comb];
		int index = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int k = i + 1; k < arr.length; k++) {
				result[index++] = new NumberCombinations(arr[i], arr[k]);
			}
		}
		return result;
	}

	public Integer getOne() {
		return one;
	}

	public void setOne(Integer one) {
		this.one = one;
	}

	public Integer getTwo() {
		return two;
	}

	public void setTwo(Integer two) {
		this.two = two;
	}
}