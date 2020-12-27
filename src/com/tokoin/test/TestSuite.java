package com.tokoin.test;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  UserUnitTest.class,
  TicketUnitTest.class,
  OrganizationUnitTest.class,
})
public class TestSuite {
	
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
