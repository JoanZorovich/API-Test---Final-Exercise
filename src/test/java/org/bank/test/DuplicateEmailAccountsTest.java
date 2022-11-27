package org.bank.test;

import org.bank.utils.reporter.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DuplicateEmailAccountsTest extends BaseTest {
    @Test
    public void avoidDuplicateEmailsTest(){

        Reporter.info("------------ TEST 3 -----------------");

        Reporter.info("Validate a successful get request from the endpoint");
        Assert.assertEquals(checkGetStatus(), 200, "Status Check Failed!");

        Reporter.info("Validate that there is no duplicate email");
        Assert.assertTrue(checkDuplicateUsersEmail(),"There are duplicate emails");



    }
}
