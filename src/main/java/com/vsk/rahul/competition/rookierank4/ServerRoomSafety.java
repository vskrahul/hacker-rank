/**
 * 
 */
package com.vsk.rahul.competition.rookierank4;

/**
 * @author Rahul Vishvakarma
 *
 */
public class ServerRoomSafety {

	static String checkAll(int n, int[] height, int[] position) {
		
		if(n <= 1) {
			return "NONE";
		}
		
		boolean left = left(position[0], height[0], position[1]);
		boolean right = right(position[n - 1], height[ n - 1], position[n - 2]);

		for (int i = 2; i < n; i++) {
			if(left) {
				left = left(position[i - 1], height[i - 1], position[i]);
				int j = i + 1;
				while(j < n && left(position[i - 1], height[i - 1], position[j])) {
					j++;
				}
				i = j - 1;
				continue;
			}
			break;
		}
		
		for (int i = n - 2; i > 0; i--) {
			if(right) {
				right = right(position[i], height[i], position[i - 1]);
				
				int j = i - 1;
				while(j > 0 && right(position[i], height[i], position[j])) {
					j--;
				}
				i = j + 1;
				continue;
			}
			break;
		}
		return result(left, right);
	}
	
	public static String result(boolean left, boolean right) {
		if(left) {
			if(right) {
				return "BOTH";
			}
			return "LEFT";
		} else {
			if(right) {
				return "RIGHT";
			}
		}
		return "NONE";
	}
	
	public static boolean left(int position, int height, int nextPosition) {
		return position + height >= nextPosition;
	}
	
	public static boolean right(int position, int height, int previousPosition) {
		return position - height <= previousPosition;
	}

	public static void main(String[] args) {
        int[] position = new int[]{1, 2, 12};
        int[] height = new int[]{1, 10, 11};
        
        System.out.println(checkAll(3, height, position));
	}
}