package org.bank.test;

import org.bank.utils.reporter.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class extended from {@link org.bank.test.BaseTest}
 */

public class DuplicateEmailAccountsTest extends BaseTest {
    @Test
    /**
     *Allows validating that the emails of the users registered in the endpoint are not repeated
     * Validates that the status obtained after performing the query was successful
     */
    public void avoidDuplicateEmailsTest(){

        Reporter.info("------------ TEST 3 -----------------");

        Reporter.info("Validate a successful get request from the endpoint");
        Assert.assertEquals(checkGetStatus(), 200, "Status Check Failed!");

        Reporter.info("Validate that there is no duplicate email");
        Assert.assertTrue(checkDuplicateUsersEmail(),"There are duplicate emails");



    }
}
