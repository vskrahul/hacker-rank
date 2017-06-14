/**
 * 
 */
package com.vsk.rahul.runningmedian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author Rahul
 *
 */
public class RunningMedian {

	static Logger logger = Logger.getLogger("RunningMedian");
	
	static long[] arr = null;
	
	public static void main(String args[]) throws Exception {
        
        Scanner in = new Scanner(System.in);
        start(in);
        in.close();
    }
	
	public static List<Double> start(Scanner in) {
		arr = new long[in.nextInt()];
        List<Double> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            long v = in.nextLong();
            add(v, i);
            result.add(median(i+1));
        }
        return result;
	}
	
	static double median(int length) {
        if(length%2 == 0) {
            int i1 = length == 2 ? 0 : length/2 -1;
            int i2 = length == 2 ? 1 : length/2;
            double v1 = arr[i1];
            double v2 = arr[i2];
            //System.out.println((v1 + v2)/2.0);
            return (v1 + v2)/2.0;
        } else {
            int i1 = length == 1 ? 0 : length/2;
            Double v = arr[i1]*1.0;
            //System.out.println(v);
            return v;
        }
    }
    
    static void add(long value, int currentLength) {
        int c = 0;

        for(int i = 0; i < currentLength; i++) {
            if(value > arr[i]) {
                c++;
                continue;
            }
            break;
        }
        shiftRight(c + 1, currentLength);
        arr[c] = value;
        //logger.info(String.format("[%d]=%d,", c, value));
    }
    
    static void shiftRight(int start, int length) {
        
        for(int i = length; i >= start; i--) {
            arr[i] = arr[i-1];
        }
    }
}
