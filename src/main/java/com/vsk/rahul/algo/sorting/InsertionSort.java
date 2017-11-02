/**
 * 
 */
package com.vsk.rahul.algo.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author Rahul
 *
 */
public class InsertionSort<T> implements Sorting<T> {

	private List<T> list = null;
	
	public int insertion_sort_swap = 0;
	
	public InsertionSort(List<T> list) {
		this.list = list;
	}
	
	public InsertionSort() {
		
	}
	
	public void sort(int[] arr) {
		
		for(int index = 1; index < arr.length; index++) {
			int key = arr[index];
			int j = index - 1;
			
			while(j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				insertion_sort_swap++;
				j--;
			}
			arr[j + 1] = key;
		}
	}
	
	public void sort(Comparator<T> comparator) {
		
		for(int index = 1; index < list.size(); index++) {
			T key = list.get(index);
			int j = index - 1;
			
			while(j >= 0 && compare(list.get(j), key, comparator) > 0) {
				list.set(j + 1, list.get(j));
				insertion_sort_swap++;
				j--;
			}
			list.set(j + 1, key);
			insertion_sort_swap++;
		}
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	private int compare(T thisInstance, T anotherInstance, Comparator<T> comparator) {
		if(Objects.isNull(comparator)) {
			return ((Comparable)thisInstance).compareTo(anotherInstance);
		}
		return comparator.compare(thisInstance, anotherInstance);
	}
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}