package com.vsk.rahul.utils;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

	public static <T> List<T> initializeListOfFixedSize(int size) {
		List<T> list = new ArrayList<>(size);
		
		for(int i = 0; i < size; i++)
			list.add(null);
		
		return list;
	}
	
	public static List<List<Integer>> initializeAdjacencyListOfFixedSize(int size) {
		List<List<Integer>> list = new ArrayList<>(size);
		
		for(int i = 0; i < size; i++)
			list.add(new ArrayList<>());
		
		return list;
	}
	
	public static <T> List<List<T>> initializeAdjacencyListOfFixedSizeT(int size) {
		List<List<T>> list = new ArrayList<>(size);
		
		for(int i = 0; i < size; i++)
			list.add(new ArrayList<>());
		
		return list;
	}
}
