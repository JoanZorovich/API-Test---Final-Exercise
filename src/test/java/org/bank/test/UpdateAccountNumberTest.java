package org.bank.test;

import org.bank.utils.reporter.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateAccountNumberTest extends BaseTest{
    @Test
    public void updateUserAccountNumberTest(){

        Reporter.info("------------ TEST 4 -----------------");

        Reporter.info("Validate the user has the new account number");
        Assert.assertTrue(isAnUpdatedAccountNumber(),"Account number is not updated");

        Reporter.info("Validate a successful put request from the endpoint");
        Assert.assertEquals(res.statusCode(), 200, "Status Check Failed!");

    }
}
