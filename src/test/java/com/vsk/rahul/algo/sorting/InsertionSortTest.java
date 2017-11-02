/**
 * 
 */
package com.vsk.rahul.algo.sorting;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Rahul
 *
 */
public class InsertionSortTest {

	@Test(enabled = true)
	public void test() {
		
		List<Integer> list = new ArrayList<>();
		
		list.add(5);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(2);
		
		Sorting<Integer> sorting = new InsertionSort<>(list);
		sorting.sort(null);
		
		Integer i = 1;
		for(Integer x : list) {
			Assert.assertEquals(x, i++);
		}
	}
}