/**
 * 
 */
package com.vsk.rahul.algo.implementation;

/**
 * <p>SaveThePrisoner class.</p>
 *
 * @author Rahul
 * @version $Id: $Id
 */
public class SaveThePrisoner {
	
	static int saveThePrisoner(int n, int m, int s){
        int id = -1;
        // loop executing for all number of sweets.
        for(int i = 0; i < m; i++) {
            id = s%n;
            s++;
        }
        return id == 0 ? n : id;
    }
}
