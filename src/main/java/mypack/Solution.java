package mypack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	Map<Integer, Product> day = new HashMap<>();
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		for(int i = 0; i < T; i++) {
			
			String word = in.nextLine();
			char c[] = new char[word.length()];
			
			//save SELL data
			if(c[0] == 'S') {
				int day = Character.getNumericValue(c[2]);
				
			} else {
				// Query the data and print the result
			}
		}
	}
}

class Product {
	
	Integer category;
	
	Integer region;
	
	Integer state;
}