/**
 * 
 */
package com.vsk.rahul.algo.sorting;

import java.util.Comparator;

/**
 * Interface to consolidate sorting algorithms.
 * 
 * @author Rahul
 *
 */
public interface Sorting<T> {

	/**
	 * Sort the given sequence of items.
	 * 
	 * @param comparator - {@link Comparator}
	 */
	public void sort(Comparator<T> comparator);
}