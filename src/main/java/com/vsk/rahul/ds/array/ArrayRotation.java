/**
 * 
 */
package com.vsk.rahul.ds.array;

/**
 * @author Rahul
 *
 */
public class ArrayRotation {

	/**
	 * Rotate the array using extra space of O(a[])
	 * 
	 * @param a Array
	 * @param d Degree of rotation
	 * @return Rotated Array
	 */
	public static int[] rotation(int[] a, int d) {
        int rotation = d%a.length;
        
        int[] result = new int[a.length];
        
        for(int i = 0; i < a.length; i++) {
            result[index(rotation, i, a.length, true)] = a[i];
        }
        return result;
    }
	
	/**
	 * Rotate the array.
	 * 
	 * @param a array
	 * @param d degree
	 * @param leftRotation rotation type, {@code true} for left and {@code false} for right rotation.
	 */
	public static void rotation(int[] a, int d, boolean leftRotation) {
		int rotation = d%a.length;
		
		int temp2 = a[0];
		int temp1 = 0;
		for(int i = 0; i < a.length; i++) {
			int futureIndex = index(rotation, i, a.length, leftRotation);
			temp1 = a[futureIndex];
			a[futureIndex] = temp2;
			temp2 = temp1;
		}
	}
    
	/**
	 * <p>
	 * Rotation index function.
	 * <p>
	 * Pass the current index and get the future index.
	 * 
	 * @param rotation - Degree of rotation
	 * @param index - Current Index of Element
	 * @param N - Length of the array
	 * @param leftRotation {@code true} for left rotation and {@code false} for right rotation
	 * @return Future index of the element
	 */
    static int index(int rotation, int index, int N, boolean leftRotation) {
        return leftRotation 
        		? index < rotation ? N - rotation + index : index - rotation
        		: index + rotation < N ? index + rotation : (index + rotation)%N;
    }
} 