/**
 * 
 */
package com.vsk.rahul.tree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Rahul Vishvakarma
 *
 */
public class BSTTest {

	@Test
	public void test() {
		Scanner in = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "tree/bst", "1_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "tree/bst", "1_OUT.data")));
		
		int n = in.nextInt();
		
		BST bst = new BST();
		
		for(int i = 0; i < n; i++)
			bst.insertRecur(in.nextInt());
		
		Map<Integer, Integer> store = new LinkedHashMap<>();
		
		int height = bst.height(bst.root(), store);
		
		Assert.assertEquals(height, out.nextInt());
		
		int sum = store.entrySet().stream().mapToInt(Map.Entry::getValue).sum();
		
		Assert.assertEquals(sum, out.nextInt());
		
		in.close();
		out.close();
	}
}
