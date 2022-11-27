package org.bank.utils.listener;

import org.bank.utils.reporter.Reporter;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.bank.utils.reporter.Reporter.info;

/**
 * lister class to configure and customize listeners
 * @author joan.zorovich
 */

public class Listener implements ITestListener {

    @Override
    /**
     * Displays information in the console when the test was successful
     * @author joan.zorovich
     */
    public void onTestSuccess(ITestResult result){
        info("Test: " + result.getName() + " [PASSED]");
    }

    @Override

    /**
     * Displays information in the console when the test failed
     * @author joan.zorovich
     */
    public void onTestFailure(ITestResult result){
        Reporter.error("Test: " + result.getName() + " [FAILED]");
    }
}
