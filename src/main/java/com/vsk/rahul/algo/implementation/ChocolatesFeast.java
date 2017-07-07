/**
 * 
 */
package com.vsk.rahul.algo.implementation;

/**
 * @author Rahul
 *
 */
public class ChocolatesFeast {

	static int chocolates(int money, int price, int wrapper) {
		int totalChocolates = money/price;
		//total wrappers bobby has
		int w = totalChocolates;
		
		while(w >= wrapper) {
			// (w/wrapper) --> earned chocolates
			totalChocolates = totalChocolates + w/wrapper;
			
			//current wrapper = earned wrapper + remaining wrapper
			w = w/wrapper + w%wrapper;
		}
		return totalChocolates;
	}
}