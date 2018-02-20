/**
 * 
 */
package com.vsk.rahul.ds.array;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vsk.rahul.algo.string.ContactList;

/**
 * @author Rahul
 *
 */
public class SparseArraysTest {

	
	@Test(testName = "Sparse arrays")
	public void check() {
		
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "data_structure/array", "sparse_arrays_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(
									String.format("/%s/%s", "data_structure/array", "sparse_arrays_OUT.data")));
		
		int N = in.nextInt();
		
		ContactList contactList = ContactList.instance();
		
		for(int i = 0; i < N; i++)
			contactList.add(in.next());
		
		int Q = in.nextInt();
		
		for(int j = 0; j < Q; j++) {
			String s = in.next();
			Assert.assertEquals(out.nextInt(), contactList.search(s, false));
		}
		
		in.close();
		out.close();
		
	}
}
