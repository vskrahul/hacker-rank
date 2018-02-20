/**
 * 
 */
package com.vsk.rahul.algo.string.dp;

import java.util.LinkedList;
import java.util.List;

import com.vsk.rahul.utils.StringUtils;

/**
 * @author Rahul Vishvakarma
 *
 */
public class CoinChangeProblem {

	static long getAlbertWays(int n, int[] coins) {
		
		long[][] store = new long[coins.length][n + 1];
		
		
		for(int x = 1; x <= n; x++) {
			
			
			for(int i = 0; i < coins.length; i++) {
				
				if(x-coins[i] > 0 && store[i][x-coins[i]] != 0) {
					store[i][x] = store[i][x-coins[i]] + (i > 0 ? store[i - 1][x] : 0);
				} else {
					if(x%coins[i] == 0) {
						if(i > 0) 
							store[i][x] = 1 + store[i - 1][x];
						else 
							store[i][x] = 1;
					} else {
						if(i > 0)
							store[i][x] = store[i - 1][x];
						else
							store[i][x] = 0;
					}
				}
				
			}
			
		}
		
		System.out.println(StringUtils.toString(store));
		
		return store[coins.length - 1][n];
	}
	
	static long getWays(long n, long[] coins) {
		
		int p1 = 0;
		int p2 = 1;
		
		long count = 0;
		
		while(p1 < coins.length - 1) {
			count += itSelf(n, coins[p1]);
			while(p2 < coins.length) {
				count += withOther(n, coins[p1], coins[p1]);
				p2++;
			}
			p1++;
			p2 = p1 + 1;
		}
		return count;
    }
	
	static long getWays_A(long n, long[] coins) {
		
		long count = 0;
		List<Long> store = new LinkedList<>();
		List<Long> subStore = new LinkedList<>();
		
		for(int p1 = 0; p1 < coins.length; p1++) {
			count += itSelf(n, coins[p1]);
			
			for(Long v : store) {
				count += withOther(n, v, coins[p1]);
				if(coins[p1] + v < n) insert(subStore, coins[p1] + v);
			}
			subStore.add(coins[p1]);
			merge(store, subStore);
		}
		return count;
	}
	
	static void insert(List<Long> list, long value) {
		int i = 0;
		for(Long v : list) {
			if(v == value) {
				i = -1; 
				break;
			}
			if(value < v)
				break;
			i++;
		}
		if(i != -1) list.add(i, value);
	}
	
	static void merge(List<Long> store, List<Long> subStore) {
		subStore.forEach(v -> insert(store, v));
		subStore.clear();
	}
	
	static long itSelf(long n, long v) {
		return n%v == 0 ? 1 : 0;
	}
	
	static long withOther(long n, long x, long y) {
		
		long count = 0;
		int f = 1;
		
		while(true) {
			if(f*y >= n)
				break;
			if((n - f*y)%x == 0)
				count++;
			f++;
		}
		return count;
	}
	
	public static void main(String[] args) {
        int n = 10;
        int[] coins = new int[] {2, 3, 5, 6};
        System.out.println(getAlbertWays(n, coins));
	}

}
