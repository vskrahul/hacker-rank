package com.vsk.rahul.competition.woc36;

public class RaceAgainstTime {
	
	public int[] heights;
	
	public int[] prices;
	
	public int n = 0;
	
	public int mason_height = 0;
	
	public int time() {
		int start = 0;
		int end = 0;
		
		int cost = 0;
		int startHeight = mason_height;
		
		for(int i = start; i < n - 1; i++) {
			
			if(startHeight >= heights[i]) {
				continue;
			}
			for(int j = start; j < i; j++) {
				
				for(int k = j; k < i; k++) {
					if(k == start)
						cost += modulus(startHeight, heights[k]);
					else
						cost += modulus(heights[k], heights[k + 1]);
				}
			}
		}
		cost += n - start;
		return cost;
	}
	
	public int[] _time(int start, int end) {
		if(end - 1 == start)
			return new int[]{cost(start, end), end};
		if(cost(start, end) > cost(start, end - 1))
			return _time(start, end - 1);
		return new int[]{cost(start, end), end};
	}
	
	int cost(int start, int end) {
		int cost = 0;
		
		for(int i = start; i < end; i++) {
			cost++;
		}
		cost = cost + modulus(heights[start], heights[end]) + prices[end];
		return cost;
	}
	
	int modulus(int i, int j) {
		return i > j ? i - j : j - i;
	}
	
	public static RaceAgainstTime instance() {
		return new RaceAgainstTime();
	}
}