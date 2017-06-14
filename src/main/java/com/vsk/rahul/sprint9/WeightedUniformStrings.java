package com.vsk.rahul.sprint9;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class WeightedUniformStrings {
	
	static int[] a = null;
	
	public static void main(String[] args) 	{
		Scanner in = new Scanner(System.in);
		String s = in.next();
		setArray(s);
		int n = in.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			validate(in.nextInt());
		}
		in.close();
	}
	
	public static String validate(int x) {
		String status = "";
		if(inArray(x)) {
			status = "Yes";
		} else {
			status = "No";
		}
		System.out.println(status);
		return status;
	}
	
	public static int[] weight(char[] chars) {
		int[] a = new int[chars.length];
		for(int i = 0; i < chars.length; i++ ) {
			a[i] = weight(get(chars, i));
			if(i + 1 < chars.length) {
				while(get(chars, i + 1) == get(chars, i)) {
					a[i + 1] = a[i] + weight(get(chars, i + 1));
					i++;
				}
			}
		}
		return a;
	}
	
	static char get(char[] arr, int idx) {
		char c = ' ';
		try {
			c = arr[idx];
		} catch(IndexOutOfBoundsException e) {
			System.out.println(String.format("%s%d", e.toString(), idx));
		}
		return c;
	}
	
	public static int weight(char c) {
		return c - 96;
	}
	
	public static boolean inArray(int value) {
		boolean f = false;
		for(int i : a) {
			if(i == value){
				f = true;
				break;
			}
		}
		return f;
	}
	
	public static void setArray(String s) {
		char[] c = s.toCharArray();
		System.out.println(String.format("Length of aray... %d", c.length));
		WeightedUniformStrings.a = weight(c);
	}
}