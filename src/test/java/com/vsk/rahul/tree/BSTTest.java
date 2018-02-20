/**
 * 
 */
package com.vsk.rahul.tree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.Reporter;
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
		
		bst.heightOfEachNode();
		
		int sum = store.entrySet().stream().mapToInt(Map.Entry::getValue).sum();
		
		int height = store.entrySet().stream().mapToInt(Map.Entry::getValue).max().getAsInt();
		
		Reporter.log(String.format("root node height = %d", height), true);
		Assert.assertEquals(height, out.nextInt());
		
		Reporter.log(String.format("Sum of heights = %d", sum), true);
		Assert.assertEquals(sum, out.nextInt());
		
		in.close();
		out.close();
	}
}
