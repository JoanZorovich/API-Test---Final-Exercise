package org.bank.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.bank.utils.Reporter.info;

public class Listener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result){
        info("Test: " + result.getName() + " [PASSED]");
    }

    @Override
    public void onTestFailure(ITestResult result){
        Reporter.error("Test: " + result.getName() + " [FAILED]");
    }
}
