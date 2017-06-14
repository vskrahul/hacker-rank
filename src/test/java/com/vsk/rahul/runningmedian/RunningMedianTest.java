/**
 * 
 */
package com.vsk.rahul.runningmedian;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import org.testng.annotations.Test;

import junit.framework.Assert;

/**
 * @author Rahul
 *
 */
public class RunningMedianTest {

	static final String TEST_CASE_NAME = "runningmedian";
	
	static final int TEST_CASE_NUMBER = 4;
	
	Logger logger = Logger.getLogger("RunningMedianTest.class");
	
	private Scanner inScanner() {
    	return new Scanner(RunningMedian.class.getResourceAsStream(String.format("/%s/%s", TEST_CASE_NAME, String.format("IN_%d.txt", TEST_CASE_NUMBER))));
    }
	
	private Scanner outScanner() {
    	return new Scanner(RunningMedian.class.getResourceAsStream(String.format("/%s/%s", TEST_CASE_NAME, String.format("OUT_%d.txt", TEST_CASE_NUMBER))));
    }
	
	@Test(enabled = false, timeOut = 4000)
	public void check() {
		Scanner in = inScanner();
		Scanner out = outScanner();
		List<Double> result = RunningMedian.start(in);
		//logger.info(result.toString());
		result.forEach(ad -> {
				double ed = Double.valueOf(out.next());
				//logger.info(String.format("%f v/s %f", ed, ad));
				 Assert.assertEquals(ed, ad);
			 });
		in.close();
	}
}