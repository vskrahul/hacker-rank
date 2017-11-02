/**
 * 
 */
package com.vsk.rahul.algo.string;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Rahul
 *
 */
public class ContactListTest {

	@Test
	public void searchTest() {
		ContactList contacts = ContactList.instance();
		contacts.add("hacker");
		contacts.add("hack");
		contacts.add("hackerrank");
		contacts.add("rahul");
		contacts.add("ravsk");
		contacts.add("haccccc");
		contacts.add("xyzkhlhl");
		
		Assert.assertEquals(contacts.search("hack"), 3);
		Assert.assertEquals(contacts.search("hac"), 4);
		Assert.assertEquals(contacts.search("ra"), 2);
		Assert.assertEquals(contacts.search("rav"), 1);
		Assert.assertEquals(contacts.search("nothing"), 0);
		Assert.assertEquals(contacts.search("xyz"), 1);
	}
}
