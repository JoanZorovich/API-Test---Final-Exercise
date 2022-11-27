package org.bank.test;

import org.bank.utils.reporter.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class extended from {@link org.bank.test.BaseTest}
 */
public class UpdateAccountNumberTest extends BaseTest{
    @Test
    /**
     * Allows validating that the information of the bank user has been updated with a new account number
     * Validates if the status of the modification was successful
     */
    public void updateUserAccountNumberTest(){

        Reporter.info("------------ TEST 4 -----------------");

        Reporter.info("Validate the user has the new account number");
        Assert.assertTrue(isAnUpdatedAccountNumber(),"Account number is not updated");

        Reporter.info("Validate a successful put request from the endpoint");
        Assert.assertEquals(res.statusCode(), 200, "Status Check Failed!");

    }
}
