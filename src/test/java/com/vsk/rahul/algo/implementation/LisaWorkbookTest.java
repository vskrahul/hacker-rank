/**
 * 
 */
package com.vsk.rahul.algo.implementation;

import java.util.Scanner;

import org.testng.annotations.Test;

/**
 * @author Rahul
 *
 */
public class LisaWorkbookTest {

	@Test(enabled = false)
	public void test() {
		Scanner in = new Scanner(this.getClass()
				.getResourceAsStream(String.format("/%s/%s", "implementation", "lisa_workbook_1_IN.data")));
		Scanner out = new Scanner(this.getClass().getResourceAsStream(String.format("/%s/%s", "implementation", "lisa_workbook_1_OUT.data")));
        int n = in.nextInt(); // number of chapter
        int pageSize = in.nextInt(); // number of problems on one page

        int[] problems = new int[n];
        int pageIndex = 1;
        int count = 0;

        for(int i = 0; i < n; i++) {
        	problems[i] = in.nextInt(); // number of problems in respective chapter

        	int pageRequired = problems[i] < pageSize ? 1 : problems[i]/pageSize + problems[i]%pageSize;
        	int tempPageIndex = pageIndex;
        	for(int p = 1; p <= problems[i]; p++) {
        		if(p == tempPageIndex)
        			count++;
        		if(p%pageSize == 0)
        			tempPageIndex++;
        	}
        	pageIndex += pageRequired;
        }
        int expected = out.nextInt();
        System.out.println(String.format("Actual: %d, Expected: %d", count, expected));
        in.close();
        out.close();
	}
}
