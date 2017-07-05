/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Rahul
 *
 */
@Test(enabled = false)
public class EncryptionTest {

	public void rowsAndColumnTest() {
		int [] rowsAndColumns = Encryption.rowsAndColumns(54);
		Assert.assertEquals(rowsAndColumns[0], 7);
		Assert.assertEquals(rowsAndColumns[1], 8);
		
		rowsAndColumns = Encryption.rowsAndColumns(12);
		Assert.assertEquals(rowsAndColumns[0], 3);
		Assert.assertEquals(rowsAndColumns[1], 4);
	}
	
	public void pickTest() {
		Assert.assertEquals(Encryption.pick(0, 4, "haveaniceday"), "hae");
		Assert.assertEquals(Encryption.pick(1, 4, "haveaniceday"), "and");
		Assert.assertEquals(Encryption.pick(2, 4, "haveaniceday"), "via");
		Assert.assertEquals(Encryption.pick(3, 4, "haveaniceday"), "ecy");
	}
	
	public void encrypt() {
		Assert.assertEquals(Encryption.encrypt("have a nice day"), "hae and via ecy");
	}
}