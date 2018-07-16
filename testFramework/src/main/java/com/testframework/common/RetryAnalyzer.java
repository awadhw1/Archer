package com.testframework.common;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	static Logger log = Logger.getLogger(RetryAnalyzer.class);

	private static int MAX_RETRY_COUNT = 0;

	AtomicInteger count = new AtomicInteger(MAX_RETRY_COUNT);

	public boolean isRetryAvailable() {
		return (count.intValue() > 0);
	}

	public boolean retry(ITestResult result) {
		boolean retry = false;
		if (isRetryAvailable()) {
			log.info("Going to retry test case: " + result.getMethod() + ", "
					+ (MAX_RETRY_COUNT - count.intValue() + 1) + " out of "
					+ MAX_RETRY_COUNT);
			retry = true;
			count.decrementAndGet();
		}
		return retry;
	}

}
