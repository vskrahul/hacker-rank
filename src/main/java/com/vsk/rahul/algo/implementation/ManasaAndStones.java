/**
 * 
 */
package com.vsk.rahul.algo.implementation;

/**
 * @author Rahul
 *
 */
public class ManasaAndStones {

	public static String stones(int n, int a, int b) {
        StringBuffer sb = new StringBuffer();
        int diff = b - a;
        int max = n*b;
        int min = n*a;
        
        for(int i = min; i <= max; i = i + diff)
            sb.append(String.format("%d ", i));
        return sb.toString().trim();
    }
}