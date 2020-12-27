package com.tokoin.test;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {
	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
	
		Result result = junit.run(
				UserUnitTest.class, 
				TicketUnitTest.class,
				OrganizationUnitTest.class);
	
		resultReport(result);
	}
	
	public static void resultReport(Result result) {
	    System.out.println("Finished. Result: Failures: " +
	      result.getFailureCount() + ". Ignored: " +
	      result.getIgnoreCount() + ". Tests run: " +
	      result.getRunCount() + ". Time: " +
	      result.getRunTime() + "ms.");
	}
}
