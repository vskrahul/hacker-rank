/**
 * 
 */
package com.vsk.rahul.utils;

/**
 * <p>NumberCombinations class.</p>
 *
 * @author Rahul
 * @version $Id: $Id
 */
public class NumberCombinations {

	private int one;

	private int two;
	
	private int score;

	NumberCombinations(int one, int two) {
		this.one = one;
		this.two = two;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return String.format("[%d, %d]", one, two);
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		NumberCombinations o = null;
		if(null != obj && obj instanceof NumberCombinations) {
			o = (NumberCombinations)obj;
			return o.one == this.one && o.two == this.two;
		}
		return false;
	}

	/**
	 * <p>combinations.</p>
	 *
	 * @param arr an array of int.
	 * @param set a int.
	 * @return an array of {@link com.vsk.rahul.utils.NumberCombinations} objects.
	 */
	public static NumberCombinations[] combinations(int[] arr, int set) {
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

	/**
	 * <p>Getter for the field <code>one</code>.</p>
	 *
	 * @return a int.
	 */
	public int getOne() {
		return one;
	}

	/**
	 * <p>Setter for the field <code>one</code>.</p>
	 *
	 * @param one a int.
	 */
	public void setOne(int one) {
		this.one = one;
	}

	/**
	 * <p>Getter for the field <code>two</code>.</p>
	 *
	 * @return a int.
	 */
	public int getTwo() {
		return two;
	}

	/**
	 * <p>Setter for the field <code>two</code>.</p>
	 *
	 * @param two a int.
	 */
	public void setTwo(int two) {
		this.two = two;
	}

	/**
	 * <p>Getter for the field <code>score</code>.</p>
	 *
	 * @return a int.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * <p>Setter for the field <code>score</code>.</p>
	 *
	 * @param score a int.
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
