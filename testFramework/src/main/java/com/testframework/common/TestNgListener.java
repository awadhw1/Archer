package com.testframework.common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNgListener implements ITestListener {
	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error "+result.getName()+" test has failed . Capturing Screenshot *****");
		String methodName=result.getName().toString().trim();
		DriverMethods.takeScreenShot(methodName);
	}

	public void onFinish(ITestContext context) {
		System.out.println("******* TEST RESULT *******");
		System.out.println("Passed Test : " + context.getPassedTests().size());
		System.out.println("Failed Test :" + context.getFailedTests().size());
		System.out.println("Skipped Test :" + context.getSkippedTests().size());
		System.out.println("**************************");
	}

	public void onTestStart(ITestResult result) {   }

	public void onTestSuccess(ITestResult result) {   }

	public void onTestSkipped(ITestResult result) {   }

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

	public void onStart(ITestContext context) {   }
}  