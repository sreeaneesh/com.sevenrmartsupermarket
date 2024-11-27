package com.sevenrmartsupermarket.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//if test cases are failure , repeat several times

public class RetryAnalyzer implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 3;

	public boolean retry(ITestResult itestresult) {
		if (itestresult.getStatus() == ITestResult.FAILURE && counter < retryLimit) {
			counter++;
			return true;

		} else {
			return false;
		}

	}

}
