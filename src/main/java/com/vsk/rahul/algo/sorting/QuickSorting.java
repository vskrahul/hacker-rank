/**
 * 
 */
package com.vsk.rahul.algo.sorting;

import java.util.Arrays;

/**
 * @author Rahul
 *
 */
public class QuickSorting {

	private static int quick_sort_swap = 0;
	
	public static void sorting(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	private static void quickSort(int[] arr, int low, int high) {
		if(low < high) {
			int pi = pivot(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
	
	private static int pivot(int[] arr,  int low, int high) {
		int pivot = arr[high];
		
		int i = low;
		
		for(int j = low; j < high; j++) {
			
			if(arr[j] < pivot) {
				swap(arr, i , j);
				i++;
			}
		}
		
		swap(arr, i, high);
		
		return i;
	}
	
	private static int pivotFirst(int[] arr,  int low, int high) {
		
		int pivot = arr[low];
		
		int i = high;
		
		for(int j = high; j > low; j--) {
			
			if(arr[j] > pivot) {
				swap(arr, i , j);
				i--;
			}
		}
		
		swap(arr, i, low);
		System.out.println(toString(arr));
		return i;
	}
	
	private static void swap(int[] arr, int i, int j) {
		quick_sort_swap++;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static String toString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for(int index = 0; index < arr.length; index++) {
			if(index == arr.length - 1) {
				sb.append(String.format("%d", arr[index]));
			} else {
				sb.append(String.format("%d ", arr[index]));
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1, 3, 9, 8, 2, 7, 5};
		int[] arr1 = Arrays.copyOf(arr, arr.length);
		sorting(arr1);
		System.out.println(quick_sort_swap);
		
		InsertionSort<Integer> is = new InsertionSort<>();
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		is.sort(arr2);
		System.out.println(is.insertion_sort_swap);
	}
}