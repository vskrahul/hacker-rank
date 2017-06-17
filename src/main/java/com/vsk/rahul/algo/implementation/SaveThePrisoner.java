/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import org.testng.log4testng.Logger;

/**
 * @author Rahul
 *
 */
public class SaveThePrisoner {
	
	static Logger logger = Logger.getLogger(SaveThePrisoner.class);
	
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
