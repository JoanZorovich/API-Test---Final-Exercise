package org.bank.test;

import org.bank.utils.reporter.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class extended from {@link org.bank.test.BaseTest}
 */
public class PostUsersTest extends BaseTest{
    @Test
    /**
     * Allows validating that all users (in this case 10) were successfully created on the endpoint
     * Valid if all creation statuses were 201
     */
    public void createTenUsersTest(){
        Reporter.info("------------ TEST 2 -----------------");

        Reporter.info("validate that all users are created successfully");
        Assert.assertTrue(postUsers(),"User post fails!");



    }
}
